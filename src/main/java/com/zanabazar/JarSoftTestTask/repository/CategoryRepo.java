package com.zanabazar.JarSoftTestTask.repository;

import com.zanabazar.JarSoftTestTask.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findByName(String name);

    Category findByReqName(String reqName);
}
