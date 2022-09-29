package com.boot.mvc20220916jaehyo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.model.IAttribute;

import java.time.LocalDateTime;

@Controller
public class PageController {

    @GetMapping({"/", "/index"})
    public String loadIndex(Model model) {
        model.addAttribute( "name", "서재효");
        return "index";
    }

    @GetMapping("/helloboot")
    public String loadHelloBoot(Model model) {
        model.addAttribute("nowDate", LocalDateTime.now());
        return "helloboot";
    }

    @GetMapping("/myinfo")
    public String loadMyInfo(Model model) {
        model.addAttribute("name", "서재효");
        model.addAttribute("age", "25");
        model.addAttribute("phone", "010-8803-2829");
        model.addAttribute("address", "부산 동래구");
        return "myinfo";
    }
}
