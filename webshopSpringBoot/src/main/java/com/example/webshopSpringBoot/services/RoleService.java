package com.example.webshopSpringBoot.services;

import com.example.webshopSpringBoot.models.Role;
import com.example.webshopSpringBoot.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;

    public Role createNewRole(Role role){
        return roleRepo.save(role);
    }
}
