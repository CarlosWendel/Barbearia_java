CREATE DATABASE  IF NOT EXISTS `barbearia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `barbearia`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: barbearia
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `rg` varchar(20) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `id_agendamento` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_agendamento_fk` (`id_agendamento`),
  CONSTRAINT `cliente_agendamento_fk` FOREIGN KEY (`id_agendamento`) REFERENCES `agendamento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (3,'Carlos','M','1980-11-02','9037823627','caio@gmail.com','32425435','Juiz de Fora','36051400',NULL),(4,'pedro','M','2023-03-02','9032729280','pedro@gmail.com','329048928','mar de espanha','343535',NULL),(5,'Thais','F','2020-03-03','329732938','thais@gmail.com','342455254','santos drumond','3242455',NULL),(6,'Amanda Ester Brito','F','1974-05-07','(94) 98175-7417','amanda_brito@cognis.com','13.931.171-3','Avenida Brasília','68458-020',NULL),(7,'Oliver Mateus Baptista','M','1988-11-04','(32) 98844-2002','oliver_mateus_baptista@platinium.com.br','41.960.662-2','Jardim Glória','36015-120',NULL),(8,'Vitor Hugo','M','2002-05-04','213412424','scksjbck@skc','4234234','cscvs','31232',NULL),(9,'jesus','M','1908-09-10','2324aca','dew','df','cssd','cds',NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-02  4:17:11
