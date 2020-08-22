package com.zanabazar.JarSoftTestTask.repository;

import com.zanabazar.JarSoftTestTask.entity.Banner;
import com.zanabazar.JarSoftTestTask.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepo extends JpaRepository<Banner, Integer> {
    Banner findByName(String name);

    List<Banner> findByCategoryOrderByPriceDesc(Category responseCategory);
}
