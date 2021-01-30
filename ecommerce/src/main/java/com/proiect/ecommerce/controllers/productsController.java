package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Products;
import com.proiect.ecommerce.repository.Products_repo;
import com.proiect.ecommerce.services.ProductsService;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class productsController {

    private ProductsService productsService;

    @Autowired
    public productsController (ProductsService productsService)
    {
        this.productsService=productsService;
    }

    //GET
    @GetMapping
    public List<Products> getAllProducts(){
        return productsService.getAllProducts();
    }

    //GET dupa ID
    @GetMapping("/{id}")
    public Products getAllProductsbyId(@PathVariable("id") Integer id)
    {
        return productsService.getProducts(id);
    }
    //POST
    @PostMapping
    public Products createProduct(@RequestBody Products products)
    {
        return productsService.createProduct(products);
    }



}
