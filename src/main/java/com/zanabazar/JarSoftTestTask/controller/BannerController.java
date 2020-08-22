package com.zanabazar.JarSoftTestTask.controller;

import com.zanabazar.JarSoftTestTask.entity.Banner;
import com.zanabazar.JarSoftTestTask.repository.BannerRepo;
import com.zanabazar.JarSoftTestTask.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/category/{categoryId}/banner")
public class BannerController {

    @Autowired
    private BannerRepo bannerRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping
    public ResponseEntity<String> addBanner(@PathVariable(value = "categoryId") Integer categoryId,
                                            @RequestBody Map<String, String> banner) {
        if (categoryRepo.count() == 0) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("While no categories have been created, creating a banner is impossible");
        }

        String id = banner.get("id");
        String name = banner.get("name");
        String price = banner.get("price");
        String content = banner.get("content");

        if (name.isEmpty() || price.isEmpty() || content.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please fill in all fields");
        }
        if (id!=null) {
            Banner existBanner = bannerRepo.findById(Integer.parseInt(id)).get();
            if (bannerRepo.findByName(name) != null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Banner with name '" + name + "' is already exist");
            }
            existBanner.setName(name);
            existBanner.setPrice(Double.parseDouble(price));
            existBanner.setContent(content);
            existBanner.setCategory(categoryRepo.findById(categoryId).get());
            bannerRepo.save(existBanner);
        }
        bannerRepo.save(new Banner(name, Double.parseDouble(price),categoryRepo.findById(categoryId).get(), content));

        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @DeleteMapping("/{bannerId}")
    public ResponseEntity<String> deleteBanner(@PathVariable(value = "bannerId") Integer bannerId) {
        bannerRepo.deleteById(bannerId);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @GetMapping
    public Iterable<Banner> getAllBanners() {
        return bannerRepo.findAll();
    }
}
