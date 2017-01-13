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
  `idStudent_fk` int(11) DEFAULT NULL,
  `idSubject_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAttestation`),
  KEY `fk_Attestation_Student_idx` (`idStudent_fk`),
  KEY `fk_Attestation_Subject_idx` (`idSubject_fk`),
  CONSTRAINT `fk_Attestation_Student` FOREIGN KEY (`idStudent_fk`) REFERENCES `Student` (`idStudent`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attestation_Subject` FOREIGN KEY (`idSubject_fk`) REFERENCES `Subject` (`idSubject`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Attestation`
--

LOCK TABLES `Attestation` WRITE;
/*!40000 ALTER TABLE `Attestation` DISABLE KEYS */;
INSERT INTO `Attestation` VALUES (1,NULL,1,100011),(2,NULL,1,100024),(3,NULL,1,100035),(4,NULL,1,100058),(5,NULL,2,100011),(6,NULL,2,100024),(7,NULL,2,100035),(8,NULL,2,100058),(9,NULL,3,100011),(10,NULL,3,100024),(11,NULL,3,100035),(12,NULL,3,100058),(13,NULL,4,100011),(14,NULL,4,100024),(15,NULL,4,100035),(16,NULL,4,100058),(17,NULL,5,100011),(18,NULL,5,100024),(19,NULL,5,100035),(20,NULL,5,100058);
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
INSERT INTO `Faculty` VALUES (1000,'FICT'),(3000,'FRE'),(2000,'IASA');
/*!40000 ALTER TABLE `Faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GroupSubject`
--

DROP TABLE IF EXISTS `GroupSubject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GroupSubject` (
  `idGroupSubject` int(11) NOT NULL,
  `idSubject` int(11) NOT NULL,
  `idGroup` int(11) NOT NULL,
  PRIMARY KEY (`idGroupSubject`),
  KEY `fk_GroupSubject_Group_idx` (`idGroup`),
  KEY `fk_GroupSubject_Subject_idx` (`idSubject`),
  CONSTRAINT `fk_GroupSubject_Group` FOREIGN KEY (`idGroup`) REFERENCES `GroupT` (`idGroup`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_GroupSubject_Subject` FOREIGN KEY (`idSubject`) REFERENCES `Subject` (`idSubject`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GroupSubject`
--

LOCK TABLES `GroupSubject` WRITE;
/*!40000 ALTER TABLE `GroupSubject` DISABLE KEYS */;
INSERT INTO `GroupSubject` VALUES (1,100011,1111),(2,100011,1121),(3,100011,1211),(4,100011,1311),(5,100011,1312),(6,100011,1411),(7,100024,1111),(8,100024,1121),(9,100024,1211),(10,100024,1311),(11,100024,1312),(12,100024,1411),(13,100035,1121),(14,100035,1311),(15,100035,1312),(16,100035,1411),(17,100058,1411),(18,200012,2111),(19,200012,2121),(20,200012,2211),(21,200012,2221),(22,200057,2211),(23,200057,2221),(24,300013,3111),(25,300013,3211),(26,300013,3311),(27,300013,3321),(28,300046,3311),(29,300046,3321);
/*!40000 ALTER TABLE `GroupSubject` ENABLE KEYS */;
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
INSERT INTO `ProgressStudent` VALUES (1,1,1,1,100011),(2,2,2,2,100024),(3,20,20,20,100024),(4,21,16,35,100035),(5,22,21,20,100011);
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
INSERT INTO `RequirementsSubject` VALUES (1,1,1,1),(2,20,15,5),(3,12,4,8),(4,15,15,4);
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
  `Surname` varchar(45) DEFAULT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Patronymic` varchar(45) DEFAULT NULL,
  `idProgressStudent_fk` int(11) DEFAULT NULL,
  `idGroup_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`idStudent`),
  KEY `fk_Student_Group_idx` (`idGroup_fk`),
  KEY `fk_Student_Progress_idx` (`idProgressStudent_fk`),
  CONSTRAINT `fk_Student_Group` FOREIGN KEY (`idGroup_fk`) REFERENCES `GroupT` (`idGroup`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Progress` FOREIGN KEY (`idProgressStudent_fk`) REFERENCES `ProgressStudent` (`idProgressStudent`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES (1,'Smovjenko','Alixei','Leonidovich',1,1111),(2,'Wagner','Arthur','Alexandrovich',2,1111),(3,'Kalitovskiy','Bohdan','Vitaliyovuch',3,1121),(4,'Kovalenko','Stanislav','Igorovuch',4,1121),(5,'Krasnuk','Igor','Stanislavovich',5,1312);
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
INSERT INTO `Subject` VALUES (100011,'English',1,1),(100024,'CAD/CAM',4,2),(100035,'Information security',5,3),(100058,'C++',8,4),(200012,'English',2,2),(200057,'C++',7,3),(300013,'English',3,4),(300046,'Physics',6,1);
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
INSERT INTO `Teacher` VALUES (1,'Ivanova','Lina','Semenovna'),(2,'Stepanova','Olga','Alexeevna'),(3,'Talakov','Viktor','Igorevich'),(4,'Sidorov','Mihail','Artutovich'),(5,'Validov','Ruslan','Andreevich'),(6,'Varlam','Tandur','Mamedovich'),(7,'Gerund','Uriy','Antonovich'),(8,'Kaban','Elena','Sergeevna');
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

-- Dump completed on 2017-01-13 17:59:53
