package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Categories;
import com.proiect.ecommerce.model.User;
import com.proiect.ecommerce.repository.Categories_repo;
import com.proiect.ecommerce.repository.Users_repo;
import com.proiect.ecommerce.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //GetMapping
    @GetMapping
    public List<Categories> getAllCategories(){
        return categoriesService.getAllCategories();
    }

    //GetMapping by ID
    @GetMapping("/{id}")
    public Categories getAllCategoriesbyId(@PathVariable("id") Integer id)
    {
        return categoriesService.getCategories(id);
    }

    //POST
    @PostMapping
    public Categories createCategories(@RequestBody Categories categories)
    {
        return categoriesService.createCategories(categories);
    }
    //PUT
    @PutMapping("/{id}")
    public Categories updateCategories(@PathVariable("id") Integer id, @RequestBody Categories categories)
    {
        return categoriesService.updateCategories(id,categories);
    }

    //PATCH
    @PatchMapping("/{id}")
    public Categories updatePatchCategories(@PathVariable("id") Integer id, @RequestBody Categories categories)
    {
        return categoriesService.updatePatchCategories(id,categories);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void DeleteCategories(@PathVariable("id") Integer id)
    {
        categoriesService.DeleteCategories(id);
    }

}
