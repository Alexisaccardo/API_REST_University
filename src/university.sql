-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 05-10-2023 a las 15:49:27
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `university`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usus`
--

DROP TABLE IF EXISTS `usus`;
CREATE TABLE IF NOT EXISTS `usus` (
  `course` varchar(30) NOT NULL,
  `teacher` varchar(30) NOT NULL,
  `number_students` varchar(30) NOT NULL,
  `schedule` varchar(30) NOT NULL,
  `semester` varchar(30) NOT NULL,
  `working_day` varchar(30) NOT NULL,
  `campus` varchar(30) NOT NULL,
  PRIMARY KEY (`course`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usus`
--

INSERT INTO `usus` (`course`, `teacher`, `number_students`, `schedule`, `semester`, `working_day`, `campus`) VALUES
('Auxiliar de veterinaria', 'Julian Silva', '30', 'Lunes a viernes', 'Primero', 'diurna', 'porvenir'),
('Vigilancia', 'Michael', '30', 'Lunes a viernes', 'cinco', 'Diurno', 'Simon bolivar');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
