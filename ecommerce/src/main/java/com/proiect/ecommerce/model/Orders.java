package com.proiect.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "orders")
@SequenceGenerator(name="order_seq",initialValue = 1,allocationSize = 1000)
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @Column(name = "id_order")
    private Integer id_order;

    @Column( name = "cantitate")
    private Integer cantitate;

    @Column(name = "status_comanda")
    private String status_c;

    @ManyToOne
    private User comenzi;
}
