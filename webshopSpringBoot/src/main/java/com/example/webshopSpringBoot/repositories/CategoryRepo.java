package com.example.webshopSpringBoot.repositories;

import com.example.webshopSpringBoot.models.Category;
import com.example.webshopSpringBoot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    void deleteById(Long id);

    Optional<Category> findCategoryById(Long id);
}
