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
    @RequestMapping("/hello")
    public String index(@RequestParam String name) throws InterruptedException {
        Thread.sleep(60);

        String response = "这是provider-service1，参数：" + name;
        log.info("[Hello World API] response : {}", response);

        return response;
    }

    @PostMapping("/hello")
    @ResponseBody
    public String ribbonPost(@RequestBody String name) {
        return "这是服务提供者1，post请求,参数：" + name;
    }
}
