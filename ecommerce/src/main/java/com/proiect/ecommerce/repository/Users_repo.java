package com.proiect.ecommerce.repository;

import com.proiect.ecommerce.model.User;
import org.springframework.data.repository.CrudRepository;

public interface Users_repo extends CrudRepository<User,Integer> {
}
