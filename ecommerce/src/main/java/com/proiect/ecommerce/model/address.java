package com.proiect.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
@SequenceGenerator(name = "address_seq", initialValue = 1,allocationSize = 1000)
@Data
public class address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @Column(name = "id_adresa")
    private Integer id_adresa;
    @Column(name = "nume_complet")
    private String nume_complet;
    @Column(name = "adresa")
    private String adresa;
    @Column(name = "oras")
    private String oras;

    @ManyToOne
    private User user;
}
