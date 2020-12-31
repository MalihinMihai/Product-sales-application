package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Categories;
import com.proiect.ecommerce.model.User;
import com.proiect.ecommerce.repository.Categories_repo;
import com.proiect.ecommerce.repository.Users_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/categories")

public class categoriesController {

    private final com.proiect.ecommerce.repository.Categories_repo categories_repo;
    @Autowired
    public categoriesController (com.proiect.ecommerce.repository.Categories_repo categories_repo)
    {
        this.categories_repo=categories_repo;
    }

    //GetMapping pentru totate categoriile
    @GetMapping
    public List<Categories> getAllCategories(){
        List<Categories> categories = new ArrayList<>();
        categories_repo.findAll().forEach(g -> categories.add(g));
        return categories;
    }

    //GetMapping dupa ID
    @GetMapping("/{id}")
    public Categories getAllCategoriesbyId(@PathVariable("id") Integer id)
    {
        return this.categories_repo.findById(id).orElse(null);
    }
}
