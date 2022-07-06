package com.example.webshopSpringBoot.repositories;

import com.example.webshopSpringBoot.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role,String> {

}
