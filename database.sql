-- MySQL dump 10.13  Distrib 5.5.46, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: 
-- ------------------------------------------------------
-- Server version	5.5.46-0ubuntu0.14.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `EscolaPingoDeGenteDB`
--

CREATE DATABASE IF NOT EXISTS `EscolaPingoDeGenteDB` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `EscolaPingoDeGenteDB`;

DROP TABLE IF EXISTS `Album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Album` (
  `PK_Album` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(150) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`PK_Album`),
  UNIQUE (`titulo`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `Imagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Imagem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imagem` mediumblob NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `FK_Album` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Album` (`FK_Album`),
  CONSTRAINT `FK_Album` FOREIGN KEY (`FK_Album`) REFERENCES `Album` (`PK_Album`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Album`
--


--
-- Dumping data for table `Album`
--

LOCK TABLES `Album` WRITE;
/*!40000 ALTER TABLE `Album` DISABLE KEYS */;
INSERT INTO `Album` VALUES (1,'Álbum1','Descrição do álbum');
/*!40000 ALTER TABLE `Album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Imagem`
--




--
-- Table structure for table `Inicio`
--

DROP TABLE IF EXISTS `Inicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Inicio` (
  `quemSomos` varchar(254) DEFAULT NULL,
  `qualidade` varchar(254) DEFAULT NULL,
  `estrutura` varchar(254) DEFAULT NULL,
  `missao` varchar(254) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `Logo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Logo` (
  `imagem` mediumblob DEFAULT NULL,
  `id` int(11) AUTO_INCREMENT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `Carousel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Carousel` (
  `titulo1` varchar(100) DEFAULT NULL,
  `legenda1` varchar(254) DEFAULT NULL,
  `imagem1` mediumblob DEFAULT NULL,
   `titulo2` varchar(100) DEFAULT NULL,
  `legenda2` varchar(254) DEFAULT NULL,
  `imagem2` mediumblob DEFAULT NULL,
   `titulo3` varchar(100) DEFAULT NULL,
  `legenda3` varchar(254) DEFAULT NULL,
  `imagem3` mediumblob DEFAULT NULL,
  `id` int(11) AUTO_INCREMENT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Inicio`
--

LOCK TABLES `Inicio` WRITE;
/*!40000 ALTER TABLE `Inicio` DISABLE KEYS */;
INSERT INTO `Inicio` VALUES ('Fundada em 2003, a Escola de Educação Infantil Pingo de Gente está a 11 anos fornecendo serviços educacionais para crianças de 4 meses aos 5 anos em 11 meses.','As crianças são atendidas por profissionais qualificados e capacitados, de acordo com as normas existentes, operando sempre com um número pequeno de alunos por turma.','Conheça nossa estrutura física  e organizacional a disposição do seu filho.','Disponibilizar diferenciais educacionais praticando o ato de educar com qualidade, através de uma organização com princípios e valores adequados as necessidades dos clientes.',1);
/*!40000 ALTER TABLE `Inicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Noticias`
--

DROP TABLE IF EXISTS `Noticias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Noticias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(150) NOT NULL,
  `texto` text NOT NULL,
  `imagem` mediumblob DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `videoURL` varchar(254),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Noticias`
--



DROP TABLE IF EXISTS `Calendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Calendario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(80) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Calendario`
--

LOCK TABLES `Calendario` WRITE;
/*!40000 ALTER TABLE `Calendario` DISABLE KEYS */;
INSERT INTO `Calendario` VALUES (15,'titulo','desc','2015-12-23'),(16,'evento','desc','2015-12-30'),(17,'e','d','2016-01-12'),(18,'titulo evento','descricao evento','2016-05-04');
/*!40000 ALTER TABLE `Calendario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contato`
--

DROP TABLE IF EXISTS `Contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contato` (
  `endereco` varchar(254) DEFAULT NULL,
  `enderecoII` varchar(254) DEFAULT NULL,
  `fone1` varchar(200) DEFAULT NULL,
  `fone2` varchar(200) DEFAULT NULL,
  `fone3` varchar(200) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contato`
--

LOCK TABLES `Contato` WRITE;
/*!40000 ALTER TABLE `Contato` DISABLE KEYS */;
INSERT INTO `Contato` VALUES ('Escola I: Rua Nelson Ehlers, 379','Escola II: Rua Itália, 999','(54) 3015-1155 - I','(54) 3712-3611 - II','(54) 9961-2376',1);
/*!40000 ALTER TABLE `Contato` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `Patrocinadores`;
CREATE TABLE `Patrocinadores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imagem` mediumblob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=latin1;


--
-- Table structure for table `Sobre`

--

DROP TABLE IF EXISTS `Sobre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sobre` (
  `quemSomos` text DEFAULT NULL,
  `historia` text DEFAULT NULL,
  `estrutura` text DEFAULT NULL,
  `missao` varchar(254) DEFAULT NULL,
  `visao` varchar(254) DEFAULT NULL,
  `valores` varchar(254) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sobre`
--

LOCK TABLES `Sobre` WRITE;
/*!40000 ALTER TABLE `Sobre` DISABLE KEYS */;
INSERT INTO `Sobre` VALUES ('Pingo de Gente','Fundada em...','Salas e Parquinho','Ensinar','Ensinar','Ensinar',1);
/*!40000 ALTER TABLE `Sobre` ENABLE KEYS */;
UNLOCK TABLES;
