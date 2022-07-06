package com.example.webshopSpringBoot.controllers;

import com.example.webshopSpringBoot.models.Category;
import com.example.webshopSpringBoot.models.Product;
import com.example.webshopSpringBoot.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    Logger logger= LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>>getAllProducts(){ //return an http response, inside theres gonna be a list of products
        logger.trace("getAllProducts method accessed");
        List<Product> products =productService.findAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Product>getProductById(@PathVariable("id")Long id){
        logger.trace("getProductById method accessed");
        Product product =productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        logger.trace("addProduct method accessed");
        Product newProduct=productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PostMapping("/add/{catid}")
    public ResponseEntity<Product> addProduct(@RequestBody Product product,@PathVariable Long catid){
        logger.trace("addProduct with category id method accessed");
        Product newProduct=productService.addProduct(product);
        productService.assignCategoryToProduct(newProduct.getId(), catid);
        logger.trace("added product: "+newProduct.getName());
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        logger.trace("updateProduct method accessed");
        Product updateProduct=productService.updateProduct(product);
        logger.trace("updated product: "+updateProduct.getName());
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id")Long id){
        logger.trace("deleteProduct method accessed");
        productService.deleteProduct(id);
        logger.trace("product with id "+id+" has been deleted");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{productId}/category/{categoryId}")
    public void assignCategoryToProduct(@PathVariable Long productId, @PathVariable Long categoryId){
        logger.trace("assignCategoryToProduct method accessed");
        productService.assignCategoryToProduct(productId,categoryId);
    }

    @GetMapping("/catid/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Long categoryId){
        logger.trace("getProductsByCategoryId method accessed");
        List<Product> products =productService.getAllProductByCategoryId(categoryId);
        logger.trace("found "+products.size()+" products");
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostConstruct
    public void initCategoriesAndProducts(){
        productService.initCategoriesAndProducts();
    }




}
