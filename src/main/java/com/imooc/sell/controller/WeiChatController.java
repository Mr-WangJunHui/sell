package com.imooc.sell.controller;


import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/wechat")
@Slf4j
public class WeiChatController {

    @Autowired
   private WxMpService wxMpService;

    @RequestMapping("/authorize")
    public String  authorize(@RequestParam("returnUrl") String returnUrl){
        //配置
        //调用方法
        String url = "http://sunshare.320.io:21863/sell/wechat/userInfo";
        String result= wxMpService.oauth2buildAuthorizationUrl(url,WxConsts.OAuth2Scope.SNSAPI_BASE,"");
        log.info("测试网页收取获取code",result);

        return "redirect:"+result;
    }


     @RequestMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                          @RequestParam("state") String returnUrl){
         WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
         try {
              wxMpOAuth2AccessToken =  wxMpService.oauth2getAccessToken(code);
         } catch (WxErrorException e) {
             //e.printStackTrace();
             throw new SellException(ResultEnum.GET_ACCESS_TOKEN_FAIL.getCode(),e.getError().getErrorMsg());
         }
         //System.out.println("用户的openId为："+wxMpOAuth2AccessToken.getOpenId());
         String openId = wxMpOAuth2AccessToken.getOpenId();
         log.info("openid为：",openId);
         return "redirect:"+returnUrl+"?openid="+openId;
    }



}
