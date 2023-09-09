-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: db_matriculas
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
-- Table structure for table `tb_alumno`
--

DROP TABLE IF EXISTS `tb_alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_alumno` (
  `dni_alumno` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `edad` int DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `telefono` char(9) NOT NULL,
  `correo` varchar(50) NOT NULL,
  PRIMARY KEY (`dni_alumno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_alumno`
--

LOCK TABLES `tb_alumno` WRITE;
/*!40000 ALTER TABLE `tb_alumno` DISABLE KEYS */;
INSERT INTO `tb_alumno` VALUES (193405,'Juan','Perez Flores',19,'hombre','925364238','pjuan@gmail.com'),(72365428,'Cristiano','Ronaldo dos santos Aveiro',38,'hombre','936523547','ercristiano@gmail.com'),(82365498,'Carlos','Torres Huerta',22,'hombre','923546879','tcarlos@gmail.com');
/*!40000 ALTER TABLE `tb_alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_asignaturas`
--

DROP TABLE IF EXISTS `tb_asignaturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_asignaturas` (
  `cod_asignatura` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `cod_carrera` int DEFAULT NULL,
  `cod_ciclo` int DEFAULT NULL,
  `dni_docente` int DEFAULT NULL,
  PRIMARY KEY (`cod_asignatura`),
  KEY `cod_carrera` (`cod_carrera`),
  KEY `cod_ciclo` (`cod_ciclo`),
  KEY `fk_dni_doc` (`dni_docente`),
  CONSTRAINT `tb_asignaturas_ibfk_1` FOREIGN KEY (`dni_docente`) REFERENCES `tb_docente` (`dni_docente`),
  CONSTRAINT `tb_asignaturas_ibfk_2` FOREIGN KEY (`cod_carrera`) REFERENCES `tb_carrera` (`cod_carrera`),
  CONSTRAINT `tb_asignaturas_ibfk_3` FOREIGN KEY (`cod_ciclo`) REFERENCES `tb_ciclos` (`cod_ciclo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_asignaturas`
--

LOCK TABLES `tb_asignaturas` WRITE;
/*!40000 ALTER TABLE `tb_asignaturas` DISABLE KEYS */;
INSERT INTO `tb_asignaturas` VALUES (4001,'Introduccion a la Algoritmia',1001,2001,96354236),(4002,'Arquitectura de Entornos Web',1001,2001,98765432),(4003,'Lenguaje de programacion II',1001,2004,98765432);
/*!40000 ALTER TABLE `tb_asignaturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_carrera`
--

DROP TABLE IF EXISTS `tb_carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_carrera` (
  `cod_carrera` int NOT NULL,
  `nom_carrera` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cod_carrera`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_carrera`
--

LOCK TABLES `tb_carrera` WRITE;
/*!40000 ALTER TABLE `tb_carrera` DISABLE KEYS */;
INSERT INTO `tb_carrera` VALUES (1001,'Comupacion e informatica');
/*!40000 ALTER TABLE `tb_carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ciclos`
--

DROP TABLE IF EXISTS `tb_ciclos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_ciclos` (
  `cod_ciclo` int NOT NULL,
  `nmro_ciclo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cod_ciclo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ciclos`
--

LOCK TABLES `tb_ciclos` WRITE;
/*!40000 ALTER TABLE `tb_ciclos` DISABLE KEYS */;
INSERT INTO `tb_ciclos` VALUES (2001,'PRIMER CICLO'),(2002,'SEGUNDO CICLO'),(2003,'TERCER CICLO'),(2004,'CUARTO CICLO');
/*!40000 ALTER TABLE `tb_ciclos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_docente`
--

DROP TABLE IF EXISTS `tb_docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_docente` (
  `dni_docente` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `telefono` char(9) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dni_docente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_docente`
--

LOCK TABLES `tb_docente` WRITE;
/*!40000 ALTER TABLE `tb_docente` DISABLE KEYS */;
INSERT INTO `tb_docente` VALUES (96354236,'Alex tito ','Belleza Porras',50,'hombre','936523648','pbelleza@gmail.com'),(98765432,'Maria','Lopez',38,'mujer','987654321','maria.lopez@example.com');
/*!40000 ALTER TABLE `tb_docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_genero`
--

DROP TABLE IF EXISTS `tb_genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_genero` (
  `nom_genero` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_genero`
--

LOCK TABLES `tb_genero` WRITE;
/*!40000 ALTER TABLE `tb_genero` DISABLE KEYS */;
INSERT INTO `tb_genero` VALUES ('hombre'),('mujer');
/*!40000 ALTER TABLE `tb_genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_matricula`
--

DROP TABLE IF EXISTS `tb_matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_matricula` (
  `cod_matricula` int NOT NULL AUTO_INCREMENT,
  `dni_alumno` int DEFAULT NULL,
  `cod_carrera` int DEFAULT NULL,
  `cod_asignatura` int DEFAULT NULL,
  `cod_ciclo` int DEFAULT NULL,
  `cod_periodo` int DEFAULT NULL,
  PRIMARY KEY (`cod_matricula`),
  KEY `dni_alumno` (`dni_alumno`),
  KEY `cod_carrera` (`cod_carrera`),
  KEY `cod_asignatura` (`cod_asignatura`),
  KEY `cod_ciclo` (`cod_ciclo`),
  KEY `cod_periodo` (`cod_periodo`),
  CONSTRAINT `tb_matricula_ibfk_1` FOREIGN KEY (`dni_alumno`) REFERENCES `tb_alumno` (`dni_alumno`),
  CONSTRAINT `tb_matricula_ibfk_2` FOREIGN KEY (`cod_carrera`) REFERENCES `tb_carrera` (`cod_carrera`),
  CONSTRAINT `tb_matricula_ibfk_3` FOREIGN KEY (`cod_asignatura`) REFERENCES `tb_asignaturas` (`cod_asignatura`),
  CONSTRAINT `tb_matricula_ibfk_4` FOREIGN KEY (`cod_ciclo`) REFERENCES `tb_ciclos` (`cod_ciclo`),
  CONSTRAINT `tb_matricula_ibfk_5` FOREIGN KEY (`cod_periodo`) REFERENCES `tb_periodos` (`cod_periodo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_matricula`
--

LOCK TABLES `tb_matricula` WRITE;
/*!40000 ALTER TABLE `tb_matricula` DISABLE KEYS */;
INSERT INTO `tb_matricula` VALUES (1,193405,1001,4001,2001,3001),(2,193405,1001,4002,2001,3001),(3,82365498,1001,4001,2001,3001),(4,82365498,1001,4002,2001,3001),(5,72365428,1001,4003,2004,3001);
/*!40000 ALTER TABLE `tb_matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_periodos`
--

DROP TABLE IF EXISTS `tb_periodos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_periodos` (
  `cod_periodo` int NOT NULL,
  `fec_inicio` date DEFAULT NULL,
  `fec_fin` date DEFAULT NULL,
  PRIMARY KEY (`cod_periodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_periodos`
--

LOCK TABLES `tb_periodos` WRITE;
/*!40000 ALTER TABLE `tb_periodos` DISABLE KEYS */;
INSERT INTO `tb_periodos` VALUES (3001,'2023-03-21','2023-07-07');
/*!40000 ALTER TABLE `tb_periodos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `cod_usu` int NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `contraseña` varchar(15) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`cod_usu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'gian','manchinari','gian123','gian','hombre','gian@gmail.com','923654238');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-17 23:50:14
