-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: misyemek
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adres`
--

DROP TABLE IF EXISTS `adres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adres` (
  `adres_id` int NOT NULL AUTO_INCREMENT,
  `sehir` varchar(45) NOT NULL,
  `ilce` varchar(45) NOT NULL,
  `mahalle` varchar(45) NOT NULL,
  `ulke` varchar(45) NOT NULL DEFAULT 'Türkiye',
  PRIMARY KEY (`adres_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adres`
--

LOCK TABLES `adres` WRITE;
/*!40000 ALTER TABLE `adres` DISABLE KEYS */;
INSERT INTO `adres` VALUES (2,'Ankara','Akyurt','Balıkhisar','Türkiye'),(3,'Ankara','Akyurt','Beyazıt2','Türkiye'),(4,'Ankara','Altındağ','Ulus','Türkiye'),(5,'Ankara','Altındağ','Anafartalar','Türkiye'),(6,'Ankara','Ayaş','Akkaya','Türkiye'),(7,'İstanbul','Arnavutköy','Merkez','Türkiye'),(8,'İstanbul','Kadıköy','Kadıköy','Türkiye'),(9,'Ankara','Akyurt','Balıkhisar','Türkiye'),(10,'Ankara','Akyurt','Beyazıt','Türkiye'),(11,'Ankara','Akyurt','Beyazıt','Türkiye'),(12,'Ankara','Akyurt','Balıkhisar','Türkiye'),(13,'Ankara','Akyurt','Beyazıt','Türkiye'),(14,'Ankara','Akyurt','Balıkhisar','Türkiye');
/*!40000 ALTER TABLE `adres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `firma`
--

DROP TABLE IF EXISTS `firma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `firma` (
  `firma_id` int NOT NULL,
  `firma_tel_no` varchar(45) NOT NULL,
  `firma_adi` varchar(45) NOT NULL,
  `firma_adres_id` int NOT NULL,
  PRIMARY KEY (`firma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `firma`
--

LOCK TABLES `firma` WRITE;
/*!40000 ALTER TABLE `firma` DISABLE KEYS */;
INSERT INTO `firma` VALUES (1,'123','Anadolu Kebap Evi',2),(2,'231','Boğaziçi Balık',2),(3,'321','Cadde Burger',2),(4,'1234567890','Dostlar Pide Salonu',11),(5,'564','Ege Mutfağı',4),(6,'654','Gurme Pizza',5),(7,'645','Harman Mantı',6),(8,'579','Işıklar Lokantası',2),(9,'436','Keyif Dürüm',9);
/*!40000 ALTER TABLE `firma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `firma_sahibi`
--

DROP TABLE IF EXISTS `firma_sahibi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `firma_sahibi` (
  `firma_sahibi_id` int NOT NULL,
  `firma_id` int NOT NULL,
  `kullanici_id` int NOT NULL,
  PRIMARY KEY (`firma_sahibi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `firma_sahibi`
--

LOCK TABLES `firma_sahibi` WRITE;
/*!40000 ALTER TABLE `firma_sahibi` DISABLE KEYS */;
INSERT INTO `firma_sahibi` VALUES (1,1,6),(2,2,7),(3,3,8),(4,4,9),(5,5,11);
/*!40000 ALTER TABLE `firma_sahibi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `firma_urun`
--

DROP TABLE IF EXISTS `firma_urun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `firma_urun` (
  `firma_urun_id` int NOT NULL AUTO_INCREMENT,
  `fiyat` double NOT NULL,
  `firma_id` int NOT NULL,
  `urun_id` int NOT NULL,
  PRIMARY KEY (`firma_urun_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `firma_urun`
--

LOCK TABLES `firma_urun` WRITE;
/*!40000 ALTER TABLE `firma_urun` DISABLE KEYS */;
INSERT INTO `firma_urun` VALUES (1,240,1,14),(3,380,2,32),(5,180,3,1),(12,90,8,12),(13,170,9,8),(14,260,8,16),(15,260,1,15),(16,220,1,16),(17,90,1,2),(18,180,1,3),(19,80,1,12),(20,70,1,13),(21,30,1,23),(22,30,1,24),(23,120,1,20),(24,360,2,33),(25,280,2,34),(26,340,2,35),(27,150,2,36),(28,80,2,12),(29,70,2,13),(30,45,2,25),(31,15,2,48),(32,90,2,22),(33,200,3,26),(34,170,3,27),(35,80,3,28),(36,70,3,13),(37,10,3,10),(38,10,3,11),(39,40,3,29),(40,30,3,23),(41,200,4,30),(42,240,4,31),(43,90,4,2),(44,80,4,12),(45,70,4,13),(46,30,4,23),(47,130,4,21),(48,160,5,37),(49,150,5,38),(50,120,5,39),(51,110,5,40),(52,70,5,13),(53,80,5,12),(54,45,5,25),(55,90,5,22),(56,220,6,6),(57,210,6,41),(58,260,6,42),(59,250,6,43),(60,80,6,28),(61,70,6,13),(62,40,6,29),(63,45,6,25),(64,190,7,7),(65,210,7,44),(66,160,7,45),(67,80,7,12),(68,70,7,13),(69,30,7,23),(70,90,7,22),(71,120,7,20),(72,240,8,5),(73,160,8,46),(74,70,8,47),(75,70,8,13),(76,30,8,23),(77,90,8,22),(78,200,9,9),(79,180,9,17),(80,90,9,18),(81,150,9,19),(82,30,9,23),(83,30,9,24),(84,130,9,21),(85,150,4,57);
/*!40000 ALTER TABLE `firma_urun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kullanici`
--

DROP TABLE IF EXISTS `kullanici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kullanici` (
  `kullanici_adi` varchar(45) NOT NULL,
  `kullanici_sifresi` varchar(255) NOT NULL,
  `kullanici_tel_no` varchar(45) NOT NULL,
  `kullanici_id` int NOT NULL AUTO_INCREMENT,
  `kullanici_rol` varchar(45) NOT NULL,
  `kullanici_adres_id` bigint DEFAULT NULL,
  PRIMARY KEY (`kullanici_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullanici`
--

LOCK TABLES `kullanici` WRITE;
/*!40000 ALTER TABLE `kullanici` DISABLE KEYS */;
INSERT INTO `kullanici` VALUES ('İrem Eroğlu','1234','5678901234',6,'ADMIN',5),('Kutay Eroğlu','1234','6789012345',7,'ADMIN',6),('Alper Eroğlu','1234','7890123456',8,'ADMIN',7),('admin','$2a$10$uS805PT6oe5pmAD6GrNPw.ZlXJj8jTKhksFPZS3WRZx1nv9mSrYqa','5551112233',9,'ADMIN',10),('kullanıcı','$2a$10$Ndy6MgqLTLzy.Ie0z0DgbebzIUEtyWsiuna8dNY4TJggOw2DjLipq','5551112233',10,'KULLANICI',12),('x kullanicisi','1234','1544498414',11,'ADMIN',9),('kurye','$2a$10$S4yWrRdPxa32WVPXnjIXkuMy8Tx8l3UZwaPoN5L64Dr08K63AQcHi','5550001122',13,'KURYE',13),('mete','$2a$10$LiIt9c24wxv7KzSe6h.2qOqHwu5dSDCGQCXAqLbDClS6iRYlRvreC','123',14,'KURYE',14),('alper','$2a$10$qA0xjjGfWMR8rY3mhDw4xOT2MmaGytakPBIp0Y/i5GPcp6pFpO45O','123',15,'KULLANICI',NULL);
/*!40000 ALTER TABLE `kullanici` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `siparis`
--

DROP TABLE IF EXISTS `siparis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `siparis` (
  `siparis_id` int NOT NULL AUTO_INCREMENT,
  `urun_firma_id` int NOT NULL,
  `kullanici_id` int NOT NULL,
  `adet` int NOT NULL,
  `siparis_tarih_saat` datetime NOT NULL,
  `siparis_durumu` varchar(45) NOT NULL,
  `grup_no` int NOT NULL,
  PRIMARY KEY (`siparis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `siparis`
--

LOCK TABLES `siparis` WRITE;
/*!40000 ALTER TABLE `siparis` DISABLE KEYS */;
INSERT INTO `siparis` VALUES (109,41,13,1,'2026-07-27 15:29:31','TESLIM_EDILDI',0),(110,42,9,1,'2026-07-27 17:16:39','IPTAL',0),(111,41,9,1,'2026-07-29 08:08:07','TESLIM_EDILDI',0),(112,42,9,9,'2026-07-29 11:02:12','TESLIM_EDILDI',0),(113,42,9,1,'2026-07-29 15:46:05','YOLDA',1),(114,43,9,1,'2026-07-29 15:46:14','YOLDA',1),(115,44,9,1,'2026-07-29 15:46:14','YOLDA',1),(117,15,9,1,'2026-07-29 17:08:35','SEPETTE',0),(118,43,9,1,'2026-07-29 17:08:39','SEPETTE',0);
/*!40000 ALTER TABLE `siparis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `urun`
--

DROP TABLE IF EXISTS `urun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `urun` (
  `urun_adi` varchar(255) NOT NULL,
  `urun_id` int NOT NULL AUTO_INCREMENT,
  `urun_turu` varchar(45) NOT NULL,
  PRIMARY KEY (`urun_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urun`
--

LOCK TABLES `urun` WRITE;
/*!40000 ALTER TABLE `urun` DISABLE KEYS */;
INSERT INTO `urun` VALUES ('Hamburger',1,'FASTFOOD'),('Lahmacun',2,'LAHMACUN'),('Pide',3,'PIDE'),('Tavuk Tabağı',5,'EV_YEMEGI'),('Pizza',6,'FASTFOOD'),('Mantı',7,'MANTI'),('Tavuk Dürüm',8,'DURUM'),('Et Dürüm',9,'DURUM'),('Ketçap',10,'SOS'),('Mayonez',11,'SOS'),('Mercimek Çorbası',12,'CORBA'),('Salata',13,'SALATA'),('Adana Kebap',14,'KEBAP'),('İskender',15,'KEBAP'),('Izgara Köfte',16,'KEBAP'),('Tantuni',17,'SOKAK_LEZZETI'),('Çiğ Köfte',18,'SOKAK_LEZZETI'),('Kumpir',19,'SOKAK_LEZZETI'),('Baklava',20,'TATLI'),('Künefe',21,'TATLI'),('Sütlaç',22,'TATLI'),('Ayran',23,'ICECEK'),('Şalgam',24,'ICECEK'),('Limonata',25,'ICECEK'),('Cheeseburger',26,'FASTFOOD'),('Tavuk Burger',27,'FASTFOOD'),('Patates Kızartması',28,'FASTFOOD'),('Kola',29,'ICECEK'),('Kaşarlı Pide',30,'PIDE'),('Kuşbaşılı Pide',31,'PIDE'),('Levrek Izgara',32,'BALIK'),('Çipura Izgara',33,'BALIK'),('Kalamar Tava',34,'BALIK'),('Karides Güveç',35,'BALIK'),('Balık Ekmek',36,'BALIK'),('Zeytinyağlı Enginar',37,'MEZE'),('Ot Kavurma',38,'EV_YEMEGI'),('Mücver',39,'MEZE'),('Şakşuka',40,'MEZE'),('Margherita Pizza',41,'FASTFOOD'),('Karışık Pizza',42,'FASTFOOD'),('Sucuklu Pizza',43,'FASTFOOD'),('Kayseri Mantısı',44,'MANTI'),('Erişte',45,'EV_YEMEGI'),('Kuru Fasulye',46,'EV_YEMEGI'),('Pilav',47,'EV_YEMEGI'),('Su',48,'ICECEK'),('Kıymalı Pide',57,'PIDE');
/*!40000 ALTER TABLE `urun` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-07-29 21:33:40
