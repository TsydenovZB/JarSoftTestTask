package com.zanabazar.JarSoftTestTask.controller;

import com.zanabazar.JarSoftTestTask.Service.RandomBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/bid")
public class RandomBannerController {

    @Autowired
    RandomBannerService randomBannerService;

    @GetMapping
    public ResponseEntity<String> getBanner(@RequestParam String category, HttpServletRequest request) {
        return randomBannerService.getBanner(category, request);
    }
}

