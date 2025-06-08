package org.example.creek.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/ping")
    public String ping() {
        return "ok";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return "Hello, " + name;
    }

    @PostMapping("/hello")
    public String getPid(@RequestBody HelloRequest request) {
        return "Hello, " + request.name;
    }

    @Getter
    @Setter
    public static class HelloRequest {
        String name;
    }
}
