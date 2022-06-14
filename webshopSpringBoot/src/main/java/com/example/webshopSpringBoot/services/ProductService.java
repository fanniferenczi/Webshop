package com.example.webshopSpringBoot.services;

import com.example.webshopSpringBoot.exception.UserNotFoundException;
import com.example.webshopSpringBoot.models.Category;
import com.example.webshopSpringBoot.models.Product;
import com.example.webshopSpringBoot.repositories.CategoryRepo;
import com.example.webshopSpringBoot.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepository;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public List<Product> findAllProduct(){
        return productRepo.findAll();
    }

    public Product updateProduct(Product product){
        return productRepo.save(product);
    }

    public Product findProductById(Long id){
        return productRepo.findProductById(id)
                .orElseThrow(()->new UserNotFoundException("Product by id "+id+"was not found"));
    }

    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }

    public void assignCategoryToProduct(Long productId, Long categoryId) {
        Product product =productRepo.findById(productId).get();
        Category category=categoryRepository.findById(categoryId).get();
        product.setCategory(category);
        productRepo.save(product);
    }


    public List<Product> getAllProductByCategoryId(Long categoryId){
        Category category=categoryRepository.findById(categoryId).get();
        return productRepo.findAllByCategory(category);
    }




}
