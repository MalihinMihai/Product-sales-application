package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Products;
import com.proiect.ecommerce.model.User;
import com.proiect.ecommerce.repository.Products_repo;
import com.proiect.ecommerce.repository.Users_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

    private final com.proiect.ecommerce.repository.Users_repo Users_repo;

    @Autowired
    public userController (Users_repo Users_repo)
    {
        this.Users_repo=Users_repo;
    }

    //GetMapping pentru toti userii
    @GetMapping
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        Users_repo.findAll().forEach(g -> users.add(g));
        return users;
    }

    //GetMapping dupa ID
    @GetMapping("/{id}")
    public User getAllUsersbyId(@PathVariable("id") Integer id)
    {
        return this.Users_repo.findById(id).orElse(null);
    }

    //PostMapping - crearea unei resurse(user)
    @PostMapping
    public User createUser(@RequestBody User user)
    {
        return Users_repo.save(user);
    }

    //PutMapping - modificarea completa a resursei dupa id
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestBody User user)
    {
        user.setId(id);
        return Users_repo.save(user);
    }

    //PatchMapping - modificarea partiala a resursei

    @PatchMapping("/{id}")
    public User updatePatchUser(@PathVariable("id") Integer id, @RequestBody User user)
    {
        User newUser = Users_repo.findById(id).get();
        user.setId(id);
        if(user.getEmail() != null)
        {
            newUser.setEmail(user.getEmail());
        }
        if(user.getParola() != null)
        {
            newUser.setParola(user.getParola());
        }
        if(user.getTelefon() != null)
        {
            newUser.setTelefon(user.getTelefon());
        }


        return Users_repo.save(newUser);
    }
}
