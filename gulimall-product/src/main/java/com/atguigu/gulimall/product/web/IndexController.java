package com.atguigu.gulimall.product.web;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import com.atguigu.gulimall.product.vo.Catelog2Vo;
import org.junit.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    RedissonClient redissonClient;
    @Autowired
    CategoryService categoryService;
    @GetMapping({"/","/index.html"})
    public String indexPage(Model model){
        List<CategoryEntity> categoryEntities= categoryService.getLevel1Category();
        model.addAttribute("categorys",categoryEntities);
        //查出所有的一级分类
        return "index";
    }

    @ResponseBody
    @GetMapping("/index/catalog.json")
    public Map<String,List<Catelog2Vo>> getCatalogJson(){
        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJson();
        return catalogJson;
    }

    @GetMapping("/hello")
    public String hello(){
        RLock lock = redissonClient.getLock("my-lock");
        try {
            System.out.println("加索成功...执行中"+Thread.currentThread().getId());
            Thread.sleep(10000);
        }catch (Exception e){

        }finally {
            System.out.println("释放锁"+Thread.currentThread().getId());
            lock.unlock();
        }
        return hello();

    }

}
