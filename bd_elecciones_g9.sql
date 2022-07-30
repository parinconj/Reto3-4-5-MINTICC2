-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 27, 2022 at 05:00 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd_elecciones_g9`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_candidatos`
--

CREATE TABLE `tbl_candidatos` (
  `id_candidato` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `partido_politico` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `mensaje_campania` varchar(300) NOT NULL,
  `propuestas` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_candidatos`
--

INSERT INTO `tbl_candidatos` (`id_candidato`, `nombre`, `telefono`, `correo`, `partido_politico`, `descripcion`, `mensaje_campania`, `propuestas`) VALUES
('100', 'Gustavo', '315', 'gustavito', 'Pacto histórico', 'tomelo', '', ''),
('21', 'petro', 'ds', 'vx', 'Democrata', 'vvc', '', ''),
('213', 'wq', 'wqw', 'wqw', 'Democrata', 'cxc', '', ''),
('312', 'wewe', '434', '[value-4]jhj', 'Democrata', '[value-6]', '', ''),
('3134', 'mxkx', '4848', 'ldldl', 'Democrata', 'jdjdjd', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_elecciones`
--

CREATE TABLE `tbl_elecciones` (
  `id_elecciones` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp(),
  `estado` tinyint(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_elecciones`
--

INSERT INTO `tbl_elecciones` (`id_elecciones`, `nombre`, `fecha`, `estado`) VALUES
(1, 'Senado', '2022-07-21 23:02:58', 1),
(2, 'Senado', '2022-07-21 23:02:58', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_votantes`
--

CREATE TABLE `tbl_votantes` (
  `id_votantes` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `puesto_votacion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_votantes`
--

INSERT INTO `tbl_votantes` (`id_votantes`, `nombre`, `telefono`, `correo`, `puesto_votacion`) VALUES
('1085', 'Andres', '318', 'andy', '40'),
('1111', 'sds', '343423', 'wds', '3'),
('2446', 'jfhfhg', '3454654', '44646', '3'),
('432432432', 'andres', '2343214', 'kdsnfkj', '12'),
('43904', 'kdsk', '4I4I', 'dmdm', '4'),
('8328328', 'julio', 'jejwj', 'ejewj', 'ewjwje');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_votos`
--

CREATE TABLE `tbl_votos` (
  `id_candidato` varchar(50) NOT NULL,
  `id_votantes` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_votos`
--

INSERT INTO `tbl_votos` (`id_candidato`, `id_votantes`) VALUES
('100', '1111'),
('21', '1085'),
('21', '1111'),
('21', '1111'),
('100', '1111'),
('100', '1085'),
('100', '1085'),
('100', '1085'),
('21', '1085'),
('213', '1111');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_candidatos`
--
ALTER TABLE `tbl_candidatos`
  ADD PRIMARY KEY (`id_candidato`);

--
-- Indexes for table `tbl_elecciones`
--
ALTER TABLE `tbl_elecciones`
  ADD PRIMARY KEY (`id_elecciones`);

--
-- Indexes for table `tbl_votantes`
--
ALTER TABLE `tbl_votantes`
  ADD PRIMARY KEY (`id_votantes`);

--
-- Indexes for table `tbl_votos`
--
ALTER TABLE `tbl_votos`
  ADD KEY `id_candidato` (`id_candidato`),
  ADD KEY `id_votantes` (`id_votantes`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_votos`
--
ALTER TABLE `tbl_votos`
  ADD CONSTRAINT `tbl_votos_ibfk_1` FOREIGN KEY (`id_candidato`) REFERENCES `tbl_candidatos` (`id_candidato`),
  ADD CONSTRAINT `tbl_votos_ibfk_2` FOREIGN KEY (`id_votantes`) REFERENCES `tbl_votantes` (`id_votantes`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
