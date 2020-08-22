package com.zanabazar.JarSoftTestTask.controller;

import com.zanabazar.JarSoftTestTask.entity.Banner;
import com.zanabazar.JarSoftTestTask.entity.Category;
import com.zanabazar.JarSoftTestTask.repository.BannerRepo;
import com.zanabazar.JarSoftTestTask.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private BannerRepo bannerRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping
    private ResponseEntity<String> addCategory(@RequestBody Map<String, String> category) {
        String name = category.get("name");
        String reqName = category.get("reqName");
        if (categoryRepo.findByName(name) == null) {
            if (categoryRepo.findByReqName(reqName) == null) {
                Category anotherCategory = new Category();
                anotherCategory.setName(name);
                anotherCategory.setReqName(reqName);

                categoryRepo.save(anotherCategory);
                return ResponseEntity.status(HttpStatus.OK).body("");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Category with Request ID '" + reqName + "' is already exist");
            }
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Category with name '" + name + "'is already exist");
        }
    }

    @DeleteMapping("/{categoryId}")
    private ResponseEntity<String> deleteCategory(@PathVariable(value = "categoryId") Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).get();
        List<Banner> banners = category.getBanners();
        if (!banners.isEmpty()) {
            StringBuilder str = new StringBuilder("");
            for (Banner banner : banners) {
                str.append(banner.getId()).append(" ");
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Category can't be deleted while there banners from the ID: " + str);
        }
        categoryRepo.deleteById(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @GetMapping
    private Iterable<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
