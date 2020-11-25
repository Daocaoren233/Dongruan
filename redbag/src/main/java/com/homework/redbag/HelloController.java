package com.homework.redbag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    @RequestMapping()
    @PostMapping()
    public String sayHello(){

        return "Hello SpringBoot1";
    }
}
