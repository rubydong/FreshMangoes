-- MySQL dump 10.13  Distrib 5.7.22, for osx10.13 (x86_64)
--
-- Host: localhost    Database: cse308
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `casted`
--

DROP TABLE IF EXISTS `casted`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `casted` (
  `id` int(11) NOT NULL,
  `role` text,
  `celebrity_id` int(11) DEFAULT NULL,
  `content_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeinemy663e61qd2ot9mbpvr0r` (`celebrity_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `celebrities`
--

DROP TABLE IF EXISTS `celebrities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `celebrities` (
  `id` int(11) NOT NULL,
  `biography` text,
  `birthday` datetime DEFAULT NULL,
  `birthplace` varchar(255) DEFAULT NULL,
  `celebrity_name` varchar(255) DEFAULT NULL,
  `views` decimal(19,2) DEFAULT NULL,
  `profile_picture` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt6n4mshm9dxvn59lehdokuf7n` (`profile_picture`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `celebrity_media`
--

DROP TABLE IF EXISTS `celebrity_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `celebrity_media` (
  `celebrity_id` int(11) NOT NULL,
  `media_id` int(11) NOT NULL,
  KEY `FK1fu1jikdluia0yljfm56he2nj` (`media_id`),
  KEY `FKhufal6pufcnljav99tmo2dmtx` (`celebrity_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `content_genre`
--

DROP TABLE IF EXISTS `content_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content_genre` (
  `metadata_id` int(11) NOT NULL,
  `genre` int(11) DEFAULT NULL,
  KEY `FKr2fsytmh9kh0mvjsu0xul6ch7` (`metadata_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `content_media`
--

DROP TABLE IF EXISTS `content_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content_media` (
  `content_id` int(11) NOT NULL,
  `media_id` int(11) NOT NULL,
  UNIQUE KEY `UK_f6bxw2sgn21lk4dxdinlpkyjp` (`media_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `content_metadata`
--

DROP TABLE IF EXISTS `content_metadata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content_metadata` (
  `id` int(11) NOT NULL,
  `audience_score` double DEFAULT NULL,
  `mango_score` double DEFAULT NULL,
  `maturity_rating` varchar(255) DEFAULT NULL,
  `content_name` varchar(255) DEFAULT NULL,
  `release_date` datetime DEFAULT NULL,
  `runtime` int(11) DEFAULT NULL,
  `studio_network` varchar(255) DEFAULT NULL,
  `summary` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `crew`
--

DROP TABLE IF EXISTS `crew`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crew` (
  `id` int(11) NOT NULL,
  `job` text,
  `celebrity_id` int(11) DEFAULT NULL,
  `content_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgmi569238pqg5g5ur7m6em1ml` (`celebrity_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `disinterests`
--

DROP TABLE IF EXISTS `disinterests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disinterests` (
  `user_id` int(11) NOT NULL,
  `content_id` int(11) NOT NULL,
  KEY `FKpqbt85t8sh1wi4o66apbrefti` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `episodes`
--

DROP TABLE IF EXISTS `episodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `episodes` (
  `id` int(11) NOT NULL,
  `content_type` int(11) DEFAULT NULL,
  `views` decimal(19,2) DEFAULT NULL,
  `metadata_id` int(11) DEFAULT NULL,
  `summary_photo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rqc2lcbh5atqu9nhmrqwd3xjv` (`metadata_id`),
  KEY `FK_8qnnvpf9skot1updrq3etsb0o` (`summary_photo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `following`
--

DROP TABLE IF EXISTS `following`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `following` (
  `follower_id` int(11) NOT NULL,
  `followee_id` int(11) NOT NULL,
  KEY `FKkbpwn1k4c22go17juoxkk4007` (`followee_id`),
  KEY `FK7o8rmeuf83dqi0b2bvdhuwo9g` (`follower_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `interests`
--

DROP TABLE IF EXISTS `interests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interests` (
  `user_id` int(11) NOT NULL,
  `content_id` int(11) NOT NULL,
  KEY `FKq9kr60l7n7h3yf82s44rkoe4g` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `media`
--

DROP TABLE IF EXISTS `media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media` (
  `id` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `media_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
  `id` int(11) NOT NULL,
  `content_type` int(11) DEFAULT NULL,
  `views` decimal(19,2) DEFAULT NULL,
  `metadata_id` int(11) DEFAULT NULL,
  `summary_photo` int(11) DEFAULT NULL,
  `revenue` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_g9oaomvaqlt85e73vwpaoener` (`metadata_id`),
  KEY `FK_nwbre21w32ic06lyk3xgl7dws` (`summary_photo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ratings`
--

DROP TABLE IF EXISTS `ratings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ratings` (
  `id` int(11) NOT NULL,
  `body` text,
  `flagged` bit(1) DEFAULT NULL,
  `report` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `content_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb3354ee2xxvdrbyq9f42jdayd` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `season_episodes`
--

DROP TABLE IF EXISTS `season_episodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `season_episodes` (
  `season_id` int(11) NOT NULL,
  `episode_id` int(11) NOT NULL,
  UNIQUE KEY `UK_bfrnjvoi6k296nx96n2ndsvf5` (`episode_id`),
  KEY `FKco3rn0iuotl5rbfyj9qh003u9` (`season_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `seasons`
--

DROP TABLE IF EXISTS `seasons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seasons` (
  `id` int(11) NOT NULL,
  `content_type` int(11) DEFAULT NULL,
  `views` decimal(19,2) DEFAULT NULL,
  `metadata_id` int(11) DEFAULT NULL,
  `summary_photo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bk7hi2cpyr86wadowgurl13u3` (`metadata_id`),
  KEY `FK_8976fi8gh1t99jxl9vybksjft` (`summary_photo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `show_seasons`
--

DROP TABLE IF EXISTS `show_seasons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `show_seasons` (
  `show_id` int(11) NOT NULL,
  `season_id` int(11) NOT NULL,
  UNIQUE KEY `UK_esyixasulssavkeknu8p4x5po` (`season_id`),
  KEY `FKp99ambm0je50oc9ckf2rmxwdj` (`show_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shows`
--

DROP TABLE IF EXISTS `shows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shows` (
  `id` int(11) NOT NULL,
  `content_type` int(11) DEFAULT NULL,
  `views` decimal(19,2) DEFAULT NULL,
  `metadata_id` int(11) DEFAULT NULL,
  `summary_photo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6447puiq2k6lsodpjk89i52ff` (`metadata_id`),
  KEY `FK_8wbjrv4o4smc6n4sh1oarv4dp` (`summary_photo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `display_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `hash` varchar(255) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `verification_key` varchar(255) DEFAULT NULL,
  `verified` bit(1) DEFAULT NULL,
  `views` decimal(19,2) DEFAULT NULL,
  `profile_picture` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1pydgvfup6y3srrvpvlxivr76` (`profile_picture`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-28 17:46:42
