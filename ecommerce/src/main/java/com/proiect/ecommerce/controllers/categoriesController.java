package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Categories;
import com.proiect.ecommerce.model.User;
import com.proiect.ecommerce.repository.Categories_repo;
import com.proiect.ecommerce.repository.Users_repo;
import com.proiect.ecommerce.services.CategoriesService;
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

    private CategoriesService categoriesService;
    //Initializarea se face in controller
    @Autowired
    public categoriesController (CategoriesService categoriesService)
    {
        this.categoriesService=categoriesService;
    }

    //GetMapping pentru totate categoriile
    @GetMapping
    public List<Categories> getAllCategories(){
        return categoriesService.getAllCategories();
    }

    //GetMapping pentru o singura categorie
    @GetMapping("/{id}")
    public Categories getAllCategoriesbyId(@PathVariable("id") Integer id)
    {
        return categoriesService.getCategories(id);
    }
}
