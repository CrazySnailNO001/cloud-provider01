package com.xzh.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author XZHH
 * @Description:
 * @create 2019/4/23 0023 12:03
 * @modify By:
 **/
@RestController
@Slf4j
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name) throws InterruptedException {

        Thread.sleep(60);
        String response = "[provider-service1 get hello API] ,RequestParam ：" + name;
        log.info("[Hello World API] response : {}", response);

        return response;
    }

    @GetMapping("/hystrix_timeout")
    public String hystrixTimeOut(@RequestParam long time) throws InterruptedException {
        log.info("[Provider-001 hystrixTimeOut API] get requestParam : [ {} ]", time);
        Thread.sleep(time);
        return "success";
    }

    @PostMapping("/hello")
    public String ribbonPost(@RequestBody String name) {
        return "这是服务提供者1，post请求,参数：" + name;
    }
}
