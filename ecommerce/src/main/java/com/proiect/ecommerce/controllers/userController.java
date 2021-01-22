package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Products;
import com.proiect.ecommerce.model.User;
import com.proiect.ecommerce.repository.Products_repo;
import com.proiect.ecommerce.repository.Users_repo;
import com.proiect.ecommerce.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

    private UsersService usersService;

    @Autowired
    public userController (UsersService usersService)
    {
        this.usersService=usersService;
    }

    //GetMapping pentru toti userii
    @GetMapping
    public List<User> getAllUsers(){
        return usersService.getAllUsers();
    }

    //GetMapping dupa ID
    @GetMapping("/{id}")
    public User getAllUsersbyId(@PathVariable("id") Integer id)
    {
        return usersService.getUsers(id);
    }

    //PostMapping - crearea unei resurse(user)
    @PostMapping
    public User createUser(@RequestBody User user)
    {
        return usersService.createUser(user);
    }

    //PutMapping - modificarea completa a resursei dupa id
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestBody User user)
    {
        return usersService.updateUser(id,user);
    }

    //PatchMapping - modificarea partiala a resursei

    @PatchMapping("/{id}")
    public User updatePatchUser(@PathVariable("id") Integer id, @RequestBody User user)
    {
       return usersService.updatePatchUser(id,user);
    }
}
