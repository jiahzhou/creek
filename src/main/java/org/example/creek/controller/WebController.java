package org.example.creek.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creek")
public class WebController {

    @RequestMapping("/ping")
    public String ping() {
        return "ok";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return "Hello, " + name;
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam String name) {
        return "Hello, " + name;
    }

    @PostMapping("/hello3")
    public String getPid(@RequestBody HelloRequestDo helloRequestDo) {
        return "Hello, " + helloRequestDo.name;
    }

    static class HelloRequestDo {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
