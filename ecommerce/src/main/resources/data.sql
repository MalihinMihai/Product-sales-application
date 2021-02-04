--
-- Table structure for table `address`
--


CREATE TABLE IF NOT EXISTS `address` (
                                         `id_adresa` int NOT NULL,
                                         `nume_complet` varchar(100) DEFAULT NULL,
                                         `adresa` varchar(100) DEFAULT NULL,
                                         `oras` varchar(100) DEFAULT NULL,
                                         `user_id_user` int DEFAULT NULL,
                                         PRIMARY KEY (`id_adresa`),
                                         KEY `FKllru83q5c06h1nbo9oe3xhue3` (`user_id_user`),
                                         CONSTRAINT `FKllru83q5c06h1nbo9oe3xhue3` FOREIGN KEY (`user_id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;

INSERT INTO `address` VALUES (1,'Malihin Mihai','STR.X AP.Y NR.Z','Brasov',1);

UNLOCK TABLES;

--
-- Table structure for table `address_seq`
--


CREATE TABLE IF NOT EXISTS `address_seq` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `address_seq`
--

LOCK TABLES `address_seq` WRITE;

INSERT INTO `address_seq` VALUES (2);

UNLOCK TABLES;

--
-- Table structure for table `cat_seq`
--

CREATE TABLE IF NOT EXISTS `cat_seq` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `cat_seq`
--

LOCK TABLES `cat_seq` WRITE;

INSERT INTO `cat_seq` VALUES (2);

UNLOCK TABLES;

--
-- Table structure for table `categories`
--


CREATE TABLE IF NOT EXISTS `categories` (
                                            `idcategorie` int NOT NULL,
                                            `nume` varchar(100) NOT NULL,
                                            PRIMARY KEY (`idcategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;

INSERT INTO `categories` VALUES (1,'Nike');

UNLOCK TABLES;

--
-- Table structure for table `order_seq`
--


CREATE TABLE IF NOT EXISTS `order_seq` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `order_seq`
--

LOCK TABLES `order_seq` WRITE;

INSERT INTO `order_seq` VALUES (2);

UNLOCK TABLES;

--
-- Table structure for table `orders`
--


CREATE TABLE IF NOT EXISTS `orders` (
                                        `id_order` int NOT NULL,
                                        `cantitate` int NOT NULL,
                                        `users_id_user` int NOT NULL,
                                        `address_id_adresa` int NOT NULL,
                                        `status_comanda` varchar(255) DEFAULT NULL,
                                        `comenzi_id_user` int DEFAULT NULL,
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

LOCK TABLES `orders` WRITE;

INSERT INTO `orders` VALUES (1,1,1,1,'Preluat',NULL);

UNLOCK TABLES;

--
-- Table structure for table `prod_seq`
--


CREATE TABLE `prod_seq` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `prod_seq`
--

LOCK TABLES `prod_seq` WRITE;

INSERT INTO `prod_seq` VALUES (2);

UNLOCK TABLES;

--
-- Table structure for table `products`
--


CREATE TABLE IF NOT EXISTS `products` (
                                          `idprodus` int NOT NULL,
                                          `nume` varchar(100) NOT NULL,
                                          `dimensiune` varchar(100) NOT NULL,
                                          `culoare` varchar(100) NOT NULL,
                                          `pret` int NOT NULL,
                                          `categories_idcategorie` int DEFAULT NULL,
                                          `descriere` varchar(255) DEFAULT NULL,
                                          PRIMARY KEY (`idprodus`),
                                          KEY `FKq6ag6vlne70nunii7q5po65wv` (`categories_idcategorie`),
                                          CONSTRAINT `FKq6ag6vlne70nunii7q5po65wv` FOREIGN KEY (`categories_idcategorie`) REFERENCES `categories` (`idcategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;

INSERT INTO `products` VALUES (1,'Geaca Nike','XXL','Negru',300,1,'Descriere produs');

UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--


CREATE TABLE IF NOT EXISTS `user_seq` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;

INSERT INTO `user_seq` VALUES (2);

UNLOCK TABLES;

--
-- Table structure for table `users`
--


CREATE TABLE IF NOT EXISTS `users` (
                                       `id_user` int NOT NULL,
                                       `email` varchar(200) DEFAULT NULL,
                                       `telefon` varchar(30) DEFAULT NULL,
                                       `parola` varchar(30) DEFAULT NULL,
                                       PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;

INSERT INTO `users` VALUES (1,'user1@gmail.com','745561211','user123');

UNLOCK TABLES;

