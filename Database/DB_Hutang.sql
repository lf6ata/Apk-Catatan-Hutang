-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.18-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db_hutang
CREATE DATABASE IF NOT EXISTS `db_hutang` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_hutang`;

-- Dumping structure for table db_hutang.tb_hutang
CREATE TABLE IF NOT EXISTS `tb_hutang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nm_penghutang` varchar(200) DEFAULT '0',
  `catatan` varchar(2000) DEFAULT '0',
  `jumlah` varchar(200) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_hutang.tb_hutang: ~0 rows (approximately)
/*!40000 ALTER TABLE `tb_hutang` DISABLE KEYS */;
INSERT INTO `tb_hutang` (`id`, `nm_penghutang`, `catatan`, `jumlah`) VALUES
	(2, 'Andre', 'Beli Seblak 5', '50000'),
	(3, 'Andi', 'Bayar Parkir', '6000'),
	(4, 'Jejej', 'Jajan Eskrim', '80000'),
	(5, 'Yundri', 'Beli Sempak', '30000');
/*!40000 ALTER TABLE `tb_hutang` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
