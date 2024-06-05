-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: booking-db
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `rezervacija`
--

DROP TABLE IF EXISTS `rezervacija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rezervacija` (
  `rezervacija_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `surname` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `room` int NOT NULL,
  `rezervacija_tip_id` int unsigned NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`rezervacija_id`),
  KEY `fk_rezervacija_rezervacija_tip_idx` (`rezervacija_tip_id`),
  CONSTRAINT `fk_rezervacija_rezervacija_tip` FOREIGN KEY (`rezervacija_tip_id`) REFERENCES `rezervacija_tip` (`rezervacija_tip_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezervacija`
--

LOCK TABLES `rezervacija` WRITE;
/*!40000 ALTER TABLE `rezervacija` DISABLE KEYS */;
INSERT INTO `rezervacija` VALUES (1,'Dejan','Pavlovic',2,1,'2024-06-02 14:35:23',NULL,NULL),(2,'Stefan','Filipovic',3,2,'2024-06-02 14:35:23',NULL,'2024-06-04 14:51:22'),(3,'Marko','Petrovic',1,3,'2024-06-04 14:57:50','2024-06-04 14:57:50',NULL),(4,'Uros','Arsic',2,1,'2024-06-03 14:18:02',NULL,NULL),(5,'Dejan','Pavlovic',3,2,'2024-06-03 18:04:17',NULL,'2024-06-04 14:34:23'),(6,'Ivan','Ivanovic',1,4,'2024-06-03 18:05:27',NULL,NULL),(7,'Nemanja','Nikolic',2,5,'2024-06-03 19:03:41',NULL,NULL),(8,'Tijana','Markovic',1,5,'2024-06-04 14:58:31',NULL,NULL);
/*!40000 ALTER TABLE `rezervacija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rezervacija_tip`
--

DROP TABLE IF EXISTS `rezervacija_tip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rezervacija_tip` (
  `rezervacija_tip_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`rezervacija_tip_id`),
  UNIQUE KEY `uq_rezervacija_tip_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezervacija_tip`
--

LOCK TABLES `rezervacija_tip` WRITE;
/*!40000 ALTER TABLE `rezervacija_tip` DISABLE KEYS */;
INSERT INTO `rezervacija_tip` VALUES (1,'Hotel','2024-06-04 17:11:29',NULL,NULL),(2,'Apartman','2024-06-04 17:11:29',NULL,NULL),(3,'Vila','2024-06-04 17:11:29',NULL,NULL),(4,'Rezort','2024-06-04 17:11:29',NULL,NULL),(5,'Hostel','2024-06-04 17:11:29',NULL,NULL),(6,'Pansion sa uslugom dorucka','2024-06-04 17:11:29',NULL,NULL),(7,'Pansion','2024-06-04 17:11:29',NULL,NULL);
/*!40000 ALTER TABLE `rezervacija_tip` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-05 12:49:57
