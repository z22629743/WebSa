-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- 主機: localhost
-- 產生時間： 2016 年 12 月 18 日 13:28
-- 伺服器版本: 10.1.19-MariaDB
-- PHP 版本： 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `practice`
--

-- --------------------------------------------------------

--
-- 資料表結構 `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Phone` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Email` text NOT NULL,
  `Account` text NOT NULL,
  `Password` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `customer`
--

INSERT INTO `customer` (`CustomerID`, `Name`, `Phone`, `Address`, `Email`, `Account`, `Password`) VALUES
(15, '1234', '123', '123', '123', '123', '123'),
(16, 'a', '0978255850', '新北市土城區', 'a22629743@gmail.com', '林紘鋙', '1'),
(19, 'b', '0987878787', 's_M', 'pipi@gmail.com', '°a', '2'),
(20, 'c', '88908', 'g', '983', '', '3'),
(21, 'sad', 'asd', 'asd', 'asd', 'b', '1');

-- --------------------------------------------------------

--
-- 資料表結構 `product`
--

CREATE TABLE `product` (
  `ProductID` bigint(11) NOT NULL,
  `SupplierID` bigint(20) NOT NULL,
  `Name` text NOT NULL,
  `Color` text NOT NULL,
  `Size` text NOT NULL,
  `Category` text NOT NULL,
  `Description` text NOT NULL,
  `Inventory` int(11) NOT NULL,
  `ReorderPoint` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `discount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `product`
--

INSERT INTO `product` (`ProductID`, `SupplierID`, `Name`, `Color`, `Size`, `Category`, `Description`, `Inventory`, `ReorderPoint`, `price`, `discount`) VALUES
(21, 1, 'coat', 'black', 'XL', 'men', 'good', 17, 20, 300, 0);

-- --------------------------------------------------------

--
-- 資料表結構 `purchaseorder`
--

CREATE TABLE `purchaseorder` (
  `ProductID` bigint(100) NOT NULL,
  `Quantity` bigint(100) DEFAULT NULL,
  `OrderTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 資料表的匯出資料 `purchaseorder`
--

INSERT INTO `purchaseorder` (`ProductID`, `Quantity`, `OrderTime`) VALUES
(21, -12, '2016-12-18 20:18:45');

-- --------------------------------------------------------

--
-- 資料表結構 `salesorder`
--

CREATE TABLE `salesorder` (
  `SOID` bigint(100) NOT NULL,
  `orderTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 資料表的匯出資料 `salesorder`
--

INSERT INTO `salesorder` (`SOID`, `orderTime`) VALUES
(29, '2016-12-18 19:40:43'),
(30, '2016-12-18 19:41:51'),
(31, '2016-12-18 20:18:28'),
(32, '2016-12-18 20:21:54'),
(33, '2016-12-18 20:25:32'),
(34, '2016-12-18 20:26:23');

-- --------------------------------------------------------

--
-- 資料表結構 `salesorderitem`
--

CREATE TABLE `salesorderitem` (
  `id` bigint(100) NOT NULL,
  `SOID` bigint(100) NOT NULL,
  `ProductID` bigint(100) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 資料表的匯出資料 `salesorderitem`
--

INSERT INTO `salesorderitem` (`id`, `SOID`, `ProductID`, `Quantity`) VALUES
(29, 0, 21, 1),
(30, 0, 21, 1),
(31, 0, 21, 1),
(32, 0, 21, 1),
(33, 0, 21, 1),
(34, 0, 21, 1);

--
-- 已匯出資料表的索引
--

--
-- 資料表索引 `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- 資料表索引 `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductID`);

--
-- 資料表索引 `purchaseorder`
--
ALTER TABLE `purchaseorder`
  ADD PRIMARY KEY (`ProductID`);

--
-- 資料表索引 `salesorder`
--
ALTER TABLE `salesorder`
  ADD PRIMARY KEY (`SOID`);

--
-- 資料表索引 `salesorderitem`
--
ALTER TABLE `salesorderitem`
  ADD PRIMARY KEY (`id`);

--
-- 在匯出的資料表使用 AUTO_INCREMENT
--

--
-- 使用資料表 AUTO_INCREMENT `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- 使用資料表 AUTO_INCREMENT `product`
--
ALTER TABLE `product`
  MODIFY `ProductID` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- 使用資料表 AUTO_INCREMENT `salesorder`
--
ALTER TABLE `salesorder`
  MODIFY `SOID` bigint(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
--
-- 使用資料表 AUTO_INCREMENT `salesorderitem`
--
ALTER TABLE `salesorderitem`
  MODIFY `id` bigint(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
