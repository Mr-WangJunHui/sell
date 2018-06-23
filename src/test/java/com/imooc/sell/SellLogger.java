package com.imooc.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellLogger {
   // private final Logger logger = LoggerFactory.getLogger(SellLogger.class);//传入的必须为当前类


    @Test
    public void test1(){

        log.debug("debug...."); //10
        log.info("info....."); //20
        log.warn("warn.....");// 30
        log.error("error.....");//40
    }
}
