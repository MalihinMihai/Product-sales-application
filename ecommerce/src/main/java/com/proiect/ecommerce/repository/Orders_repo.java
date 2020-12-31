package com.proiect.ecommerce.repository;

import com.proiect.ecommerce.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface Orders_repo extends CrudRepository<Orders,Integer> {
}
