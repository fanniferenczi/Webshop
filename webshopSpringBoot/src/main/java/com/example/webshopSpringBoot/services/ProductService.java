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

    @Autowired
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

    public void initCategoriesAndProducts(){
        Category tops=new Category("Felsők");
        Category trousers=new Category("Nadrágok");
        Category shoes=new Category("Cipők");
        Category bags=new Category("Táskák");

        categoryRepository.save(tops);
        categoryRepository.save(trousers);
        categoryRepository.save(shoes);
        categoryRepository.save(bags);

        Product p1=new Product("Nyomott mintás póló","Világoskék/Grateful Dead",3995,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fb5%2F40%2Fb540366156f4a57527678432b65bc48ae8e9d5c3.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bladies_tops_printed_tshirts%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p2= new Product("Pamutpóló","Világoskék/csíkos",3495,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F3c%2F19%2F3c194c0f58019435d83746e992c1c2e73441107b.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bladies_tops_shortsleeve%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p3= new Product("Bordás trikó","Kék",2995,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fb6%2F12%2Fb6126cf1fa60b8422d3df71ed7863558515bcd96.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p4= new Product("Rövid felső","Lila/csíkos",2995,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F91%2F9f%2F919faea2af01d6d59256a80468828f888cb4e9b2.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p5= new Product("Légies felső","Fekete, alján megkötővel",5995,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fdb%2F36%2Fdb369f7ac9787e482ec12599b55ee0930a9d5057.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");

        p1.setCategory(tops);
        p2.setCategory(tops);
        p3.setCategory(tops);
        p4.setCategory(tops);
        p5.setCategory(tops);

        productRepo.save(p1);
        productRepo.save(p2);
        productRepo.save(p3);
        productRepo.save(p4);
        productRepo.save(p5);

        Product p6 = new Product("Magas derekú twillnadrág","Világos zöldesbézs",6995,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Ff6%2F62%2Ff66208e0e2ab3d1fcefc87da45e6a38a1bf5f893.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bladies_trousers_highwaisted%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p7 = new Product("Straight Low Cargo Jeans","Világoslila/kockás",3995,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F93%2F29%2F93298cce862be558c5170eb6cc1bddae8bd39830.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p8 = new Product("Curvy Ultra High Jeggings","Farmerkék",5995,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F53%2Fa1%2F53a15cfca3ad5d1c60ad2dce9c38afc78042076c.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p9 = new Product("Egyenes lenkeverék nadrág","Világos khakizöld",7995,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F12%2Fbd%2F12bd4be43af8c2da1414699eee0df3c02aae6c9f.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p10 = new Product("Skinny High Jeggings","Szürke",6495,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fbb%2F3c%2Fbb3c3a84f1d6bba5400f49206530173ebd8948a8.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");

        p6.setCategory(trousers);
        p7.setCategory(trousers);
        p8.setCategory(trousers);
        p9.setCategory(trousers);
        p10.setCategory(trousers);

        productRepo.save(p6);
        productRepo.save(p7);
        productRepo.save(p8);
        productRepo.save(p9);
        productRepo.save(p10);


        Product p11 = new Product("Pamut espadrilles cipő","Fekete",4495,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fe6%2Fe2%2Fe6e2eeeb4bc6762219a4caf6427ea61c6482779e.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p12 = new Product("Megkötős espadrilles cipő","Krémszínű",9295,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F0e%2F6c%2F0e6c469d970c66c0bf8bb96b953bd9025537a389.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bladies_shoes%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p13 = new Product("Espadrilles tornacipő","Fehér",9295,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Ff4%2F9e%2Ff49ea684a41b627830617f8fda503c36ff76e730.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p14 = new Product("Magas talpú edzőcipő","Fekete",6495,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F80%2Fe8%2F80e8432921e4ab02b7fe48514643e2548212714a.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p15 = new Product("Finomkötött tornacipő","Fekete",7995,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F09%2Fcf%2F09cfa536a0a71843133bdb57a9e79990635f1a4e.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");

        p11.setCategory(shoes);
        p12.setCategory(shoes);
        p13.setCategory(shoes);
        p14.setCategory(shoes);
        p15.setCategory(shoes);

        productRepo.save(p11);
        productRepo.save(p12);
        productRepo.save(p13);
        productRepo.save(p14);
        productRepo.save(p15);


        Product p16 = new Product("Jacquard szövésű kézitáska","Szürkésbézs/fehér mintás",9295,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F6f%2F41%2F6f41c92a29702d8ecbb5d84bcde0f413f606f752.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bladies_accessories_bags_handbags%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p17 = new Product("Rojtos bevásárlótáska","Krémszínű",9295,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Ffd%2F7e%2Ffd7e1d02c3abace6ce5b3287bc47f6bf9ab6517d.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/fullscreen]");
        Product p18 = new Product("Válltáska","Világoslila",3995,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F8b%2F3f%2F8b3fdef4d15096310c3dc8c56093b8eae7a964d9.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p19 = new Product("Bevásárlótáska","Fekete",5995,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F9c%2Fcd%2F9ccd1ff5f45081fae6540618ea753fbb7ae1a948.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");
        Product p20 = new Product("Nagy szalmatáska","Zöld",9995,"https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fc1%2F40%2Fc140fa55abb7e25c5c4ca7c7301c31fd3c626214.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]");

        p16.setCategory(bags);
        p17.setCategory(bags);
        p18.setCategory(bags);
        p19.setCategory(bags);
        p20.setCategory(bags);

        productRepo.save(p16);
        productRepo.save(p17);
        productRepo.save(p18);
        productRepo.save(p19);
        productRepo.save(p20);




    }




}
