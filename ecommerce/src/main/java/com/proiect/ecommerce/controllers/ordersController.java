package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Orders;
import com.proiect.ecommerce.model.Products;
import com.proiect.ecommerce.repository.Orders_repo;
import com.proiect.ecommerce.services.OrdersService;
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

    private OrdersService ordersService;

    @Autowired
    public ordersController (OrdersService ordersService)
    {
        this.ordersService=ordersService;
    }
    //GetMapping pentru toate comenzile
    @GetMapping
    public List<Orders> getAllOrders(){
        return ordersService.getAllOrders();
    }

    //GetMapping dupa ID
    @GetMapping("/{id}")
    public Orders getAllOrdersbyId(@PathVariable("id") Integer id)
    {
        return ordersService.getOrders(id);
    }



}
