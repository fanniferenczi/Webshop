package com.example.webshopSpringBoot.services;

import com.example.webshopSpringBoot.exception.UserNotFoundException;
import com.example.webshopSpringBoot.models.Category;
import com.example.webshopSpringBoot.models.Product;
import com.example.webshopSpringBoot.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    public Category addCategory(Category category){
        return categoryRepo.save(category);
    }

    public List<Category> findAllCategory(){
        return categoryRepo.findAll();
    }

    public Category updateCategory(Category category){
        return categoryRepo.save(category);
    }

    public Category findCategoryById(Long id){
        return categoryRepo.findCategoryById(id)
                .orElseThrow(()->new UserNotFoundException("Category by id "+id+"was not found"));
    }

    public void deleteCategory(Long id){
        categoryRepo.deleteById(id);
    }

}
