CREATE DATABASE  IF NOT EXISTS `CourseWorkSchema` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `CourseWorkSchema`;
-- MySQL dump 10.13  Distrib 5.7.13, for linux-glibc2.5 (x86_64)
--
-- Host: 127.0.0.1    Database: CourseWorkSchema
-- ------------------------------------------------------
-- Server version	5.7.16-0ubuntu0.16.04.1

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
-- Table structure for table `Attestation`
--

DROP TABLE IF EXISTS `Attestation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Attestation` (
  `idAttestation` int(11) NOT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `idStudent_fk` int(11) NOT NULL,
  `idSubject_fk` int(11) NOT NULL,
  PRIMARY KEY (`idAttestation`),
  KEY `fk_Attestation_1_idx` (`idStudent_fk`),
  KEY `fk_Attestation_Subject_fk_idx` (`idSubject_fk`),
  CONSTRAINT `fk_Attestation_1` FOREIGN KEY (`idStudent_fk`) REFERENCES `Student` (`idStudent`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attestation_Subject_fk` FOREIGN KEY (`idSubject_fk`) REFERENCES `Subject` (`idSubject`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Attestation`
--

LOCK TABLES `Attestation` WRITE;
/*!40000 ALTER TABLE `Attestation` DISABLE KEYS */;
INSERT INTO `Attestation` VALUES (1,'',1,100011);
/*!40000 ALTER TABLE `Attestation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cafedra`
--

DROP TABLE IF EXISTS `Cafedra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cafedra` (
  `idCafedra` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `idFaculty_fk` int(11) NOT NULL,
  PRIMARY KEY (`idCafedra`),
  UNIQUE KEY `Name_UNIQUE` (`Name`),
  KEY `fk_Cafedra_Faculty_fk_idx` (`idFaculty_fk`),
  CONSTRAINT `fk_Cafedra_Faculty_fk` FOREIGN KEY (`idFaculty_fk`) REFERENCES `Faculty` (`idFaculty`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cafedra`
--

LOCK TABLES `Cafedra` WRITE;
/*!40000 ALTER TABLE `Cafedra` DISABLE KEYS */;
INSERT INTO `Cafedra` VALUES (1100,'Department of Technical Systems Automation and Control	',1000),(1200,'Department of Technical Cybernetics	',1000),(1300,'Department of Computer Engineering	',1000),(1400,'Department of Computer-Aided Management and Data Processing Systems',1000),(2100,'Department of Mathematical Methods of Systems Analysis',2000),(2200,'Department of System Design	',2000),(3100,'Department of theoretical foundations of radio engineering',3000),(3200,'Department of radio reception and signal processing',3000),(3300,'Department of radio engineering devices and systems',3000);
/*!40000 ALTER TABLE `Cafedra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Faculty`
--

DROP TABLE IF EXISTS `Faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Faculty` (
  `idFaculty` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`idFaculty`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Faculty`
--

LOCK TABLES `Faculty` WRITE;
/*!40000 ALTER TABLE `Faculty` DISABLE KEYS */;
INSERT INTO `Faculty` VALUES (1000,'FICT'),(3000,'FRE'),(2000,'IASA'),(1,'ФИВТ');
/*!40000 ALTER TABLE `Faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GroupT`
--

DROP TABLE IF EXISTS `GroupT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GroupT` (
  `idGroup` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `idSpeciality_fk` int(11) NOT NULL,
  PRIMARY KEY (`idGroup`),
  UNIQUE KEY `Name_UNIQUE` (`Name`),
  KEY `fk_GroupT_Speciality_fk_idx` (`idSpeciality_fk`),
  CONSTRAINT `fk_GroupT_Speciality_fk` FOREIGN KEY (`idSpeciality_fk`) REFERENCES `Speciality` (`idSpeciality`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GroupT`
--

LOCK TABLES `GroupT` WRITE;
/*!40000 ALTER TABLE `GroupT` DISABLE KEYS */;
INSERT INTO `GroupT` VALUES (1111,'CS-11',1110),(1121,'AS-21',1120),(1211,'FB-31',1210),(1311,'AC-32',1310),(1312,'AC-42',1310),(1411,'IM-51',1410),(2111,'SA-22',2110),(2121,'IT-54',2120),(2211,'TD-23',2210),(2221,'SD-12',2220),(3111,'SE-45',3110),(3211,'SP-14',3210),(3311,'RI-73',3310),(3321,'TR-53',3320);
/*!40000 ALTER TABLE `GroupT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Loging`
--

DROP TABLE IF EXISTS `Loging`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Loging` (
  `idLoging` int(11) NOT NULL,
  `User` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`idLoging`),
  UNIQUE KEY `User_UNIQUE` (`User`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Loging`
--

LOCK TABLES `Loging` WRITE;
/*!40000 ALTER TABLE `Loging` DISABLE KEYS */;
INSERT INTO `Loging` VALUES (1,'admin','admin'),(2,'neAdmin','neAdmin');
/*!40000 ALTER TABLE `Loging` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProgressStudent`
--

DROP TABLE IF EXISTS `ProgressStudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProgressStudent` (
  `idProgressStudent` int(11) NOT NULL,
  `Marks` int(11) NOT NULL,
  `Works` int(11) NOT NULL,
  `Lections` int(11) NOT NULL,
  `idSubject_fk` int(11) NOT NULL,
  PRIMARY KEY (`idProgressStudent`),
  KEY `fk_ProgressStudent_Subject_fk_idx` (`idSubject_fk`),
  CONSTRAINT `fk_ProgressStudent_Subject_id` FOREIGN KEY (`idSubject_fk`) REFERENCES `Subject` (`idSubject`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProgressStudent`
--

LOCK TABLES `ProgressStudent` WRITE;
/*!40000 ALTER TABLE `ProgressStudent` DISABLE KEYS */;
INSERT INTO `ProgressStudent` VALUES (1,1,1,1,100011),(2,2,2,2,100024);
/*!40000 ALTER TABLE `ProgressStudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RequirementsSubject`
--

DROP TABLE IF EXISTS `RequirementsSubject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RequirementsSubject` (
  `idRequirementsSubject` int(11) NOT NULL,
  `Marks` int(11) NOT NULL,
  `Works` int(11) NOT NULL,
  `Lections` int(11) NOT NULL,
  PRIMARY KEY (`idRequirementsSubject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RequirementsSubject`
--

LOCK TABLES `RequirementsSubject` WRITE;
/*!40000 ALTER TABLE `RequirementsSubject` DISABLE KEYS */;
INSERT INTO `RequirementsSubject` VALUES (1,1,1,1);
/*!40000 ALTER TABLE `RequirementsSubject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Speciality`
--

DROP TABLE IF EXISTS `Speciality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Speciality` (
  `idSpeciality` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `idCafedra_fk` int(11) NOT NULL,
  PRIMARY KEY (`idSpeciality`),
  UNIQUE KEY `Name_UNIQUE` (`Name`),
  KEY `fk_Speciality_Cafedra_fk_idx` (`idCafedra_fk`),
  CONSTRAINT `fk_Speciality_Cafedra_fk` FOREIGN KEY (`idCafedra_fk`) REFERENCES `Cafedra` (`idCafedra`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Speciality`
--

LOCK TABLES `Speciality` WRITE;
/*!40000 ALTER TABLE `Speciality` DISABLE KEYS */;
INSERT INTO `Speciality` VALUES (1110,'Computer systems and networks',1100),(1120,'Software of automatic systems',1100),(1210,'Flexible computerized systems and robotics',1200),(1310,'Computerized systems, automation and control',1300),(1410,'Information Management Systems and Technologies',1400),(2110,'System Analysis',2100),(2120,'Computer Science and Information Technology',2100),(2210,'Information systems and technology design',2200),(2220,'System design services',2200),(3110,'Radio Systems Engineering',3100),(3210,'Radio communication and signal processing',3200),(3310,'Radio Information Technology',3300),(3320,'Telecommunications and radio',3300);
/*!40000 ALTER TABLE `Speciality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `idStudent` int(11) NOT NULL,
  `Surname` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Patronymic` varchar(45) DEFAULT NULL,
  `idProgressStudent_fk` int(11) DEFAULT NULL,
  `idAttestation_fk` int(11) DEFAULT NULL,
  `idGroup_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`idStudent`),
  KEY `fk_Student_Group_fk_idx` (`idGroup_fk`),
  KEY `fk_Student_Progress_id_idx` (`idProgressStudent_fk`),
  KEY `fk_Student_Attestation_id_idx` (`idAttestation_fk`),
  CONSTRAINT `fk_Student_Attestation_id` FOREIGN KEY (`idAttestation_fk`) REFERENCES `Attestation` (`idAttestation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Group` FOREIGN KEY (`idGroup_fk`) REFERENCES `GroupT` (`idGroup`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Progress_id` FOREIGN KEY (`idProgressStudent_fk`) REFERENCES `ProgressStudent` (`idProgressStudent`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES (1,'Вагнер','Артур','Александрович',1,1,1111),(2,'Писаренко ','Степан','',2,1,1121);
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subject`
--

DROP TABLE IF EXISTS `Subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Subject` (
  `idSubject` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `idTeacher_fk` int(11) NOT NULL,
  `idRequirementsSubject_fk` int(11) NOT NULL,
  PRIMARY KEY (`idSubject`),
  KEY `fk_Subject_Teacher_fk_idx` (`idTeacher_fk`),
  KEY `fk_Subject_Requirements_idx` (`idRequirementsSubject_fk`),
  CONSTRAINT `fk_Subject_Requirements` FOREIGN KEY (`idRequirementsSubject_fk`) REFERENCES `RequirementsSubject` (`idRequirementsSubject`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Subject_Teacher_fk` FOREIGN KEY (`idTeacher_fk`) REFERENCES `Teacher` (`idTeacher`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subject`
--

LOCK TABLES `Subject` WRITE;
/*!40000 ALTER TABLE `Subject` DISABLE KEYS */;
INSERT INTO `Subject` VALUES (100011,'English',1,1),(100024,'CAD/CAM',4,1),(100035,'Information security',5,1),(100058,'C++',8,1),(200012,'English',2,1),(200057,'C++',7,1),(300013,'English',3,1),(300046,'Physics',6,1);
/*!40000 ALTER TABLE `Subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teacher`
--

DROP TABLE IF EXISTS `Teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Teacher` (
  `idTeacher` int(11) NOT NULL,
  `Surname` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Patronymic` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTeacher`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teacher`
--

LOCK TABLES `Teacher` WRITE;
/*!40000 ALTER TABLE `Teacher` DISABLE KEYS */;
INSERT INTO `Teacher` VALUES (1,'Ivanova','L',NULL),(2,'Stepanove','O',NULL),(3,'Talakov','V',NULL),(4,'Sidorov','M',NULL),(5,'Validov','R',NULL),(6,'Varlam','T',NULL),(7,'Gerund','U',NULL),(8,'Kaban','E',NULL);
/*!40000 ALTER TABLE `Teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'CourseWorkSchema'
--

--
-- Dumping routines for database 'CourseWorkSchema'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-10 13:50:16
