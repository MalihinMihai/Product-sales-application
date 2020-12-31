package com.proiect.ecommerce.services;

import com.proiect.ecommerce.model.Address;
import com.proiect.ecommerce.model.Orders;
import com.proiect.ecommerce.repository.Address_repo;
import com.proiect.ecommerce.repository.Orders_repo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {

    private final Orders_repo orders_repo;

    //Initializare Repo
    public OrdersService (Orders_repo orders_repo)
    {
        this.orders_repo=orders_repo;
    }

    public List<Orders> getAllOrders()
    {
        List<Orders> orders = new ArrayList<>();
        orders_repo.findAll().forEach(x -> orders.add(x));
        return orders;
    }

    public Orders getOrders(Integer id)
    {
        return orders_repo.findById(id).get();
    }


}
