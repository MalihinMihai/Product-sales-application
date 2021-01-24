CREATE TABLE IF NOT EXISTS `address` (
                                         `id_adresa` int NOT NULL,
                                         `nume_complet` varchar(100) DEFAULT NULL,
    `adresa` varchar(100) DEFAULT NULL,
    `oras` varchar(100) DEFAULT NULL,
    `users_id_user` int NOT NULL,
    `user_id_user` int DEFAULT NULL,
    `orders_id_order` int DEFAULT NULL,
    PRIMARY KEY (`id_adresa`),
    KEY `fk_address_users_idx` (`users_id_user`),
    KEY `FKllru83q5c06h1nbo9oe3xhue3` (`user_id_user`),
    KEY `FK3nn5fnyy8xl0fl9b1nex9fije` (`orders_id_order`),
    CONSTRAINT `FK3nn5fnyy8xl0fl9b1nex9fije` FOREIGN KEY (`orders_id_order`) REFERENCES `orders` (`id_order`),
    CONSTRAINT `fk_address_users` FOREIGN KEY (`users_id_user`) REFERENCES `users` (`id_user`),
    CONSTRAINT `FKllru83q5c06h1nbo9oe3xhue3` FOREIGN KEY (`user_id_user`) REFERENCES `users` (`id_user`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES ecommerce_t.`address` WRITE;

INSERT INTO `address` VALUES (1,'Malihin Mihai','Memorandum 18','Brasov',1,1,NULL);
UNLOCK TABLES;

CREATE TABLE IF NOT EXISTS ecommerce_t.`address_seq` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `address_seq`
--

LOCK TABLES ecommerce_t.`address_seq` WRITE;

UNLOCK TABLES;

--
-- Table structure for table `cat_seq`
--



CREATE TABLE IF NOT EXISTS  `cat_seq` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `cat_seq`
--

LOCK TABLES ecommerce_t.`cat_seq` WRITE;

UNLOCK TABLES;

--
-- Table structure for table `categories`
--



CREATE TABLE IF NOT EXISTS  ecommerce_t.`categories` (
                                                         `idcategorie` int NOT NULL,
                                                         `nume` varchar(100) NOT NULL,
    PRIMARY KEY (`idcategorie`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `categories`
--

LOCK TABLES ecommerce_t.`categories` WRITE;

INSERT INTO ecommerce_t.`categories` VALUES (1,'Nike');

UNLOCK TABLES;

--
-- Table structure for table `order_product`
--



CREATE TABLE IF NOT EXISTS  ecommerce_t.`order_product` (
                                                            `idorder_item` int NOT NULL,
                                                            `cantitate` int DEFAULT NULL,
                                                            `comenzi_id_order` int NOT NULL,
                                                            `detalii_produs_iddetalii_produs` int NOT NULL,
                                                            PRIMARY KEY (`idorder_item`),
    KEY `fk_comanda_produs_comenzi1_idx` (`comenzi_id_order`),
    KEY `fk_comanda_produs_detalii_produs1_idx` (`detalii_produs_iddetalii_produs`),
    CONSTRAINT `fk_comanda_produs_comenzi1` FOREIGN KEY (`comenzi_id_order`) REFERENCES `orders` (`id_order`),
    CONSTRAINT `fk_comanda_produs_detalii_produs1` FOREIGN KEY (`detalii_produs_iddetalii_produs`) REFERENCES `product_details` (`iddetalii_produs`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `order_product`
--

LOCK TABLES ecommerce_t.`order_product` WRITE;

UNLOCK TABLES;

--
-- Table structure for table `order_seq`
--



CREATE TABLE IF NOT EXISTS  ecommerce_t.`order_seq` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `order_seq`
--

LOCK TABLES ecommerce_t.`order_seq` WRITE;

UNLOCK TABLES;

--
-- Table structure for table `orders`
--



CREATE TABLE IF NOT EXISTS  ecommerce_t.`orders` (
                                                     `id_order` int NOT NULL,
                                                     `cantitate` int NOT NULL,
                                                     `users_id_user` int NOT NULL,
                                                     `address_id_adresa` int NOT NULL,
                                                     `comenzi_id_user` int NOT NULL,
                                                     `status_comanda` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id_order`),
    KEY `fk_order_users1_idx` (`users_id_user`),
    KEY `fk_order_address1_idx` (`address_id_adresa`),
    KEY `FKmqsi2jlbsbp0c64aebty7r7r` (`comenzi_id_user`),
    CONSTRAINT `fk_order_address1` FOREIGN KEY (`address_id_adresa`) REFERENCES `address` (`id_adresa`),
    CONSTRAINT `fk_order_users1` FOREIGN KEY (`users_id_user`) REFERENCES `users` (`id_user`),
    CONSTRAINT `FKmqsi2jlbsbp0c64aebty7r7r` FOREIGN KEY (`comenzi_id_user`) REFERENCES `users` (`id_user`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `orders`
--

LOCK TABLES ecommerce_t.`orders` WRITE;

INSERT INTO ecommerce_t.`orders` VALUES (1,20,1,1,1,'Procesat');

UNLOCK TABLES;

--
-- Table structure for table `prod_seq`
--



CREATE TABLE IF NOT EXISTS  ecommerce_t.`prod_seq` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `prod_seq`
--

LOCK TABLES ecommerce_t.`prod_seq` WRITE;

UNLOCK TABLES;

--
-- Table structure for table `product_details`
--



CREATE TABLE IF NOT EXISTS  `product_details` (
                                                  `iddetalii_produs` int NOT NULL,
                                                  `dimensiune` varchar(15) DEFAULT NULL,
    `culoare` varchar(25) DEFAULT NULL,
    PRIMARY KEY (`iddetalii_produs`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `product_details`
--

LOCK TABLES ecommerce_t.`product_details` WRITE;

UNLOCK TABLES;

--
-- Table structure for table `products`
--



CREATE TABLE IF NOT EXISTS  ecommerce_t.`products` (
                                                       `idprodus` int NOT NULL,
                                                       `nume` varchar(100) NOT NULL,
    `descriere` varchar(100) NOT NULL,
    `pret` int NOT NULL,
    `categorie_idcategorie` int NOT NULL,
    `categories_idcategorie` int DEFAULT NULL,
    PRIMARY KEY (`idprodus`),
    KEY `fk_produse_categorie1_idx` (`categorie_idcategorie`),
    KEY `FKq6ag6vlne70nunii7q5po65wv` (`categories_idcategorie`),
    CONSTRAINT `fk_produse_categorie1` FOREIGN KEY (`categorie_idcategorie`) REFERENCES `categories` (`idcategorie`),
    CONSTRAINT `FKq6ag6vlne70nunii7q5po65wv` FOREIGN KEY (`categories_idcategorie`) REFERENCES `categories` (`idcategorie`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `products`
--

LOCK TABLES ecommerce_t.`products` WRITE;

INSERT INTO ecommerce_t.`products` VALUES (1,'Geaca Nike','Descriere produs',900,1,1);

UNLOCK TABLES;

--
-- Table structure for table `roles`
--



CREATE TABLE IF NOT EXISTS  ecommerce_t.`roles` (
                                                    `id_rol` int NOT NULL,
                                                    `nume` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id_rol`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `roles`
--

LOCK TABLES ecommerce_t.`roles` WRITE;

UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--



CREATE TABLE IF NOT EXISTS  ecommerce_t.`user_roles` (
                                                         `users_id_user` int NOT NULL,
                                                         `roluri_id_rol` int NOT NULL,
                                                         KEY `fk_roluri_user_roluri1_idx` (`roluri_id_rol`),
    KEY `fk_roluri_user_users1` (`users_id_user`),
    CONSTRAINT `fk_roluri_user_roluri1` FOREIGN KEY (`roluri_id_rol`) REFERENCES `roles` (`id_rol`),
    CONSTRAINT `fk_roluri_user_users1` FOREIGN KEY (`users_id_user`) REFERENCES `users` (`id_user`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `user_roles`
--

LOCK TABLES ecommerce_t.`user_roles` WRITE;

UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--



CREATE TABLE IF NOT EXISTS  ecommerce_t.`user_seq` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `user_seq`
--

LOCK TABLES ecommerce_t.`user_seq` WRITE;

INSERT INTO ecommerce_t.`user_seq` VALUES (2002);

UNLOCK TABLES;

--
-- Table structure for table `users`
--



CREATE TABLE IF NOT EXISTS  ecommerce_t.`users` (
                                                    `id_user` int NOT NULL,
                                                    `email` varchar(200) DEFAULT NULL,
    `telefon` varchar(30) DEFAULT NULL,
    `parola` varchar(30) DEFAULT NULL,
    PRIMARY KEY (`id_user`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `users`
--

LOCK TABLES ecommerce_t.`users` WRITE;

INSERT INTO ecommerce_t.`users` VALUES (1,'malihin.mihai@gmail.com','745561211','test123'),(2,'malihin2.mihai@gmail.com','21312','mihai1233'),(3,'andrei@gmail.com','21312','andrei');

UNLOCK TABLES;

