-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server Version:               10.1.32-MariaDB - mariadb.org binary distribution
-- Server Betriebssystem:        Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Exportiere Datenbank Struktur für mydb
CREATE DATABASE IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mydb`;

-- Exportiere Struktur von Tabelle mydb.message
CREATE TABLE IF NOT EXISTS `message` (
  `idMessage` int(11) NOT NULL AUTO_INCREMENT,
  `Message` varchar(200) DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT NULL,
  `User_idUser_From` int(11) NOT NULL,
  `User_idUser_To` int(11) NOT NULL,
  PRIMARY KEY (`idMessage`,`User_idUser_From`,`User_idUser_To`),
  KEY `fk_Message_User_idx` (`User_idUser_From`),
  KEY `fk_Message_User1_idx` (`User_idUser_To`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle mydb.message: ~43 rows (ungefähr)
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;

-- Exportiere Struktur von Tabelle mydb.user
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(200) DEFAULT NULL,
  `Salt` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle mydb.user: ~7 rows (ungefähr)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`idUser`, `Username`, `Password`, `Salt`) VALUES
	(4, 'Kevin', 'a97740a5b2fdc64d514c21868bac87a459d0d38810e2110a5d42e3d50daec062', '19P53C3B'),
	(5, 'Philip', '4ad198951b485a168fdfe276ea867c85f02fb98dc5cfd97d56c84987d72c81da', 'NFEZISMH'),
	(6, 'Alina', 'a70296ad50929727b5bbcf84e263f877b60294c6c1408144be83e106f06979fa', 'BRIZCZ27'),
	(7, 'Michi', '02b5c0fbdf98af489ec12d7c53a1f618cb89bebe36b309e71ff65ca6b19c6e98', 'K3RCZXT0'),
	(12, 'Freddy', '1a2d70da672b30c6234517a946bb56266caa450751677244917f05235f7148f6', 'A8EOARCJ');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
