package com.proiect.ecommerce.services;


import com.proiect.ecommerce.model.Address;
import com.proiect.ecommerce.model.Products;
import com.proiect.ecommerce.model.User;
import com.proiect.ecommerce.repository.Address_repo;
import com.proiect.ecommerce.repository.Products_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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

    //PUT
    public Products updateProduct(@RequestBody Products products)
    {
        products.setId_produs(products.getId_produs());
        return products_repo.save(products);
    }
    //PATCH
    public Products updatePatchProduct(@PathVariable("id") Integer id, @RequestBody Products products)
    {
        Products newProduct = products_repo.findById(id).get();
        products.setId_produs(id);
        if(products.getNume() != null)
        {
            newProduct.setNume(products.getNume());
        }
        if(products.getDescriere() != null)
        {
            newProduct.setDescriere(products.getDescriere());
        }
        if(products.getPret() != null)
        {
            newProduct.setPret(products.getPret());
        }
        if(products.getCategories() != null)
        {
            newProduct.setCategories(products.getCategories());
        }
        if(products.getCuloare() !=null)
        {
            newProduct.setCuloare(products.getCuloare());
        }
        if(products.getDimensiune() != null)
        {
            newProduct.setDimensiune(products.getDimensiune());
        }

        return products_repo.save(newProduct);
    }

    //DELETE by ID
    public void DeleteProduct(@PathVariable("id") Integer id)
    {
       products_repo.deleteById(id);
    }

}
