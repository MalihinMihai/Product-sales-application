package com.proiect.ecommerce.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@SequenceGenerator(name = "prod_seq",initialValue = 2, allocationSize = 1000)
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
    @Column(name="idprodus")
    private Integer id_produs;
    @Column(name="nume")
    private String nume;
    @Column(name = "descriere")
    private String descriere;
    @Column(name="pret")
    private Integer pret;
    @Column(name="dimensiune")
    private String dimensiune;
    @Column(name="culoare")
    private String culoare;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Categories categories;

}
