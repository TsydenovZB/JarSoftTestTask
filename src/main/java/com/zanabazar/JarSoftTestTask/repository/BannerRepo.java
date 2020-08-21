package com.zanabazar.JarSoftTestTask.repository;

import com.zanabazar.JarSoftTestTask.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepo extends JpaRepository<Banner, Integer> {
    Banner findByName(String name);
}
