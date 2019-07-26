-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: EcoToll
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `autostrada`
--

DROP TABLE IF EXISTS `autostrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autostrada` (
  `idautostrada` varchar(3) NOT NULL,
  `nomeAutostrada` varchar(45) DEFAULT NULL,
  `da` varchar(45) DEFAULT NULL,
  `a` varchar(45) DEFAULT NULL,
  `lunghezza` varchar(45) DEFAULT NULL,
  `tariffaKm` decimal(4,2) DEFAULT '0.00',
  PRIMARY KEY (`idautostrada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autostrada`
--

LOCK TABLES `autostrada` WRITE;
/*!40000 ALTER TABLE `autostrada` DISABLE KEYS */;
INSERT INTO `autostrada` VALUES ('A1','Autostrada del Sole','Milano','Napoli','760',0.11),('A10','Autostrada dei Fiori','Genova','Ventimiglia','158',0.11),('A11','Autostrada Firenze-Mare','Firenze','Pisa','82',0.11),('A12','Autostrada Azzurra','Genova','Roma','250',0.11),('A13','Autostrada A13','Bologna','Padova','116',0.11),('A14','Autostrada Adriatica','Bologna','Taranto','743',0.11),('A15','Autostrada della Cisa','Parma','La Spezia','108',0.11),('A16','Autostrada dei Due Mari','Napoli','Canosa','172',0.11),('A18','Autostrada A18','Messina','Rosolini','116',0.11),('A19','Autostrada A19','Palermo','Catania','191',0.11),('A2','Autostrada del Mediterraneo','Salerno','Reggio Calabria','442',0.12),('A20','Autostrada A20','Messina','Buonfornello','181',0.12),('A21','Autostrada dei Vini','Torino','Brescia','238',0.12),('A22','Autostrada del Brennero','Brennero','Modena','310',0.12),('A23','Autostrada Alpe-Adria','Palmanova','Tarvisio','120',0.12),('A24','Autostrada dei Parchi','Roma','Teramo','166',0.12),('A25','Autostrada dei Parchi','Torano','Pescara','115',0.12),('A26','Autostrada dei Trafori','Genova Voltri','Gravellona Toce','197',0.12),('A27','Autostrada d\'Alemagna','Venezia','Belluno','82',0.12),('A28','Autostrada A28','Portogruaro','Conegliano','48',0.12),('A29','Autostrada A29','Palermo','Mazara del Vallo','114',0.12),('A3','Autostrada A3','Napoli','Salerno','50',0.13),('A30','Autostrada A30','Caserta','Salerno','55',0.13),('A31','Autostrada della Val d\'Astico','Badia Polesine','Piovene Rocchette','89',0.13),('A32','Autostrada del Frejus','Torino','Bardonecchia','72',0.13),('A33','Autostrada A33','Asti','Cuneo','90',0.13),('A34','Autostrada A34','Villesse','Gorizia','17',0.13),('A35','Autostrada BreBeMi','Brescia','Milano','62',0.13),('A36','Autostrada Pedemontana Lombarda  ','Cassano Magnago','Lentate sul Seveso','21',0.13),('A37','Autostrada Catania - Siracusa','Catania','Siracusa','25',0.13),('A4','Autostrada Serenissima','Torino','Trieste','530',0.14),('A5','Autostrada della Valle d\'Aosta','Torino','Monte Bianco','145',0.14),('A6','La Verdemare','Torino','Savona','130',0.14),('A7','Autostrada dei Giovi o Serravalle','Milano','Genova','133',0.14),('A8','Autostrada dei Laghi','Milano','Varese','42',0.14),('A9','Autostrada dei Laghi','Lainate','Chiasso','42',0.14);
/*!40000 ALTER TABLE `autostrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `casello`
--

DROP TABLE IF EXISTS `casello`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `casello` (
  `idcasello` int(11) NOT NULL AUTO_INCREMENT,
  `casello` varchar(45) DEFAULT NULL,
  `altezza` int(11) DEFAULT NULL,
  `idautostrada` varchar(3) NOT NULL,
  PRIMARY KEY (`idcasello`),
  UNIQUE KEY `idcasello_UNIQUE` (`idcasello`),
  UNIQUE KEY `casello_UNIQUE` (`casello`),
  KEY `idautostrada_idx` (`idautostrada`),
  CONSTRAINT `idautostrada` FOREIGN KEY (`idautostrada`) REFERENCES `autostrada` (`idautostrada`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casello`
--

LOCK TABLES `casello` WRITE;
/*!40000 ALTER TABLE `casello` DISABLE KEYS */;
INSERT INTO `casello` VALUES (3,'Casalpusterlengo',0,'A1'),(4,'Piacenza Nord',10,'A1'),(5,'Piacenza Sud',20,'A1'),(6,'Fiorenzuola',30,'A1'),(7,'Fidenza - Salsom.',40,'A1'),(8,'Parma',50,'A1'),(9,'Reggio Emilia',60,'A1'),(10,'Modena Nord',70,'A1'),(11,'Modena Sud',80,'A1'),(12,'Bologna Borgo Panigale',90,'A1'),(13,'Bologna Casalecchio',100,'A1'),(14,'Sasso Marconi',110,'A1'),(15,'Rioveggio',120,'A1'),(16,'Pian Del Voglio',130,'A1'),(17,'Roncobilaccio',140,'A1'),(18,'Barberino Del Mugello',150,'A1'),(19,'Calenzano',160,'A1'),(20,'Firenze Nord',170,'A1'),(21,'Firenze Signa',180,'A1'),(22,'Firenze Certosa',190,'A1'),(23,'Firenze Sud',200,'A1'),(24,'Incisa Valdarno',210,'A1'),(25,'Valdarno',220,'A1'),(27,'Monte San Savino',230,'A1'),(28,'Valdichiana',240,'A1'),(29,'Chiusi-chianciano',250,'A1'),(30,'Fabro',260,'A1'),(31,'Orvieto',270,'A1'),(33,'Orte',290,'A1'),(34,'Magliano Sabina',300,'A1'),(35,'Roma Nord',310,'A1'),(36,'Bologna San Lazzaro',0,'A14'),(37,'Imola',10,'A14'),(38,'Faenza',20,'A14'),(39,'Forli',30,'A14'),(40,'Cesena',40,'A14'),(41,'Rimini Nord',50,'A14'),(42,'Rimini Sud',60,'A14'),(43,'Riccione',70,'A14'),(44,'Cattolica',80,'A14'),(45,'Pesaro-urbino',90,'A14'),(46,'Fano',100,'A14'),(47,'Senigallia',110,'A14'),(48,'Ancona Nord',120,'A14'),(49,'Ancona Sud Osimo',130,'A14'),(50,'Loreto Porto Recanati',140,'A14'),(51,'Macerata',150,'A14'),(52,'Fermo',160,'A14'),(53,'Pedaso',170,'A14'),(54,'San Benedetto Del Tronto',180,'A14'),(55,'Teramo Giulianova',190,'A14'),(56,'Roseto Degli Abruzzi',200,'A14'),(57,'Atri Pineto',210,'A14'),(58,'Pescara Nord',220,'A14'),(59,'Marotta-mondolfo',230,'A14'),(60,'Val Vibrata',240,'A14'),(61,'Grottammare',250,'A14'),(62,'Taranto Nord',380,'A14'),(63,'Cerignola Est',330,'A14'),(64,'Foggia',300,'A14'),(65,'San Severo',320,'A14'),(66,'Poggio Imperiale',280,'A14'),(67,'Termoli Molise',270,'A14'),(68,'Vasto Sud',290,'A14'),(69,'Vasto Nord',295,'A14'),(70,'Val Di Sangro',310,'A14'),(71,'Lanciano',245,'A14'),(72,'Ortona',235,'A14'),(73,'Pescara Sud',205,'A14'),(74,'Pescara Ovest',215,'A14'),(75,'Roma Est',0,'A24'),(76,'Tivoli',10,'A24'),(77,'Castel Madama',20,'A24'),(78,'Vicovaro-mandela',30,'A24'),(79,'Carsoli Oricola',40,'A24'),(80,'Tagliacozzo',50,'A24'),(81,'Valle Del Salto',60,'A24'),(82,'Tornimparte',70,'A24'),(83,'L\'Aquila Ovest',80,'A24'),(84,'L\'Aquila Est',90,'A24'),(86,'San Gabriele',100,'A24'),(88,'Magliano Dei Marsi',0,'A25'),(89,'Avezzano',10,'A25'),(91,'Pescina',30,'A25'),(92,'Cocullo',40,'A25'),(93,'Pratola Sulmona',50,'A25'),(94,'Bussi Popoli',60,'A25'),(95,'Casauria',70,'A25'),(96,'Scafa Alanno',80,'A25'),(97,'Chieti-pescara',90,'A25'),(98,'Pescara Villanova',100,'A25'),(109,'Teramo',110,'A24');
/*!40000 ALTER TABLE `casello` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classeEU`
--

DROP TABLE IF EXISTS `classeEU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classeEU` (
  `idclasseEU` int(11) NOT NULL,
  `classeEU` varchar(45) DEFAULT NULL,
  `moltiplicatore` float DEFAULT NULL,
  PRIMARY KEY (`idclasseEU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classeEU`
--

LOCK TABLES `classeEU` WRITE;
/*!40000 ALTER TABLE `classeEU` DISABLE KEYS */;
INSERT INTO `classeEU` VALUES (1,'EU1',0.85),(2,'EU2',0.95),(3,'EU3',1),(4,'EU4',1.2),(5,'EU5',1.3),(6,'EU6',1.6);
/*!40000 ALTER TABLE `classeEU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classeIT`
--

DROP TABLE IF EXISTS `classeIT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classeIT` (
  `idclasseIT` int(11) NOT NULL,
  `classe` varchar(45) DEFAULT NULL,
  `moltiplicatore` float DEFAULT NULL,
  PRIMARY KEY (`idclasseIT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classeIT`
--

LOCK TABLES `classeIT` WRITE;
/*!40000 ALTER TABLE `classeIT` DISABLE KEYS */;
INSERT INTO `classeIT` VALUES (1,'A',1),(2,'B',1.04),(3,'3',1.1),(4,'4',1.5),(5,'5',2);
/*!40000 ALTER TABLE `classeIT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `normativa`
--

DROP TABLE IF EXISTS `normativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `normativa` (
  `idnormativa` int(11) NOT NULL AUTO_INCREMENT,
  `normativa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idnormativa`),
  UNIQUE KEY `idnormativa_UNIQUE` (`idnormativa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `normativa`
--

LOCK TABLES `normativa` WRITE;
/*!40000 ALTER TABLE `normativa` DISABLE KEYS */;
INSERT INTO `normativa` VALUES (1,'Italiana');
/*!40000 ALTER TABLE `normativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruolo`
--

DROP TABLE IF EXISTS `ruolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruolo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(45) DEFAULT 'utente',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruolo`
--

LOCK TABLES `ruolo` WRITE;
/*!40000 ALTER TABLE `ruolo` DISABLE KEYS */;
INSERT INTO `ruolo` VALUES (1,'amministratore'),(2,'utente');
/*!40000 ALTER TABLE `ruolo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storico`
--

DROP TABLE IF EXISTS `storico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storico` (
  `idstorico` int(11) NOT NULL AUTO_INCREMENT,
  `targa` varchar(45) DEFAULT NULL,
  `da` varchar(45) DEFAULT NULL,
  `a` varchar(45) DEFAULT NULL,
  `pedaggio` float DEFAULT NULL,
  `normativa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idstorico`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storico`
--

LOCK TABLES `storico` WRITE;
/*!40000 ALTER TABLE `storico` DISABLE KEYS */;
INSERT INTO `storico` VALUES (1,'AA111AA','Atri Pineto','Ancona Sud Osimo',8.8,'Italiana'),(19,'AA111AA','Ancona Nord','Ancona Sud Osimo',1.1,'Italiana'),(20,'AA111AA','Ancona Nord','Ancona Sud Osimo',1.1,'Europea'),(21,'AA111AA','Ancona Nord','Vasto Nord',19.25,'Europea'),(22,'AA111AA','Ancona Sud Osimo','Vasto Nord',18.15,'Italiana'),(23,'AA111AA','Ancona Nord','Vasto Nord',19.25,'Italiana'),(24,'AA111AA','Ancona Nord','Vasto Nord',19.25,'Italiana'),(25,'AA111AA','Ancona Nord','Vasto Nord',20.02,'Europea'),(26,'AA111AA','Ancona Nord','Ancona Sud Osimo',1.144,'Europea'),(27,'AA111AA','Ancona Nord','Vasto Nord',20.02,'Europea'),(28,'Europea','Ancona Nord','Ancona Sud Osimo',1.144,'AA111AA'),(29,'AA111AA','Ancona Sud Osimo','Ancona Nord',1.144,'Europea'),(30,'AA111AA','Ancona Nord','Ancona Sud Osimo',1.144,'Europea'),(31,'AA111AA','Ancona Sud Osimo','Parma',9.152,'Europea'),(32,'AA111AA','Ancona Nord','Ancona Sud Osimo',1.1,'Europea'),(33,'AA111AA','Ancona Nord','Vasto Sud',19.4,'Europea'),(34,'AA111AA','Ancona Nord','Ancona Sud Osimo',1.1,'Europea'),(35,NULL,'Ancona Nord','Ancona Sud Osimo',1.1,'Europea'),(36,NULL,'Ancona Nord','Ancona Sud Osimo',1.1,'Europea'),(37,'AA111AA','Ancona Sud Osimo','Ancona Nord',1.1,'Europea'),(38,'AA111AA','Ancona Nord','Vasto Nord',20,'Europea'),(39,'AA111AA','Ancona Nord','Vasto Sud',19.4,'Europea'),(40,'AA111AA','Ancona Nord','Val Vibrata',13.7,'Europea'),(41,'AA111AA','Ancona Sud Osimo','Ancona Nord',1.1,'Europea'),(42,'AA111AA','Ancona Nord','Ancona Sud Osimo',1.1,'Europea'),(43,'AA111AA','Ancona Nord','Bussi Popoli',6.9,'Europea'),(44,'AA111AA','Ancona Nord','Castel Madama',11.4,'Europea'),(45,'BB222BB','Atri Pineto','Bologna Borgo Panigale',14.5,'Europea'),(46,'BB222BB','Atri Pineto','Fidenza - Salsom.',20.6,'Europea'),(47,'BB222BB','Atri Pineto','Fidenza - Salsom.',20.6,'Europea'),(48,'AA111AA','Bussi Popoli','Ancona Nord',7.5,'Europea'),(49,'AA111AA','Ancona Nord','Ancona Nord',0,'Europea'),(50,'AA111AA','Ancona Nord','Chieti-pescara',3.4,'Europea'),(51,'AA111AA','Ancona Sud Osimo','Chieti-pescara',4.6,'Europea'),(52,'BB222BB','Atri Pineto','Fidenza - Salsom.',20.6,'Europea'),(53,'AA111AA','Ancona Nord','Bologna San Lazzaro',13.7,'Europea'),(54,'AA111AA','Ancona Nord','Atri Pineto',10.3,'Europea'),(55,'AA111AA','Ancona Nord','Ancona Nord',0,'Europea'),(56,'AA111AA','Ancona Nord','Ancona Sud Osimo',1.1,'Europea'),(57,'AA111AA','Ancona Nord','Ancona Sud Osimo',1.1,'Europea'),(58,'AA111AA','Ancona Nord','Ancona Sud Osimo',1.1,'Italiana'),(59,'AA111AA','Ancona Nord','Ancona Sud Osimo',1.1,'Italiana'),(60,'AA111AA','Ancona Nord','Ancona Nord',0,'Italiana'),(61,'AA111AA','Ancona Sud Osimo','Ancona Nord',1.1,'Italiana'),(62,'AA111AA','Ancona Sud Osimo','Ancona Nord',1.1,'Italiana'),(63,'AA111AA','Ancona Sud Osimo','Ancona Sud Osimo',0,'Italiana');
/*!40000 ALTER TABLE `storico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utente` (
  `idutente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `ruolo` int(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`idutente`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `id_idx` (`ruolo`),
  CONSTRAINT `id` FOREIGN KEY (`ruolo`) REFERENCES `ruolo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'laura','di egidio','laura','laura',1),(2,'marco','marco','marco','marco',1),(4,'fabio','fabio','fabio','fabio',1),(52,'giulio','giulio','giulio','giulio',2),(53,'user','user','user','user',2),(54,'sss','sss','sss','sss',2),(55,'txtUserName','txtUserName','txtUserName','password',2),(56,'andrea','andrea','andrea','andrea',2),(57,'a','a','a','a',2);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veicolo`
--

DROP TABLE IF EXISTS `veicolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veicolo` (
  `idveicolo` int(11) NOT NULL,
  `targa` varchar(45) DEFAULT NULL,
  `idclasseIT` int(11) DEFAULT NULL,
  `idclasseEU` int(11) DEFAULT NULL,
  PRIMARY KEY (`idveicolo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veicolo`
--

LOCK TABLES `veicolo` WRITE;
/*!40000 ALTER TABLE `veicolo` DISABLE KEYS */;
INSERT INTO `veicolo` VALUES (1,'AQ120788',1,1),(2,'AA111AA',1,2),(3,'BB222BB',2,3),(4,'CC333CC',1,3),(5,'DD444DD',4,5),(6,'EE555EE',3,4),(7,'FF666FF',5,2);
/*!40000 ALTER TABLE `veicolo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-26 12:14:37
