package com.example.webshopSpringBoot.services;

import com.example.webshopSpringBoot.models.Category;
import com.example.webshopSpringBoot.models.Product;
import com.example.webshopSpringBoot.repositories.CategoryRepo;
import com.example.webshopSpringBoot.repositories.ProductRepo;
import com.example.webshopSpringBoot.services.CategoryService;
import com.example.webshopSpringBoot.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductRepo productRepository;
    @Autowired
    private ProductService productService;

    Product testProd1=new Product("poló","ez egy poló",3000,"image");
    Product testProd2=new Product("másik poló","ez egy másik poló",3000,"image");

    @BeforeEach
    public void before(){
        productRepository.deleteAll();
        productRepository.flush();
    }

    @Test
    public void productServiceTest(){
        assertNotNull(productService);
    }
    @Test
    public void databaseIsEmptyTest(){
        boolean products = productService.findAllProduct().isEmpty();
        assertTrue(products);
    }

    @Test
    void getAllProductsTest() {
        productService.addProduct(testProd1);
        productService.addProduct(testProd2);
        List<Product> products = productService.findAllProduct();
        assertEquals(2, products.size());
    }

    @Test
    void getProductByIdTest() {
        Product product=productService.addProduct(testProd1);
        Product foundProduct=productService.findProductById(product.getId());
        assertEquals(product.getId(),foundProduct.getId());
    }

    @Test
    void addProductTest() {
        Product result = productService.addProduct(testProd1);
        assertNotNull(result);
        assertNotNull(result.getId());
    }


    @Test
    void updateProductTest() {
        Product created = productService.addProduct(testProd1);
        created = productService.updateProduct(testProd2);
        assertNotNull(created);
        assertEquals(created.getId(), testProd2.getId());
        assertEquals(created.getName(), testProd2.getName());
    }

    @Test
    void deleteProductTest() {
        Product product = productService.addProduct(testProd1);
        productService.deleteProduct(product.getId());
        List<Product> products = productService.findAllProduct();
        assertEquals(0, products.size());
    }


}