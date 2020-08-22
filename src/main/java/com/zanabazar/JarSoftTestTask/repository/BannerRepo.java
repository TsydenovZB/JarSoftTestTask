package com.zanabazar.JarSoftTestTask.repository;

import com.zanabazar.JarSoftTestTask.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepo extends JpaRepository<Banner, Integer> {
    Banner findByName(String name);
}
