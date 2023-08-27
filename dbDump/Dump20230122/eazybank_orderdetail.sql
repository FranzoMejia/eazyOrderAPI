-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: eazybank
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetail` (
  `id` int NOT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `client_id` int DEFAULT NULL,
  `paidmethod` varchar(255) DEFAULT NULL,
  `paid_to` varchar(255) DEFAULT NULL,
  `created_dt` datetime(6) DEFAULT NULL,
  `cancelled_dt` datetime(6) DEFAULT NULL,
  `closed_dt` datetime(6) DEFAULT NULL,
  `delivered_dt` datetime(6) DEFAULT NULL,
  `prepared_dt` datetime(6) DEFAULT NULL,
  `send_dt` datetime(6) DEFAULT NULL,
  `delivered_by` varchar(255) DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsvgxwdneklasf3af0e1wd9pqn` (`address_id`),
  KEY `FKtc1fottrkv6jvoe818xqb9jva` (`client_id`),
  CONSTRAINT `FKsvgxwdneklasf3af0e1wd9pqn` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `FKtc1fottrkv6jvoe818xqb9jva` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES (136,'/nueva ordenChanging to PREPARED:Preparado por Sara/Changing to SEND:Enviado por el se;or Alber/Changing to DELIVERED:Entregado por Fran/nCancel reason::test','210.62',107,5,106,'Efectivo',NULL,NULL,'2022-07-22 13:09:25.374564',NULL,'2022-07-21 14:53:29.096000','2022-07-13 10:49:14.219000',NULL,NULL,_binary '\0'),(138,'Ordern de 2/Changing to SEND:Send by Alber/Changing to DELIVERED:Franzo/nPaid to::Alber efectivo','999.50',110,4,106,NULL,'Alber efectivo',NULL,NULL,'2022-07-20 10:16:24.955576','2022-07-13 10:59:25.794000',NULL,NULL,NULL,_binary '\0'),(140,'Entregar el sabado','986.84',116,4,106,'Efectivo','Pagado a Jaz','2022-07-07 14:25:31.752000',NULL,'2022-11-13 11:15:54.274550','2022-07-22 17:18:11.348000',NULL,NULL,'Luis',_binary '\0'),(142,'Ordern de 2/nPaid to::Efectivo Jaz','999.50',110,4,106,NULL,'Efectivo Jaz','2022-07-07 14:29:00.012000',NULL,'2022-07-13 12:16:07.731149',NULL,NULL,NULL,NULL,_binary '\0'),(149,'Entregar Rapido/Changing to PREPARED:Preparado por Sara/Changing to SEND:Send by Fran/nCancel reason::No quiso el producto','1111.50',110,5,106,NULL,NULL,'2022-07-13 11:02:09.100000','2022-07-19 14:25:56.552973',NULL,NULL,NULL,'2022-07-13 11:04:33.111000',NULL,_binary '\0'),(153,'Entregar Rapido/nChanging to PREPARED:Preparado por Sara/nChanging to SEND:Enviado por el se;or Alber/nChanging to DELIVERED:Entregado al cliente/nChanging to CLOSED:Corte realizado','2222.50',110,4,106,NULL,NULL,'2022-07-13 11:05:49.969000',NULL,'2022-07-13 11:09:42.174915','2022-07-13 11:08:54.844000','2022-07-13 11:07:46.377000','2022-07-13 11:08:19.627000',NULL,_binary '\0'),(159,'Entregar Rapido/nChanging to PREPARED:Prepared by Liz/nChanging to SEND:Send by Alber/nDelivered by::Alber/nPaid to::Jaz BBVA','2222.50',110,4,106,NULL,NULL,'2022-07-13 11:18:48.167000',NULL,'2022-07-13 11:37:43.563256','2022-07-13 11:36:33.389000','2022-07-13 11:23:24.737000','2022-07-13 11:23:44.784000',NULL,_binary '\0'),(165,'Entregar Rapido/nChanging to PREPARED:Preparado por SAra/nChanging to SEND:Enviado por Alber/nDelivered by::Don Guadalupe/nPaid to::Tarjeta BBVA Jaz/nCancel reason::El cliente lo cancelo por retraso','2222.50',110,5,106,NULL,'Tarjeta BBVA Jaz','2022-07-13 11:38:51.588000','2022-07-13 12:00:56.064488','2022-07-13 11:42:09.081000','2022-07-13 11:41:12.447000','2022-07-13 11:40:06.149000','2022-07-13 11:40:52.626000','Don Guadalupe',_binary '\0'),(191,'sasdasda/nChanging to PREPARED:null/nChanging to SEND:null/nDelivered by::null/nPaid to::null/nCancel reason::s','123.12',110,5,106,'Efectivo',NULL,'2022-07-21 11:47:51.629000','2022-07-22 12:10:15.027162','2022-07-22 12:09:37.652000',NULL,NULL,NULL,NULL,_binary '\0'),(195,'Entregar entre la 1 y las 2/nChanging to PREPARED:null/nChanging to SEND:null/nDelivered by::null/nPaid to::null','2474.9',110,4,106,'Tarjeta',NULL,'2022-07-21 14:18:07.871000',NULL,'2022-07-21 14:22:22.311501','2022-07-21 14:22:06.456000','2022-07-21 14:21:01.391000','2022-07-21 14:21:16.345000',NULL,_binary '\0'),(252,'Entregar despues de las 2pm','369.36',110,0,106,'anilu@jazmin.com',NULL,'2022-07-22 17:18:24.289601',NULL,NULL,NULL,NULL,NULL,NULL,_binary ''),(262,'Dejar en la puerta del coto--Changing to PREPARED:Sara--Changing to SEND:Alber--Delivered by::Alber--Paid to::Jazmin','1108.08',175,4,174,'Tarjeta','Jazmin','2022-07-22 13:25:50.458000',NULL,'2022-07-22 13:26:25.421360','2022-07-22 13:26:21.386000','2022-07-22 13:26:07.872000','2022-07-22 13:26:12.826000','Alber',_binary '\0'),(271,'Dejar antes de las 8am ','874.34',116,4,106,'Efectivo','jAZ','2022-07-22 17:19:49.169000',NULL,'2022-07-22 17:24:39.718513','2022-07-22 17:24:29.818000','2022-07-22 17:23:50.337000','2022-07-22 17:24:10.237000','alber',_binary '\0'),(286,'Entregar en recepcion','865.6',110,4,106,'Tarjeta','Pagado a Don Alber','2022-11-13 13:12:52.115000',NULL,'2022-11-13 13:14:27.592215','2022-11-13 13:14:14.723000','2022-11-13 13:13:14.672000','2022-11-13 13:13:25.125000','Entregado en recepción de Tata ',_binary '\0');
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-22 13:30:30
