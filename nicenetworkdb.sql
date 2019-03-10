-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 31, 2016 at 10:20 AM
-- Server version: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nicenetworkdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `file`
--

CREATE TABLE IF NOT EXISTS `file` (
`id` int(11) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `file` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `landing_page`
--

CREATE TABLE IF NOT EXISTS `landing_page` (
`id` int(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `description` text,
  `status` int(2) DEFAULT NULL,
  `category` int(2) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE IF NOT EXISTS `profile` (
`id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `birthplace` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profile`
--

INSERT INTO `profile` (`id`, `address`, `birthday`, `birthplace`, `email`, `phone`, `photo`, `role`, `user_name`, `user_id`) VALUES
(2, 'jl warga 008/003', '2016-07-01', 'pasar minggu', 'israj.haliri@gmail.com', '85862624149', 'kucing.jpg', 'ROLE_ADMIN', 'israj haliri', 2),
(3, 'jl warga 008/003', '', 'pasar minggu', '1israj.haliri@gmail.com', '85862624149', NULL, 'ROLE_ADMIN', '2', 3),
(4, 'jl warga 008/003', '', 'pasar minggu', '3israj.haliri@gmail.com', '85862624149', NULL, 'ROLE_ADMIN', '32', 5),
(5, 'jl warga 008/003', '', 'pasar minggu', '4israj.haliri@gmail.com', '85862624149', NULL, 'ROLE_ADMIN', '42', 6),
(6, '', '', '', '5israj.haliri@gmail.com', '', NULL, 'ROLE_ADMIN', '52', 7),
(7, '', '', '', '6israj.haliri@gmail.com', '', NULL, 'ROLE_ADMIN', '62', 8),
(8, '', '', '', '7israj.haliri@gmail.com', '', NULL, 'ROLE_ADMIN', '7', 9),
(9, '', '', '', '8israj.haliri@gmail.com', '', NULL, 'ROLE_ADMIN', '8', 10),
(10, '', '', '', '9israj.haliri@gmail.com', '', NULL, 'ROLE_ADMIN', '9', 11),
(11, '', '', '', '10israj.haliri@gmail.com', '', NULL, 'ROLE_ADMIN', '10', 12),
(12, '', '', '', '11israj.haliri@gmail.com', '', NULL, 'ROLE_ADMIN', '11', 13),
(13, '', '', '', '12israj.haliri@gmail.com', '', NULL, 'ROLE_ADMIN', '12', 14);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `active`, `password`, `username`) VALUES
(2, 1, '$2a$10$hjYcr2Cjuev.h5va2h2lQeDU4Vi4i3n4JBKIOOZvRotlorFLW.F6K', 'israj haliri'),
(3, 1, '$2a$10$ApQTb92b6Gx4yUzFdXTHk.ZWVDz1PCZsfkhEsLeWfPfN4Z0nTHkK.', '2'),
(5, 1, '$2a$10$V.EpYE6NFt5miQ4GAc0pYectcNVFbFdCUwE5HQ5rBpNwQSiROiBbq', '32'),
(6, 1, '$2a$10$qbz4./YwzZfHcHzCK51BEeqv7k0cNbDoGI06Jx4cqhgecXI4IJ/x.', '42'),
(7, 1, '$2a$10$/XelIn3FgZDhbdPGNnQ6PeyVwz6.K7eF6fN7J5pSS5r/RG0hnMURW', '52'),
(8, 1, '$2a$10$7mmXBOSpv2aePITLZrLdbeIy8cjfcB7X3yO0ouj2VK/GJk4eVTR/W', '62'),
(9, 1, '$2a$10$PLDrtTCqh2cVEzz7n96eV.UBsurMcYppN9TRC353SlIkiKnDd/ahi', '7'),
(10, 1, '$2a$10$m7mOoBDoXjtq5vOUDa49vOkAh7zZVP2KRc4oCDlyfHzNzidh2JNfu', '8'),
(11, 1, '$2a$10$vQej.oqLE5GeC0/qdO9GhuxlhMaadL.TPeEt1MS7BzMR9pBq6vaV2', '9'),
(12, 1, '$2a$10$8wyXLsgFvTg7vkAripVUZ.zUzfGosNmBpETJUP7bfRjnJAyumdSWq', '10'),
(13, 1, '$2a$10$CRx6uu5RW5ptHkSD2nh5uuwxU0zPeDDfiu.pLwqEvykhZqe7Velvu', '11'),
(14, 1, '$2a$10$8YfuMdiLoc32AYNSBPvS2OsaxsRguigH8H7JA4ABuAJafb3uuayGm', '12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `file`
--
ALTER TABLE `file`
 ADD PRIMARY KEY (`id`), ADD KEY `parent_id` (`parent_id`);

--
-- Indexes for table `landing_page`
--
ALTER TABLE `landing_page`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `profile`
--
ALTER TABLE `profile`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UK_9d5dpsf2ufa6rjbi3y0elkdcd` (`email`), ADD UNIQUE KEY `UK_9jjxi965sv9ex9ry9ni299yty` (`user_name`), ADD KEY `FK_c1dkiawnlj6uoe6fnlwd6j83j` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `file`
--
ALTER TABLE `file`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `landing_page`
--
ALTER TABLE `landing_page`
MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT for table `profile`
--
ALTER TABLE `profile`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `file`
--
ALTER TABLE `file`
ADD CONSTRAINT `file_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `landing_page` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `profile`
--
ALTER TABLE `profile`
ADD CONSTRAINT `FK_c1dkiawnlj6uoe6fnlwd6j83j` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
