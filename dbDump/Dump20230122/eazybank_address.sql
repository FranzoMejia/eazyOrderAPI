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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKffe4aybw86djvowd2i71xgldy` (`address_id`),
  CONSTRAINT `FKffe4aybw86djvowd2i71xgldy` FOREIGN KEY (`address_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (107,'Calle Hacienda de la Herradura 1680, Colonia Oblatos, Guadalajara, Jalisco','https://www.google.com/maps/place/C.+Hacienda+de+la+Herradura+1680,+Colonia+Oblatos,+44700+Guadalajara,+Jal./@20.6960293,-103.2970263,17z/data=!3m1!4b1!4m5!3m4!1s0x8428b11480b6508d:0xf15c598ec89a9a0f!8m2!3d20.6960243!4d-103.2948376',106),(110,'Technology Park, Avenida Inglaterra, Jalisco','https://www.google.com/maps/place/Technology+Park/@20.7222522,-103.4944179,17z/data=!3m1!4b1!4m5!3m4!1s0x8428a8f49adcc915:0x99ea93c237e4b8fa!8m2!3d20.7222472!4d-103.4922292',106),(116,'Calle Hacienda Santiago 2421, Colonia Oblatos, Guadalajara, Jal.','https://www.google.com/maps/place/Calle+Hacienda+Santiago+2421,+Colonia+Oblatos,+44700+Guadalajara,+Jal./@20.6948689,-103.2969812,17z/data=!3m1!4b1!4m5!3m4!1s0x8428b11499252015:0xbc4a609aedfd4c35!8m2!3d20.6948639!4d-103.2947925',106),(117,'Villas del Oriente 12G','https://www.google.com/maps/place/El+Bat%C3%A1n,+45190+Zapopan,+Jal./@20.7216799,-103.3475931,17z/data=!3m1!4b1!4m5!3m4!1s0x8428b0304a7be475:0x1a2093a93a05c6c4!8m2!3d20.7221151!4d-103.3450117',106),(127,'Ana Lilia','asdasd',126),(175,'Casa ','https://www.google.com/maps/place/Calle+Villas+del+Ote.+14G,+Villas+Alcalde,+45190+Zapopan,+Jal./@20.7543876,-103.4435858,12.72z/data=!4m5!3m4!1s0x8428b0317d427243:0xa26c8aa668234e2e!8m2!3d20.7186278!4d-103.3436465',174);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-22 13:30:36
