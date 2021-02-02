package com.proiect.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "orders")
@SequenceGenerator(name="order_seq",initialValue = 2,allocationSize = 1000)
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @Column(name = "id_order")
    private Integer id_order;

    @Column( name = "cantitate")
    private Integer cantitate;

    @ManyToOne
    private User comenzi;
}
