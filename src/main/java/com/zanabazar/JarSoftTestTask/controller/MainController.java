package com.zanabazar.JarSoftTestTask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    @RequestMapping("/")
    public String root (Map<String, Object> model) {
        return "forward:index.html";
    }
}
