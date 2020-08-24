package com.zanabazar.JarSoftTestTask.controller;

import com.zanabazar.JarSoftTestTask.Service.BannerService;
import com.zanabazar.JarSoftTestTask.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @PostMapping("/addBanner")
    public ResponseEntity<String> addBanner(@RequestBody Map<String, String> banner) {
        return bannerService.addBanner(banner);
    }

    @DeleteMapping("/{bannerId}")
    public ResponseEntity<String> deleteBanner(@PathVariable(value = "bannerId") Integer bannerId) {
        bannerService.deleteBanner(bannerId);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @GetMapping
    public Iterable<Banner> getAllBanners() {
        return bannerService.getAllBanners();
    }
}
