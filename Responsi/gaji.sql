-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2020 at 09:35 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.2.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gaji`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_gaji`
--

CREATE TABLE `data_gaji` (
  `id` int(15) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `posisi` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no` varchar(20) NOT NULL,
  `gaji` varchar(15) NOT NULL,
  `jam` varchar(15) NOT NULL,
  `tunjangan` varchar(20) NOT NULL,
  `pajak` varchar(20) NOT NULL,
  `total` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_gaji`
--

INSERT INTO `data_gaji` (`id`, `nama`, `posisi`, `alamat`, `no`, `gaji`, `jam`, `tunjangan`, `pajak`, `total`) VALUES
(1233, 'retno', 'Programmer', 'prembun', '09887', '11000', '', '11222', '1333', ''),
(1213131, 'Desi', 'Sekretaris', 'prembun', '098877', '12000000', '', '1000000', '100000', ''),
(1213131, 'Desi', 'Sekretaris', 'prembun', '098877', '12000000', '', '1000000', '100000', ''),
(1213131, 'Desi', 'Staff', 'prembun', '098877', '12000000', '', '1000000', '100000', ''),
(12900101, 'desii', 'Programmer', 'prembun', '12131331', '1122223', '', '121212', '11212', ''),
(12000012, 'Desi ', 'Administrasi', 'Prembun', '087752552', '12000000', '', '120000', '100000', '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
