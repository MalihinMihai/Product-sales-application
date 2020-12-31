package com.proiect.ecommerce.services;


import com.proiect.ecommerce.model.Address;
import com.proiect.ecommerce.model.Products;
import com.proiect.ecommerce.repository.Address_repo;
import com.proiect.ecommerce.repository.Products_repo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {

    private final Products_repo products_repo;

    //Initializare Repo
    public ProductsService (Products_repo products_repo)
    {
        this.products_repo=products_repo;
    }

    public List<Products> getAllProducts()
    {
        List<Products> products = new ArrayList<>();
        products_repo.findAll().forEach(x -> products.add(x));
        return products;
    }

    public Products getProducts(Integer id)
    {
        return products_repo.findById(id).get();
    }
}
