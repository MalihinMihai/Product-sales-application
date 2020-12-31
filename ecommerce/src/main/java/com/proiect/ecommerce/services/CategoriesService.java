package com.proiect.ecommerce.services;

import com.proiect.ecommerce.model.Address;
import com.proiect.ecommerce.model.Categories;
import com.proiect.ecommerce.repository.Address_repo;
import com.proiect.ecommerce.repository.Categories_repo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoriesService {

    private final Categories_repo categories_repo;

    //Initializare Repo
    public CategoriesService (Categories_repo categories_repo)
    {
        this.categories_repo=categories_repo;
    }

    public List<Categories> getAllCategories()
    {
        List<Categories> categories = new ArrayList<>();
        categories_repo.findAll().forEach(x -> categories.add(x));
        return categories;
    }

    public Categories getCategories(Integer id)
    {
        return categories_repo.findById(id).get();
    }
}
