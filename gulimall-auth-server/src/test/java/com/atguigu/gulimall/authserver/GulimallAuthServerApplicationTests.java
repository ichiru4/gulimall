package com.atguigu.gulimall.authserver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class GulimallAuthServerApplicationTests {
  RestTemplate restTemplate = new RestTemplate();
    @Test
    void contextLoads() {
        Map<String, String> accessToken = new HashMap<>();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://gitee.com/api/v5/user").queryParam("access_token", "076cecc886a11e770d4c49241e515635");
        ResponseEntity<Map> entity = restTemplate.getForEntity(builder.toUriString(), Map.class);
        Map body = entity.getBody();
        String s = JSON.toJSONString(body);
        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println(jsonObject);
    }

}
