package com.boot.mvc20220916jaehyo.web.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Slf4j
@RestController
public class ResponseBodyController {

//    Logger LOGGER = LoggerFactory.getLogger(getClass());


    @GetMapping("/api/text")
    public String textGetReq(@RequestParam String value, @RequestParam int num) {
        return "파라미터 값: " + value + ", " + num;
    }

    @PostMapping("/api/text")
    public String textPostReq(@RequestParam String name, int age) {
        log.error("name: {}, {}, {}, {}", name, age, name, age);
        log.info("age: {}", age);
        return "name: " + name + ", age: " + age;
    }

    @PutMapping("/api/text")
    public String textPutReq() {
        log.info("put Request!!");
        return "풋요청에 대한 응답";
    }

    @DeleteMapping("/api/text")
    public String textDeleteReq() {
        return "Delete 요청에 대한 응답";
    }
}
