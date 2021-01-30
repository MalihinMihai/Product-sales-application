package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Address;
import com.proiect.ecommerce.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //Obtinere lista de adrese.
    public List<Address> getAllAddresses()
    {
        return addressService.getAllAddresses();
    }

    //Obtinere adresa dupa ID
    public Address getAddresses(Integer id)
    {
        return addressService.getAddresses(id);
    }
}
