-- phpMyAdmin SQL Dump
-- version 4.4.15.8
-- https://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 13-12-2016 a las 16:45:51
-- Versión del servidor: 5.6.31
-- Versión de PHP: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ET-JAVABBDD`
--
CREATE DATABASE IF NOT EXISTS `ET-JAVABBDD` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ET-JAVABBDD`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Bebidas`
--

CREATE TABLE IF NOT EXISTS `Bebidas` (
  `idBebida` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Bebidas`
--

INSERT INTO `Bebidas` (`idBebida`, `nombre`, `precio`) VALUES
(1, 'Mineral', 700),
(2, 'Jugo', 800),
(3, 'Malteada', 1000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Clientes`
--

CREATE TABLE IF NOT EXISTS `Clientes` (
  `rut` varchar(10) NOT NULL,
  `clave` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apPaterno` varchar(25) NOT NULL,
  `apMaterno` varchar(25) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `numeracion` int(11) NOT NULL,
  `comuna` varchar(4) NOT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Comunas`
--

CREATE TABLE IF NOT EXISTS `Comunas` (
  `codigo` varchar(4) NOT NULL,
  `nombre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Comunas`
--

INSERT INTO `Comunas` (`codigo`, `nombre`) VALUES
('CERN', 'Cerro Navia'),
('CERR', 'Cerrillos'),
('CONC', 'Conchalí'),
('EBOS', 'El Bosque'),
('ESTC', 'Estación Central'),
('HUEC', 'Huechuraba'),
('INDE', 'Independencia'),
('LBAR', 'Lo Barnechea'),
('LCIS', 'La Cisterna'),
('LCON', 'Las Condes'),
('LESP', 'Lo Espejo'),
('LFLO', 'La Florida'),
('LGRA', 'La Granja'),
('LPIN', 'La Pintana'),
('LPRA', 'Lo Prado'),
('LREI', 'La Reina'),
('MACU', 'Macul'),
('MAIP', 'Maipú'),
('NUNO', 'Ñuñoa'),
('PEAC', 'Pedro Aguirre Cerda'),
('PENA', 'Peñalolén'),
('PROV', 'Providencia'),
('PUDA', 'Pudahuel'),
('QNOR', 'Quinta Normal'),
('QUIL', 'Quilicura'),
('RECO', 'Recoleta'),
('RENC', 'Renca'),
('SANT', 'Santiago'),
('SJOA', 'San Joaquín'),
('SMIG', 'San Miguel'),
('SRAM', 'San Ramón'),
('VITA', 'Vitacura');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Pedidos`
--

CREATE TABLE IF NOT EXISTS `Pedidos` (
  `idPedido` int(11) NOT NULL,
  `rutCliente` varchar(10) NOT NULL,
  `plato` int(11) NOT NULL,
  `bebida` int(11) NOT NULL,
  `despacho` tinyint(1) NOT NULL,
  `total` int(11) NOT NULL,
  `fechaHora` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Platos`
--

CREATE TABLE IF NOT EXISTS `Platos` (
  `idPlato` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Platos`
--

INSERT INTO `Platos` (`idPlato`, `nombre`, `precio`) VALUES
(1, 'Arroz con pollo', 3200),
(2, 'Cazuela de vacuno', 3500),
(3, 'Lentejas con longaniza', 3000),
(4, 'Porotos con riendas', 2000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Bebidas`
--
ALTER TABLE `Bebidas`
  ADD PRIMARY KEY (`idBebida`);

--
-- Indices de la tabla `Clientes`
--
ALTER TABLE `Clientes`
  ADD PRIMARY KEY (`rut`),
  ADD KEY `comuna` (`comuna`);

--
-- Indices de la tabla `Comunas`
--
ALTER TABLE `Comunas`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `Pedidos`
--
ALTER TABLE `Pedidos`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `rutCliente` (`rutCliente`),
  ADD KEY `plato` (`plato`),
  ADD KEY `bebida` (`bebida`);

--
-- Indices de la tabla `Platos`
--
ALTER TABLE `Platos`
  ADD PRIMARY KEY (`idPlato`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Pedidos`
--
ALTER TABLE `Pedidos`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Clientes`
--
ALTER TABLE `Clientes`
  ADD CONSTRAINT `FK_cliente_comuna` FOREIGN KEY (`comuna`) REFERENCES `Comunas` (`codigo`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `Pedidos`
--
ALTER TABLE `Pedidos`
  ADD CONSTRAINT `FK_pedido_bebida` FOREIGN KEY (`bebida`) REFERENCES `Bebidas` (`idBebida`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_pedido_cliente` FOREIGN KEY (`rutCliente`) REFERENCES `Clientes` (`rut`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_pedido_plato` FOREIGN KEY (`plato`) REFERENCES `Platos` (`idPlato`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
