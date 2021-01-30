package com.proiect.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@SequenceGenerator(name = "cat_seq",initialValue = 2, allocationSize = 5)
@Data
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_seq")
    @Column(name="idcategorie")
    private Integer id_cat;
    @Column(name="nume")
    private String nume;
}
