package com.imooc.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeiXinController {


    @RequestMapping("/auth")
    public void auth(@RequestParam("code") String code){
       System.out.println("进入auth方法");
       log.info("code={}",code);

       String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx137958ac7c70f66d&secret=db926844b47cbb18f91cce2da3eb7c24&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String access = restTemplate.getForObject(url,String.class);
        log.info("access的信息为：",access);

    }
}
