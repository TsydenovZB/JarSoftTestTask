package com.zanabazar.JarSoftTestTask.Service;

import com.zanabazar.JarSoftTestTask.entity.Banner;
import com.zanabazar.JarSoftTestTask.entity.Category;
import com.zanabazar.JarSoftTestTask.repository.BannerRepo;
import com.zanabazar.JarSoftTestTask.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    @Autowired
    private BannerRepo bannerRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public ResponseEntity<String> addCategory(Map<String, String> category) {

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

    public ResponseEntity<String> deleteCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).get();
        List<Banner> banners = category.getBanners();
        if (!banners.isEmpty()) {
            StringBuilder str = new StringBuilder("");
            for (Banner banner : banners) {
                str.append(banner.getId()).append(" ");
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Category can't be deleted while there banners from the ID: " + str);
        }
        category.setDeleted(true);
        categoryRepo.save(category);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    public Iterable<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
