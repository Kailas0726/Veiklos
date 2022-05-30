-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: veiklos
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `partijos`
--

DROP TABLE IF EXISTS `partijos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partijos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `partija` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partijos`
--

LOCK TABLES `partijos` WRITE;
/*!40000 ALTER TABLE `partijos` DISABLE KEYS */;
INSERT INTO `partijos` VALUES (1,'Partija A'),(2,'Partija B'),(3,'Partija C');
/*!40000 ALTER TABLE `partijos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiklos`
--

DROP TABLE IF EXISTS `veiklos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veiklos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `veikla` varchar(255) NOT NULL,
  `aprasymas` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiklos`
--

LOCK TABLES `veiklos` WRITE;
/*!40000 ALTER TABLE `veiklos` DISABLE KEYS */;
INSERT INTO `veiklos` VALUES (12,'Sportas','Įvairūs sporto uzsiėmimai'),(13,'Dainavimas','Karaokė, dainavimo pamokos, choras'),(14,'Skaitymo burelis','Knygų skaitymas, aptarimas, diskutavimas');
/*!40000 ALTER TABLE `veiklos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zmones`
--

DROP TABLE IF EXISTS `zmones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zmones` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vardas` varchar(255) NOT NULL,
  `pavarde` varchar(255) NOT NULL,
  `elektroninis_pastas` varchar(255) NOT NULL,
  `telefono_numeris` varchar(255) NOT NULL,
  `id_partijos` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi0dwkbjiko4hosftuf8sbfjrc` (`id_partijos`),
  CONSTRAINT `FKi0dwkbjiko4hosftuf8sbfjrc` FOREIGN KEY (`id_partijos`) REFERENCES `partijos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zmones`
--

LOCK TABLES `zmones` WRITE;
/*!40000 ALTER TABLE `zmones` DISABLE KEYS */;
INSERT INTO `zmones` VALUES (16,'John','Johnson','John.Johnson@gmail.com','866666666',1),(17,'Ben','Benson','Ben.Benson@gmail.com','867777777',2),(18,'Brian','Brianson','Brian.Brianson@gmail.com','868888888',3),(19,'Paul','Paulson','Paul.Paulson@gmail.com','865555555',1),(20,'Kevin','Kevinson','Kevin.Kevinson@gmail.com','864444444',2),(21,'Ryan','Ryanson','Ryan.Ryanson@gmail.com','863333333',3),(22,'Eric','Ericson','Eric.Ericson@gmail.com','862222222',1);
/*!40000 ALTER TABLE `zmones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zmones_veiklos`
--

DROP TABLE IF EXISTS `zmones_veiklos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zmones_veiklos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zmones_id` int(10) unsigned DEFAULT NULL,
  `veiklos_id` int(10) unsigned DEFAULT NULL,
  `kontaktai` varchar(255) NOT NULL,
  `veiklos_vieta` varchar(255) NOT NULL,
  `veiklos_sritis` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsanl6okpq2dvvsjvg9xvbaxc3` (`zmones_id`),
  KEY `FK993womd6u7ky74rolu1u1ksap` (`veiklos_id`),
  CONSTRAINT `FK993womd6u7ky74rolu1u1ksap` FOREIGN KEY (`veiklos_id`) REFERENCES `veiklos` (`id`),
  CONSTRAINT `FKsanl6okpq2dvvsjvg9xvbaxc3` FOREIGN KEY (`zmones_id`) REFERENCES `zmones` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zmones_veiklos`
--

LOCK TABLES `zmones_veiklos` WRITE;
/*!40000 ALTER TABLE `zmones_veiklos` DISABLE KEYS */;
INSERT INTO `zmones_veiklos` VALUES (22,16,12,'866666666','Kaunas','Futbolo treniruotės'),(24,17,13,'+37068888888','Vilnius','Dainavimo pamokos'),(25,18,14,'+37069999999','Palanga','Knygų aptarimas'),(26,19,12,'866666666','Kaunas','Krepšinio treniruotės'),(28,20,13,'+37068888888','Vilnius','Choras'),(29,21,14,'+37069999999','Palanga','Diskusija apie naujausias knygas'),(30,22,12,'866666666','Kaunas','Teniso treniruotės');
/*!40000 ALTER TABLE `zmones_veiklos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-06 14:05:58
