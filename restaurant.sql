-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-02-2021 a las 20:23:14
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `restaurant`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`id`, `description`, `name`) VALUES
(1, 'Restaurant furniture', 'Furniture'),
(2, 'Non-alcoholic beverage for customers', 'Non-alcoholic beverage'),
(3, 'Alcoholic beverage for customers', 'Alcoholic beverage'),
(4, 'Liquid ingredients for cooking', 'Liquid ingredients'),
(5, 'Fresh ingredients for cooking', 'Fresh ingredients'),
(6, 'Dry ingredients for cooking', 'Dry ingredients');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orderedproducts`
--

CREATE TABLE `orderedproducts` (
  `id` int(11) NOT NULL,
  `units` int(11) DEFAULT NULL,
  `orders_id` int(11) DEFAULT NULL,
  `products_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `orderedproducts`
--

INSERT INTO `orderedproducts` (`id`, `units`, `orders_id`, `products_id`) VALUES
(1, 6, 1, 1),
(2, 4, 2, 1),
(3, 7, 2, 2),
(4, 12, 3, 1),
(5, 2, 4, 1),
(6, 3, 5, 1),
(7, 5, 6, 1),
(8, 3, 7, 1),
(9, 3, 8, 1),
(10, 13, 9, 1),
(11, 4, 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `ord_date` date DEFAULT NULL,
  `sent` int(11) DEFAULT NULL,
  `restaurant_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `orders`
--

INSERT INTO `orders` (`id`, `ord_date`, `sent`, `restaurant_id`) VALUES
(1, '2021-02-20', 0, 1),
(2, '2021-02-20', 0, 1),
(3, '2021-02-20', 0, 1),
(4, '2021-02-20', 0, 1),
(5, '2021-02-20', 0, 1),
(6, '2021-02-20', 0, 1),
(7, '2021-02-20', 0, 1),
(8, '2021-02-20', 0, 1),
(9, '2021-02-20', 0, 1),
(10, '2021-02-21', 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `description` varchar(90) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`id`, `description`, `name`, `price`, `stock`, `weight`, `category_id`) VALUES
(4, 'Table', 'Table', 30.5, 60, 15.4, 1),
(3, 'Chair', 'Chair', 15.4, 43, 8.2, 1),
(5, 'Bench', 'Bench', 43.2, 35, 45.7, 1),
(6, 'Diet Coke', 'Diet Coke', 0.35, 500, 0.4, 2),
(7, 'Regular Coke', 'Regular Coke', 0.35, 500, 0.4, 2),
(8, 'Zero Coke', 'Zero Coke', 0.35, 500, 0.4, 2),
(9, 'Orange Fanta', 'Orange Fanta', 0.35, 500, 0.4, 2),
(10, 'Lemon Fanta', 'Lemon Fanta', 0.35, 500, 0.4, 2),
(11, 'Lemon Nestea', 'Lemon Nestea', 0.55, 250, 0.55, 2),
(12, 'Sprite', 'Sprite', 0.35, 500, 0.4, 2),
(13, 'Cruzcampo Beer', 'Cruzcampo Beer', 0.3, 300, 0.4, 3),
(14, 'Mahou Beer', 'Mahou Beer', 0.3, 300, 0.4, 3),
(15, 'Alhambra Beer', 'Alhambra Beer', 0.3, 300, 0.4, 3),
(16, 'Olive oil', 'Olive oil', 10.2, 40, 5.1, 4),
(17, 'Sunflower oil', 'Sunflower oil', 4.55, 40, 5.1, 4),
(18, 'White wine', 'White wine', 0.55, 55, 1.1, 4),
(19, 'Red wine', 'Red wine', 0.55, 55, 1.1, 4),
(20, 'Regular Milk', 'Regular Milk', 0.35, 50, 1.1, 4),
(21, 'Lactose-free Milk', 'Lactose-free Milk', 0.45, 50, 1.1, 4),
(22, 'Lettuce', 'Lettuce', 0.1, 60, 0.7, 5),
(23, 'Tomato', 'Tomato', 0.18, 80, 0.3, 5),
(24, 'Chicken breast', 'Chicken breast', 2.55, 50, 1, 5),
(25, 'Pork chop', 'Pork chop', 0.55, 50, 0.25, 5),
(26, 'Wheat flour', 'Wheat flour', 0.35, 150, 1, 6),
(27, 'Sea salt', 'Sea salt', 0.05, 50, 1, 6),
(28, 'Bread crumbs', 'Bread crumbs', 0.35, 10, 1, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurant`
--

CREATE TABLE `restaurant` (
  `id` int(11) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `mail` varchar(90) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `postcode` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `restaurant`
--

INSERT INTO `restaurant` (`id`, `address`, `city`, `country`, `mail`, `password`, `postcode`) VALUES
(1, 'a', 'a', 'a', 'olga@mail.com', '1234', '41006');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_46ccwnsi9409t36lurvtyljak` (`name`);

--
-- Indices de la tabla `orderedproducts`
--
ALTER TABLE `orderedproducts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf2qrkslgbqw6dbxvy15ph39kn` (`orders_id`),
  ADD KEY `FK20uhiqiuxwcqxo3cfntcwpxno` (`products_id`);

--
-- Indices de la tabla `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKi7hgjxhw21nei3xgpe4nnpenh` (`restaurant_id`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1cf90etcu98x1e6n9aks3tel3` (`category_id`);

--
-- Indices de la tabla `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_t53ntj514u734ef17u5s37ral` (`mail`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `orderedproducts`
--
ALTER TABLE `orderedproducts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
