-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2018 at 05:40 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spitterdbv02`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `COMMENT_ID` bigint(20) NOT NULL,
  `SPITTLE_ID` bigint(20) DEFAULT NULL,
  `REETWEET_ID` bigint(20) DEFAULT NULL,
  `SPITTER_ID` bigint(20) DEFAULT NULL,
  `COMMENT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `COMMENT_MESSAGE` varchar(2048) DEFAULT NULL,
  `COMMENT_LIKES` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`COMMENT_ID`, `SPITTLE_ID`, `REETWEET_ID`, `SPITTER_ID`, `COMMENT_TIMESTAMP`, `COMMENT_MESSAGE`, `COMMENT_LIKES`) VALUES
(1, 0, NULL, 1, '2018-04-14 15:37:07', 'Testiranje komentara', 10);

-- --------------------------------------------------------

--
-- Table structure for table `reetweet`
--

CREATE TABLE `reetweet` (
  `REETWEET_ID` bigint(20) NOT NULL,
  `SPITTER_ID` bigint(20) DEFAULT NULL,
  `SPITTLE_ID` bigint(20) DEFAULT NULL,
  `RETWEET_MESSAGE` varchar(2048) DEFAULT NULL,
  `RETWEET_LONGITUDE` decimal(10,0) DEFAULT NULL,
  `RETWEET_LATITUDE` decimal(10,0) DEFAULT NULL,
  `RETWEET_LIKES` int(11) DEFAULT NULL,
  `RETWEET_COMMENTS` int(11) DEFAULT NULL,
  `RETWEET_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reetweet`
--

INSERT INTO `reetweet` (`REETWEET_ID`, `SPITTER_ID`, `SPITTLE_ID`, `RETWEET_MESSAGE`, `RETWEET_LONGITUDE`, `RETWEET_LATITUDE`, `RETWEET_LIKES`, `RETWEET_COMMENTS`, `RETWEET_TIMESTAMP`) VALUES
(1, 1, 0, 'da vozim kamion, burke, zvao bih se Skanija', '232', '12', 232, 232, '2018-04-11 17:32:52');

-- --------------------------------------------------------

--
-- Table structure for table `spitter`
--

CREATE TABLE `spitter` (
  `SPITTER_ID` bigint(20) NOT NULL,
  `SPITTER_USERNAME` varchar(1024) DEFAULT NULL,
  `SPITTER_EMAIL` varchar(1024) DEFAULT NULL,
  `SPITTER_PASSWORD` varchar(1024) DEFAULT NULL,
  `SPITTER_PROFILE_PICTURE` varchar(1024) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `spitter`
--

INSERT INTO `spitter` (`SPITTER_ID`, `SPITTER_USERNAME`, `SPITTER_EMAIL`, `SPITTER_PASSWORD`, `SPITTER_PROFILE_PICTURE`) VALUES
(1, 'aleksa', 'aleksa.stojke@gmx.com', 'Klasicnokidanjebajomoj', 'stagod\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `spittle`
--

CREATE TABLE `spittle` (
  `SPITTLE_ID` bigint(20) NOT NULL,
  `SPITTER_ID` bigint(20) DEFAULT NULL,
  `SPITTLE_MESSAGE` varchar(2048) DEFAULT NULL,
  `SPITTLE_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `SPITTLE_LONGITUDE` decimal(10,0) DEFAULT NULL,
  `SPITTLE_LATITUDE` decimal(10,0) DEFAULT NULL,
  `SPITTLE_LIKES` int(11) DEFAULT NULL,
  `SPITTLE_COMMENTS` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `spittle`
--

INSERT INTO `spittle` (`SPITTLE_ID`, `SPITTER_ID`, `SPITTLE_MESSAGE`, `SPITTLE_TIMESTAMP`, `SPITTLE_LONGITUDE`, `SPITTLE_LATITUDE`, `SPITTLE_LIKES`, `SPITTLE_COMMENTS`) VALUES
(0, 1, 'da vozim kamion, burke, zvao bih se Skanija', '2018-04-11 17:31:52', '23', '4242', 10, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`COMMENT_ID`),
  ADD KEY `FK_RELATIONSHIP_2` (`SPITTER_ID`),
  ADD KEY `FK_RELATIONSHIP_3` (`SPITTLE_ID`),
  ADD KEY `FK_RELATIONSHIP_6` (`REETWEET_ID`);

--
-- Indexes for table `reetweet`
--
ALTER TABLE `reetweet`
  ADD PRIMARY KEY (`REETWEET_ID`),
  ADD KEY `FK_RELATIONSHIP_4` (`SPITTER_ID`),
  ADD KEY `FK_RELATIONSHIP_5` (`SPITTLE_ID`);

--
-- Indexes for table `spitter`
--
ALTER TABLE `spitter`
  ADD PRIMARY KEY (`SPITTER_ID`);

--
-- Indexes for table `spittle`
--
ALTER TABLE `spittle`
  ADD PRIMARY KEY (`SPITTLE_ID`),
  ADD KEY `FK_RELATIONSHIP_1` (`SPITTER_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `COMMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `reetweet`
--
ALTER TABLE `reetweet`
  MODIFY `REETWEET_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `spitter`
--
ALTER TABLE `spitter`
  MODIFY `SPITTER_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `FK_RELATIONSHIP_2` FOREIGN KEY (`SPITTER_ID`) REFERENCES `spitter` (`SPITTER_ID`),
  ADD CONSTRAINT `FK_RELATIONSHIP_3` FOREIGN KEY (`SPITTLE_ID`) REFERENCES `spittle` (`SPITTLE_ID`),
  ADD CONSTRAINT `FK_RELATIONSHIP_6` FOREIGN KEY (`REETWEET_ID`) REFERENCES `reetweet` (`REETWEET_ID`);

--
-- Constraints for table `reetweet`
--
ALTER TABLE `reetweet`
  ADD CONSTRAINT `FK_RELATIONSHIP_4` FOREIGN KEY (`SPITTER_ID`) REFERENCES `spitter` (`SPITTER_ID`),
  ADD CONSTRAINT `FK_RELATIONSHIP_5` FOREIGN KEY (`SPITTLE_ID`) REFERENCES `spittle` (`SPITTLE_ID`);

--
-- Constraints for table `spittle`
--
ALTER TABLE `spittle`
  ADD CONSTRAINT `FK_RELATIONSHIP_1` FOREIGN KEY (`SPITTER_ID`) REFERENCES `spitter` (`SPITTER_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
