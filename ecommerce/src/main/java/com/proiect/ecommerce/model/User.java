package com.proiect.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//Adnotari mapare
@Entity
//Se face maparea
@Table(name = "users")
//Generez un Sequeance number pentru a retine ultima valoare din
//baza de date
@SequenceGenerator(name = "user_seq",initialValue = 2, allocationSize = 1000)
//Generez Getter si setters cu adnotarea lomboc, fara sa fiu nevoit sa le declar separat.
@Data
public class User {
    //Indica ca e chiere primara
    @Id
    //Indic bazei de date ca generez valorile si sequence numberul generat mai sus
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(name = "id_user")
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "parola")
    private String parola;
    @Column(name = "telefon")
    private Integer telefon;
}
