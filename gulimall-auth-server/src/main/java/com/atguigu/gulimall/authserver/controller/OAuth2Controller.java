package com.atguigu.gulimall.authserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.atguigu.common.utils.HttpUtils;
import com.atguigu.common.utils.R;
import com.atguigu.gulimall.authserver.feign.MemberFeignService;
import com.atguigu.common.vo.MemberRespVo;
import com.atguigu.gulimall.authserver.vo.SocialUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@Controller
public class OAuth2Controller {
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    MemberFeignService memberFeignService;
    @GetMapping("/oauth2.0/weibo/success")
    public String weibo(@RequestParam("code") String code, HttpSession session) throws Exception {

        //https://gitee.com/oauth/token?grant_type=authorization_code&code={code}&client_id={client_id}&redirect_uri={redirect_uri}&client_secret={client_secret}
        Map<String, String> map = new HashMap<>();
        map.put("grant_type", "authorization_code");
        map.put("client_id","a2c4a197e7afb9b362783a188ec9b2d1cf24ca2f492c2caf96a1b53913d2892f");
        map.put("client_secret","1cd5937bb8fdbfac9d6c28564f22f79ff9be6b4f022c3851be734501d8b42256");
        map.put("redirect_uri","http://auth.gulimall.com/oauth2.0/weibo/success");
        map.put("code",code);
        HttpResponse response = HttpUtils.doPost("https://gitee.com", "/oauth/token", "post",new HashMap<String,String>(),null, map);
        if (response.getStatusLine().getStatusCode()==200) {

            String json = EntityUtils.toString(response.getEntity());
            SocialUser socialUser = JSON.parseObject(json, SocialUser.class);

            //拿到id
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://gitee.com/api/v5/user").queryParam("access_token",socialUser.getAccess_token());
            ResponseEntity<Map> entity = restTemplate.getForEntity(builder.toUriString(), Map.class);
            Map body = entity.getBody();
            JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(body));
            socialUser.setUid(jsonObject.getString("id"));
            socialUser.setJsonObject(jsonObject);
            R oauthlogin = memberFeignService.oauthlogin(socialUser);
            if(oauthlogin.getCode()==0){
                MemberRespVo data = oauthlogin.getData("data", new TypeReference<MemberRespVo>() {
                });

                log.info("登录成功，用户：{}",data.toString());
                session.setAttribute("loginUser",data);
                return "redirect:http://gulimall.com";
            }else {
                return "redirect:http://gulimall.com/login.html";
            }
        }else {
            return "redirect:http://gulimall.com/login.html";
        }
    }
}
