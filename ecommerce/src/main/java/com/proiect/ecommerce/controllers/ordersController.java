package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Orders;
import com.proiect.ecommerce.model.Products;
import com.proiect.ecommerce.repository.Orders_repo;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class ordersController {

    private final Orders_repo orders_repo;

    @Autowired
    public ordersController (Orders_repo orders_repo)
    {
        this.orders_repo=orders_repo;
    }
    //GetMapping pentru toate comenzile
    @GetMapping
    public List<Orders> getAllOrders(){
        List<Orders> orders = new ArrayList<>();
        orders_repo.findAll().forEach(g -> orders.add(g));
        return orders;
    }

    //GetMapping dupa ID
    @GetMapping("/{id}")
    public Orders getAllOrdersbyId(@PathVariable("id") Integer id)
    {
        return this.orders_repo.findById(id).orElse(null);
    }



}
