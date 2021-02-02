package com.proiect.ecommerce.services;

import com.proiect.ecommerce.model.Address;
import com.proiect.ecommerce.model.Categories;
import com.proiect.ecommerce.model.User;
import com.proiect.ecommerce.repository.Address_repo;
import com.thoughtworks.qdox.model.expression.Add;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private final Address_repo address_repo;

    //Initializare Repo
    @Autowired
    public AddressService (Address_repo address_repo)
    {
        this.address_repo=address_repo;
    }
    //GET
    public List<Address> getAllAddresses()
    {
        List<Address> addresses = new ArrayList<>();
        address_repo.findAll().forEach(x -> addresses.add(x));
        return addresses;
    }
    //GET BY ID
    public Address getAddresses(Integer id)
    {
        return address_repo.findById(id).get();
    }

    //POST
    public Address createAddress(@RequestBody Address address)
    {
        return address_repo.save(address);
    }

    //PUT
    public Address updateAddress(@PathVariable("id") Integer id, @RequestBody Address address)
    {
        address.setId_adresa(id);
        return address_repo.save(address);
    }
    //PATCH
    public Address updatePatchAddress(@PathVariable("id") Integer id, @RequestBody Address address)
    {
        Address newAddress = address_repo.findById(id).get();
        address.setId_adresa(id);
        if(address.getNume_complet() != null)
        {
            newAddress.setNume_complet(address.getNume_complet());
        }
        if(address.getOras() != null)
        {
           newAddress.setOras(address.getOras());
        }
        if(address.getUser() != null)
        {
            newAddress.setUser(address.getUser());
        }
        return address_repo.save(newAddress);
    }

    //DELETE
    public void DeleteAddress(@PathVariable("id") Integer id)
    {
        address_repo.deleteById(id);
    }


}
