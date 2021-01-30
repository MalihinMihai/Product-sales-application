package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Products;
import com.proiect.ecommerce.model.User;
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
    //PUT
    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable("id") Integer id, @RequestBody Products products)
    {
        return productsService.updateProduct(products);
    }
    //PATCH
    @PatchMapping("/{id}")
    public Products updatePatchProduct(@PathVariable("id") Integer id, @RequestBody Products products)
    {
        return productsService.updatePatchProduct(id,products);
    }
    //DELETE
    @DeleteMapping("/{id}")
    public void DeleteProduct(@PathVariable("id") Integer id)
    {
        productsService.DeleteProduct(id);
    }



}
