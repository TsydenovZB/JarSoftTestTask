package com.zanabazar.JarSoftTestTask.controller;

import com.zanabazar.JarSoftTestTask.Service.CategoryService;
import com.zanabazar.JarSoftTestTask.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/addCategory")
    private ResponseEntity<String> addCategory(@RequestBody Map<String, String> category) {
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    private ResponseEntity<String> deleteCategory(@PathVariable(value = "categoryId") Integer categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    @GetMapping
    private Iterable<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
