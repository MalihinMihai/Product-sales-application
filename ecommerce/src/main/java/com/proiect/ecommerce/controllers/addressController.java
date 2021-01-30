package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Address;
import com.proiect.ecommerce.model.User;
import com.proiect.ecommerce.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class addressController {
    private AddressService addressService;
@Autowired
    public addressController(AddressService addressService)
    {
        this.addressService=addressService;
    }
    //GET
    @GetMapping
    public List<Address> getAllAddresses()
    {
        return addressService.getAllAddresses();
    }
    //GET dupa ID
    @GetMapping("/{id}")
    public Address getAddresses(Integer id)
    {
        return addressService.getAddresses(id);
    }

    //POST
    @PostMapping
    public Address createAddress(@RequestBody Address address)
    {
        return addressService.createAddress(address);
    }
}
