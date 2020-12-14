-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 14, 2020 at 04:54 PM
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
  `id_carga` int(11) NOT NULL,
  `rutEmpleado` varchar(20) COLLATE utf8_bin NOT NULL,
  `nombre` varchar(20) COLLATE utf8_bin NOT NULL,
  `apellidoPaterno` varchar(20) COLLATE utf8_bin NOT NULL,
  `apellidoMaterno` varchar(20) COLLATE utf8_bin NOT NULL,
  `parentesco` varchar(15) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `carga`
--

INSERT INTO `carga` (`id_carga`, `rutEmpleado`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `parentesco`) VALUES
(1, '2222222-2', 'Felipe', 'Marambio', 'Rodriguez', 'hijo'),
(2, '2222222-2', 'Marian', 'Marambio', 'Rodriguez', 'hija'),
(3, '2222222-2', 'Sebastian', 'Marambio', 'Rodriguez', 'hijo'),
(4, '33333333-3', 'Alberto', 'Rosales', 'Ramirez', 'hijo'),
(5, '33333333-3', 'Felipe', 'Rosales', 'Romero', 'hijo'),
(6, '33333333-3', 'Mariana', 'Rodriguez', 'Ramirez', 'hija');

-- --------------------------------------------------------

--
-- Table structure for table `contacto`
--

CREATE TABLE `contacto` (
  `id_contacto` int(11) NOT NULL,
  `rutEmpleado` varchar(20) COLLATE utf8_bin NOT NULL,
  `numeroTelefonico` varchar(20) COLLATE utf8_bin NOT NULL,
  `nombre` varchar(20) COLLATE utf8_bin NOT NULL,
  `apellidoPaterno` varchar(20) COLLATE utf8_bin NOT NULL,
  `apellidoMaterno` varchar(20) COLLATE utf8_bin NOT NULL,
  `relacion` varchar(15) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `contacto`
--

INSERT INTO `contacto` (`id_contacto`, `rutEmpleado`, `numeroTelefonico`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `relacion`) VALUES
(1, '2222222-2', '905151519', 'Marian', 'Rodriguez', 'Romero', 'esposa'),
(2, '2222222-2', '912121213', 'Franchesca', 'Vasquez', 'Ramirez', 'amiga'),
(3, '33333333-3', '907151512', 'Mariana', 'Ramirez', 'Ron', 'esposa'),
(4, '33333333-3', '912121212', 'Mariano', 'Ramirez', 'Ron', 'cuñado');

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

CREATE TABLE `persona` (
  `rut` varchar(20) COLLATE utf8_bin NOT NULL,
  `nombre` varchar(20) COLLATE utf8_bin NOT NULL,
  `apellidoPaterno` varchar(20) COLLATE utf8_bin NOT NULL,
  `apellidoMaterno` varchar(20) COLLATE utf8_bin NOT NULL,
  `cargo` varchar(20) COLLATE utf8_bin NOT NULL,
  `sexo` varchar(10) COLLATE utf8_bin NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`rut`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `cargo`, `sexo`, `estado`) VALUES
('1111111-1', 'Rebecca', 'Vasquez', 'Nunez', 'Recursos Humanos', 'Femenino', 0),
('1111121-1', 'El', 'Imi', 'Nado', 'Cargo tipo 2', '', 3),
('2222222-2', 'Carlos', 'Marambio', 'Perez', 'Cargo Tipo 1', 'Masculino', 0),
('33333333-3', 'Carlos', 'Rosales', 'Dominguez', 'Cargo tipo 2', 'Masculino', 0);

-- --------------------------------------------------------

--
-- Table structure for table `trabajo`
--

CREATE TABLE `trabajo` (
  `id_trabajo` int(11) NOT NULL,
  `rutEmpleado` varchar(20) COLLATE utf8_bin NOT NULL,
  `cargo` varchar(20) COLLATE utf8_bin NOT NULL,
  `empresa` varchar(20) COLLATE utf8_bin NOT NULL,
  `fechaInicio` varchar(20) COLLATE utf8_bin NOT NULL,
  `fechaFin` varchar(20) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `trabajo`
--

INSERT INTO `trabajo` (`id_trabajo`, `rutEmpleado`, `cargo`, `empresa`, `fechaInicio`, `fechaFin`) VALUES
(1, '33333333-3', 'Fisico Culturista', 'Pacific Gym', '2020-09-01', '2020-10-01'),
(2, '33333333-3', 'Astronauta', 'NASA', '2020-10-02', '2020-11-02'),
(3, '33333333-3', 'Profesor', 'INACAP', '2020-11-03', '2020-12-08');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `username` varchar(20) COLLATE utf8_bin NOT NULL,
  `rutEmpleado` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `tipoUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`username`, `rutEmpleado`, `password`, `tipoUsuario`) VALUES
('cmarambio0', '2222222-2', '123456', 2),
('crosales0', '33333333-3', '123456', 2),
('rvasquez0', '1111111-1', '123456', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carga`
--
ALTER TABLE `carga`
  ADD PRIMARY KEY (`id_carga`),
  ADD KEY `rutEmpleado` (`rutEmpleado`);

--
-- Indexes for table `contacto`
--
ALTER TABLE `contacto`
  ADD PRIMARY KEY (`id_contacto`),
  ADD KEY `rutEmpleado` (`rutEmpleado`);

--
-- Indexes for table `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`rut`);

--
-- Indexes for table `trabajo`
--
ALTER TABLE `trabajo`
  ADD PRIMARY KEY (`id_trabajo`),
  ADD KEY `rutEmpleado` (`rutEmpleado`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`username`),
  ADD KEY `rutEmpleado` (`rutEmpleado`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carga`
--
ALTER TABLE `carga`
  MODIFY `id_carga` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `contacto`
--
ALTER TABLE `contacto`
  MODIFY `id_contacto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `trabajo`
--
ALTER TABLE `trabajo`
  MODIFY `id_trabajo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `carga`
--
ALTER TABLE `carga`
  ADD CONSTRAINT `carga_ibfk_1` FOREIGN KEY (`rutEmpleado`) REFERENCES `persona` (`rut`);

--
-- Constraints for table `contacto`
--
ALTER TABLE `contacto`
  ADD CONSTRAINT `contacto_ibfk_1` FOREIGN KEY (`rutEmpleado`) REFERENCES `persona` (`rut`);

--
-- Constraints for table `trabajo`
--
ALTER TABLE `trabajo`
  ADD CONSTRAINT `trabajo_ibfk_1` FOREIGN KEY (`rutEmpleado`) REFERENCES `persona` (`rut`);

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`rutEmpleado`) REFERENCES `persona` (`rut`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
