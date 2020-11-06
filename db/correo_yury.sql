-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 06, 2020 at 07:48 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `correo_yury`
--

-- --------------------------------------------------------

--
-- Table structure for table `carga`
--

CREATE TABLE `carga` (
  `rutApoderado` varchar(20) COLLATE utf8_bin NOT NULL,
  `nombre` varchar(20) COLLATE utf8_bin NOT NULL,
  `apellidoPaterno` varchar(20) COLLATE utf8_bin NOT NULL,
  `apellidoMaterno` varchar(20) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `carga`
--

INSERT INTO `carga` (`rutApoderado`, `nombre`, `apellidoPaterno`, `apellidoMaterno`) VALUES
('2222222-2', 'Felipe', 'Ramirez', 'Romero'),
('2222222-2', 'Marian', 'Ramirez', 'Romero'),
('2222222-2', 'Sebastian', 'Ramirez', 'Romero'),
('33333333-3', 'Mariana', 'Jimenez', 'Romero'),
('33333333-3', 'Mariano', 'Jimenez', 'Romero');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `rut` varchar(15) COLLATE utf8_general_mysql500_ci NOT NULL,
  `nombre` varchar(20) COLLATE utf8_general_mysql500_ci NOT NULL,
  `apellidoPaterno` varchar(20) COLLATE utf8_general_mysql500_ci NOT NULL,
  `apellidoMaterno` varchar(20) COLLATE utf8_general_mysql500_ci NOT NULL,
  `tipoUsuario` int(11) NOT NULL,
  `cargo` varchar(20) COLLATE utf8_general_mysql500_ci NOT NULL,
  `username` varchar(15) COLLATE utf8_general_mysql500_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_general_mysql500_ci NOT NULL,
  `estado` int(11) NOT NULL,
  `numeroCargas` int(11) NOT NULL,
  `contactoEmergencia` varchar(20) COLLATE utf8_general_mysql500_ci NOT NULL,
  `ultimoTrabajo` varchar(20) COLLATE utf8_general_mysql500_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`rut`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `tipoUsuario`, `cargo`, `username`, `password`, `estado`, `numeroCargas`, `contactoEmergencia`, `ultimoTrabajo`) VALUES
('1111111-1', 'Rebecca', 'Vasquez', 'Nunez', 1, 'Recursos Humanos', 'rvasquez0', '123456', 0, 0, '99999199', 'Administrador'),
('2222222-2', 'Valentina', 'Romero', 'Ramirez', 1, 'Recursos Humanos', 'vromero0', '123456', 0, 3, '999999991', 'Astronauta'),
('33333333-3', 'Carlos', 'Marambio', 'Perez', 2, 'Cargo tipo 1', 'cmarambio0', '123456', 0, 2, '99999999', 'Fisico Culturista');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
