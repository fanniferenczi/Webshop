package com.example.webshopSpringBoot.repositories;

import com.example.webshopSpringBoot.models.Category;
import com.example.webshopSpringBoot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Long> {

    void deleteById(Long id);

    Optional<Product> findProductById(Long id);

    List<Product> findAllByCategory_Id(Long id);

    List<Product> findAllByCategory(Category category);
}
