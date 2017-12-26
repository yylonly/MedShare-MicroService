-- dump data in site: http://filldb.info/dummy/step1


DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `PID` mediumint(9) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Surname` varchar(255) DEFAULT NULL,
  `Gender` char(1) DEFAULT NULL,
  `DoB` date DEFAULT NULL,
  `Country` varchar(100) DEFAULT NULL,
  `StreetAddress` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `Postal` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`PID`)
) ENGINE=InnoDB AUTO_INCREMENT=12000 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--


-- modified by Neil, 12/24/2017
-- add tables: doctor, prescription, medication

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `DID` mediumint(9) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Surname` varchar(255) DEFAULT NULL,
  `Gender` char(1) DEFAULT NULL,
  `DoB` date DEFAULT NULL,
  `Country` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`DID`)
) ENGINE=InnoDB AUTO_INCREMENT=12000 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescription` (
  `PID` mediumint(9) NOT NULL AUTO_INCREMENT,
  `Patient_ID` mediumint(9) DEFAULT NULL,
  `Doctor_ID` mediumint(9) DEFAULT NULL,  
  `Pres_Date` date DEFAULT NULL,
  PRIMARY KEY (`PID`),
  KEY `Patient_ID` (`Patient_ID`),
  CONSTRAINT `prescription_ibfk_1` FOREIGN KEY (`Patient_ID`) REFERENCES `patient` (`PID`),
  CONSTRAINT `prescription_ibfk_2` FOREIGN KEY (`Doctor_ID`) REFERENCES `doctor` (`DID`)
) ENGINE=InnoDB AUTO_INCREMENT=12000 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--


--
-- Table structure for table `medication`
--

DROP TABLE IF EXISTS `medication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medication` (
  `MID` mediumint(9) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,  
  PRIMARY KEY (`MID`)
) ENGINE=InnoDB AUTO_INCREMENT=12000 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medication`
--



--
-- Table structure for table `prescriptmed`
--

DROP TABLE IF EXISTS `prescriptmed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescriptmed` (
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `PRESCRIPTID` mediumint(9) NOT NULL,
  `MEDID` mediumint(9) NOT NULL,
  PRIMARY KEY (`PRESCRIPTID`,`MEDID`),
  KEY `PRESCRIPTMED_ID` (`PRESCRIPTID`,`MEDID`),
  CONSTRAINT `FK_PRESCRIPTMED_PRESCRIPTID` FOREIGN KEY (`PRESCRIPTID`) REFERENCES `prescription` (`PID`),
  CONSTRAINT `FK_PRESCRIPTMED_MEDID` FOREIGN KEY (`MEDID`) REFERENCES `medication` (`MID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;