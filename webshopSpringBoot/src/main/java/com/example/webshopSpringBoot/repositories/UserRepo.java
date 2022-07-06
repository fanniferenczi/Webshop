package com.example.webshopSpringBoot.repositories;

import com.example.webshopSpringBoot.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,String> {

}
