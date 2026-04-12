-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 12, 2026 at 04:53 PM
-- Server version: 9.1.0
-- PHP Version: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `crm_lead`
--

-- --------------------------------------------------------

--
-- Table structure for table `leads`
--

DROP TABLE IF EXISTS `leads`;
CREATE TABLE IF NOT EXISTS `leads` (
  `lead_id` int NOT NULL AUTO_INCREMENT,
  `contact_name` varchar(50) NOT NULL,
  `company_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `province_id` int DEFAULT NULL,
  `expected_revenue` decimal(38,2) DEFAULT NULL,
  `tax_code` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `citizen_id` varchar(12) DEFAULT NULL,
  `status_id` int DEFAULT NULL,
  `source_id` int DEFAULT NULL,
  `sales_group_id` int DEFAULT NULL,
  `interested_products` varchar(255) DEFAULT NULL COMMENT 'Sản phẩm / Dịch vụ quan tâm',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`lead_id`),
  UNIQUE KEY `phone` (`phone`),
  KEY `status_id` (`status_id`),
  KEY `source_id` (`source_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `leads`
--

INSERT INTO `leads` (`lead_id`, `contact_name`, `company_name`, `phone`, `email`, `address`, `province_id`, `expected_revenue`, `tax_code`, `citizen_id`, `status_id`, `source_id`, `sales_group_id`, `interested_products`, `created_at`, `updated_at`) VALUES
(1, 'thịnh suy', 'VTI', '0333461641', 'thinhsuy2304@gmail.com', '180 cao lo', 7, 9000000.00, '3333333333', '098465738453', 2, 1, 5, 'Phần mềm CRM,Phần mềm Kế toán', '2026-04-10 08:32:40', '2026-04-11 07:26:26'),
(2, 'sinhvien', 'TNHH 1 thanh vien', '0987654321', 'thinhsuy2304@gmail.com', '230 tay thanh', 2, 3333333.00, '4444444444', '098576334233', 2, 2, 3, 'Thiết kế Website,Dịch vụ SEO', '2026-04-10 09:20:02', '2026-04-11 07:26:46');

-- --------------------------------------------------------

--
-- Table structure for table `lead_activities`
--

DROP TABLE IF EXISTS `lead_activities`;
CREATE TABLE IF NOT EXISTS `lead_activities` (
  `activity_id` int NOT NULL AUTO_INCREMENT,
  `lead_id` int DEFAULT NULL,
  `activity_type` enum('Call','Email','Meeting','Note') DEFAULT NULL,
  `activity_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `description` text,
  `staff_id` int DEFAULT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `lead_id` (`lead_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lead_interests`
--

DROP TABLE IF EXISTS `lead_interests`;
CREATE TABLE IF NOT EXISTS `lead_interests` (
  `lead_id` int NOT NULL,
  `item_id` int NOT NULL,
  PRIMARY KEY (`lead_id`,`item_id`),
  KEY `item_id` (`item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lead_sources`
--

DROP TABLE IF EXISTS `lead_sources`;
CREATE TABLE IF NOT EXISTS `lead_sources` (
  `source_id` int NOT NULL AUTO_INCREMENT,
  `source_name` varchar(100) NOT NULL,
  PRIMARY KEY (`source_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lead_statuses`
--

DROP TABLE IF EXISTS `lead_statuses`;
CREATE TABLE IF NOT EXISTS `lead_statuses` (
  `status_id` int NOT NULL AUTO_INCREMENT,
  `status_name` varchar(50) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products_services`
--

DROP TABLE IF EXISTS `products_services`;
CREATE TABLE IF NOT EXISTS `products_services` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL,
  `item_type` enum('Product','Service') DEFAULT NULL,
  `base_price` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
