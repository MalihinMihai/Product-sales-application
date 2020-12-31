package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Products;
import com.proiect.ecommerce.repository.Products_repo;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class productsController {

    private final Products_repo products_repo;

    @Autowired
    public productsController (Products_repo products_repo)
    {
        this.products_repo=products_repo;
    }

    //GetMapping pentru toate produsele
    @GetMapping
    public List<Products> getAllProducts(){
        List<Products> products = new ArrayList<>();
        products_repo.findAll().forEach(g -> products.add(g));
        return products;
    }

    //GetMapping dupa ID
    @GetMapping("/{id}")
    public Products getAllProductsbyId(@PathVariable("id") Integer id)
    {
        return this.products_repo.findById(id).orElse(null);
    }



}
