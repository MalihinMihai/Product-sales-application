package com.proiect.ecommerce.services;


import com.proiect.ecommerce.model.Address;
import com.proiect.ecommerce.model.Products;
import com.proiect.ecommerce.model.User;
import com.proiect.ecommerce.repository.Address_repo;
import com.proiect.ecommerce.repository.Products_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {

    private final Products_repo products_repo;

    //Initializare Repo
    @Autowired
    public ProductsService (Products_repo products_repo)
    {
        this.products_repo=products_repo;
    }
    //GET
    public List<Products> getAllProducts()
    {
        List<Products> products = new ArrayList<>();
        products_repo.findAll().forEach(x -> products.add(x));
        return products;
    }
    //GET by ID
    public Products getProducts(Integer id)
    {
        return products_repo.findById(id).get();
    }

    //POST
    public Products createProduct(@RequestBody Products products)
    {
        return products_repo.save(products);
    }
}
