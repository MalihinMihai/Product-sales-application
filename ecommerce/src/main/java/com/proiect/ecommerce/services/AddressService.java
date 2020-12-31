package com.proiect.ecommerce.services;

import com.proiect.ecommerce.model.Address;
import com.proiect.ecommerce.repository.Address_repo;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private final Address_repo address_repo;

    //Initializare Repo
    public AddressService (Address_repo address_repo)
    {
        this.address_repo=address_repo;
    }

    public List<Address> getAllAddresses()
    {
        List<Address> addresses = new ArrayList<>();
        address_repo.findAll().forEach(x -> addresses.add(x));
        return addresses;
    }

    public Address getAddresses(Integer id)
    {
        return address_repo.findById(id).get();
    }

}