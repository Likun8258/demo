package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "demo")
public class DemoController {

    @GetMapping(value = "/test")
    public String test(){
        System.out.println("hahahhahha");
        System.out.println("jasdjkahds");
        return "哈哈哈哈😄";
    }

}
