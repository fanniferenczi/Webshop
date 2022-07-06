package com.example.webshopSpringBoot.services;

import com.example.webshopSpringBoot.models.Role;
import com.example.webshopSpringBoot.models.User;
import com.example.webshopSpringBoot.repositories.RoleRepo;
import com.example.webshopSpringBoot.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user){
        Role role=roleRepo.findById("User").get();
        Set<Role> roles=new HashSet<>();
        roles.add(role);
        user.setRole(roles);
        user.setPassword(getEncodedPassword(user.getPassword()));

        return userRepo.save(user);
    }

    public void initRolesAndUser(){
        Role adminRole =new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepo.save(adminRole);

        Role userRole =new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default user role");
        roleRepo.save(userRole);

        User adminUser=new User();
        adminUser.setFirstName("admin");
        adminUser.setLastName("admin");
        adminUser.setUserName("admin01");
        adminUser.setPassword(getEncodedPassword("pass"));
        Set<Role> adminRoles=new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepo.save(adminUser);

        /*User user=new User();
        user.setFirstName("user");
        user.setLastName("user");
        user.setUserName("user01");
        user.setPassword(getEncodedPassword("userpass"));
        Set<Role> userRoles=new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userRepo.save(user);*/
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
