package com.proiect.ecommerce.services;
import com.proiect.ecommerce.model.Categories;
import com.proiect.ecommerce.repository.Categories_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoriesService {

    private final Categories_repo categories_repo;

    //Initializare Repo
    @Autowired
    public CategoriesService (Categories_repo categories_repo)
    {
        this.categories_repo=categories_repo;
    }
    //GET
    public List<Categories> getAllCategories()
    {
        List<Categories> categories = new ArrayList<>();
        categories_repo.findAll().forEach(x -> categories.add(x));
        return categories;
    }
    //GET by ID
    public Categories getCategories(Integer id)
    {
        return categories_repo.findById(id).get();
    }

    //POST
    public Categories createCategories(@RequestBody Categories categories)
    {
        return categories_repo.save(categories);
    }
    //PUT
    public Categories updateCategories(@PathVariable("id") Integer id, @RequestBody Categories categories)
    {
        categories.setId_cat(id);
        return categories_repo.save(categories);
    }

    //PATCH
    public Categories updatePatchCategories(@PathVariable("id") Integer id, @RequestBody Categories categories)
    {
        Categories newCategori = categories_repo.findById(id).get();
        categories.setId_cat(id);
        if(categories.getNume() != null)
        {
            newCategori.setNume(categories.getNume());
        }
        return categories_repo.save(newCategori);
    }

        //DELETE
    public void DeleteCategories(@PathVariable("id") Integer id)
    {
        categories_repo.deleteById(id);
    }

}
