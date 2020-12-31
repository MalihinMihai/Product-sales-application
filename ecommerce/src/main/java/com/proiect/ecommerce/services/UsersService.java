package com.proiect.ecommerce.services;

import com.proiect.ecommerce.model.Products;
import com.proiect.ecommerce.model.User;
import com.proiect.ecommerce.repository.Products_repo;
import com.proiect.ecommerce.repository.Users_repo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UsersService {

    private final Users_repo users_repo;
    //Initializare Repo
    public UsersService (Users_repo users_repo)
    {
        this.users_repo=users_repo;
    }

    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<>();
        users_repo.findAll().forEach(x -> users.add(x));
        return users;
    }

    public User getUsers(Integer id)
    {
        return users_repo.findById(id).get();
    }
}
