-- MySQL dump 10.13  Distrib 5.7.19, for macos10.12 (x86_64)
--
-- Host: localhost    Database: cse308
-- ------------------------------------------------------
-- Server version	5.7.19

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


-- Table structure for `critic_application`
DROP TABLE IF EXISTS `critic_application`;
CREATE TABLE `critic_application` (
  `user_id` int(11),
  `statement` text DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);
--
-- Table structure for table `casted`
--

DROP TABLE IF EXISTS `casted`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `casted` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` text,
  `celebrity_id` int(11) DEFAULT NULL,
  `content_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeinemy663e61qd2ot9mbpvr0r` (`celebrity_id`),
  KEY `FK8jkabyrlmiucsv3oxwr9jio62` (`content_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casted`
--

LOCK TABLES `casted` WRITE;
/*!40000 ALTER TABLE `casted` DISABLE KEYS */;
/*!40000 ALTER TABLE `casted` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `celebrities`
--

DROP TABLE IF EXISTS `celebrities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `celebrities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `biography` text,
  `birthday` datetime DEFAULT NULL,
  `birthplace` varchar(255) DEFAULT NULL,
  `celebrity_name` varchar(255) DEFAULT NULL,
  `views` decimal(19,2) DEFAULT NULL,
  `profile_picture` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt6n4mshm9dxvn59lehdokuf7n` (`profile_picture`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `celebrities`
--

LOCK TABLES `celebrities` WRITE;
/*!40000 ALTER TABLE `celebrities` DISABLE KEYS */;
/*!40000 ALTER TABLE `celebrities` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `celebrity_media`
--

LOCK TABLES `celebrity_media` WRITE;
/*!40000 ALTER TABLE `celebrity_media` DISABLE KEYS */;
/*!40000 ALTER TABLE `celebrity_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content`
--

DROP TABLE IF EXISTS `content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content` (
  `content_type` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `revenue` decimal(19,2) DEFAULT NULL,
  `views` decimal(19,2) DEFAULT NULL,
  `metadata_id` int(11) DEFAULT NULL,
  `summary_photo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiav9hhg4oip1u8qbge7jhjo7q` (`metadata_id`),
  KEY `FKths342rwi39ephvkoxsuylh41` (`summary_photo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content`
--

LOCK TABLES `content` WRITE;
/*!40000 ALTER TABLE `content` DISABLE KEYS */;
/*!40000 ALTER TABLE `content` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_genre`
--

LOCK TABLES `content_genre` WRITE;
/*!40000 ALTER TABLE `content_genre` DISABLE KEYS */;
/*!40000 ALTER TABLE `content_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content_media`
--

DROP TABLE IF EXISTS `content_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content_media` (
  `content_id` int(11) NOT NULL,
  `media_id` int(11) NOT NULL,
  UNIQUE KEY `UK_f6bxw2sgn21lk4dxdinlpkyjp` (`media_id`),
  KEY `FK2xrsp5d2dlj6odb3yb9uan9rm` (`content_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_media`
--

LOCK TABLES `content_media` WRITE;
/*!40000 ALTER TABLE `content_media` DISABLE KEYS */;
/*!40000 ALTER TABLE `content_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content_metadata`
--

DROP TABLE IF EXISTS `content_metadata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content_metadata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `audience_score` double DEFAULT NULL,
  `mango_score` double DEFAULT NULL,
  `maturity_rating` varchar(255) DEFAULT NULL,
  `content_name` varchar(255) DEFAULT NULL,
  `release_date` datetime DEFAULT NULL,
  `runtime` int(11) DEFAULT NULL,
  `studio_network` varchar(255) DEFAULT NULL,
  `summary` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_metadata`
--

LOCK TABLES `content_metadata` WRITE;
/*!40000 ALTER TABLE `content_metadata` DISABLE KEYS */;
/*!40000 ALTER TABLE `content_metadata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crew`
--

DROP TABLE IF EXISTS `crew`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crew` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job` text,
  `celebrity_id` int(11) DEFAULT NULL,
  `content_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgmi569238pqg5g5ur7m6em1ml` (`celebrity_id`),
  KEY `FK9svuaa43iq4hn8hlk1e0bbmm` (`content_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crew`
--

LOCK TABLES `crew` WRITE;
/*!40000 ALTER TABLE `crew` DISABLE KEYS */;
/*!40000 ALTER TABLE `crew` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disinterests`
--

DROP TABLE IF EXISTS `disinterests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disinterests` (
  `user_id` int(11) NOT NULL,
  `content_id` int(11) NOT NULL,
  KEY `FKgwy8vb27dya6wo8cvgn35c0l7` (`content_id`),
  KEY `FKpqbt85t8sh1wi4o66apbrefti` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disinterests`
--

LOCK TABLES `disinterests` WRITE;
/*!40000 ALTER TABLE `disinterests` DISABLE KEYS */;
/*!40000 ALTER TABLE `disinterests` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `following`
--

LOCK TABLES `following` WRITE;
/*!40000 ALTER TABLE `following` DISABLE KEYS */;
/*!40000 ALTER TABLE `following` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interests`
--

DROP TABLE IF EXISTS `interests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interests` (
  `user_id` int(11) NOT NULL,
  `content_id` int(11) NOT NULL,
  KEY `FKjhxrs0awp9xffawmf5uk5bsnb` (`content_id`),
  KEY `FKq9kr60l7n7h3yf82s44rkoe4g` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interests`
--

LOCK TABLES `interests` WRITE;
/*!40000 ALTER TABLE `interests` DISABLE KEYS */;
/*!40000 ALTER TABLE `interests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media`
--

DROP TABLE IF EXISTS `media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) DEFAULT NULL,
  `media_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media`
--

LOCK TABLES `media` WRITE;
/*!40000 ALTER TABLE `media` DISABLE KEYS */;
/*!40000 ALTER TABLE `media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ratings`
--

DROP TABLE IF EXISTS `ratings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ratings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `body` text,
  `flagged` bit(1) DEFAULT NULL,
  `report` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `content_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfasgqqfwv14esnf4f0nnyeu0l` (`content_id`),
  KEY `FKb3354ee2xxvdrbyq9f42jdayd` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ratings`
--

LOCK TABLES `ratings` WRITE;
/*!40000 ALTER TABLE `ratings` DISABLE KEYS */;
/*!40000 ALTER TABLE `ratings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `season_episodes`
--

DROP TABLE IF EXISTS `season_episodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `season_episodes` (
  `season_id` int(11) DEFAULT NULL,
  `episode_id` int(11) NOT NULL,
  PRIMARY KEY (`episode_id`),
  KEY `FKy3bwvd39ph05trwb5nsxrf7c` (`season_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `season_episodes`
--

LOCK TABLES `season_episodes` WRITE;
/*!40000 ALTER TABLE `season_episodes` DISABLE KEYS */;
/*!40000 ALTER TABLE `season_episodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `show_seasons`
--

DROP TABLE IF EXISTS `show_seasons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `show_seasons` (
  `show_id` int(11) DEFAULT NULL,
  `season_id` int(11) NOT NULL,
  PRIMARY KEY (`season_id`),
  KEY `FKib4r1f14sas7aq8wqhy696syv` (`show_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `show_seasons`
--

LOCK TABLES `show_seasons` WRITE;
/*!40000 ALTER TABLE `show_seasons` DISABLE KEYS */;
/*!40000 ALTER TABLE `show_seasons` ENABLE KEYS */;
UNLOCK TABLES;

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
  `is_private` bit(1) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `verification_key` varchar(255) DEFAULT NULL,
  `verified` bit(1) DEFAULT NULL,
  `views` decimal(19,2) DEFAULT NULL,
  `profile_picture` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  KEY `FK1pydgvfup6y3srrvpvlxivr76` (`profile_picture`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-01 21:09:06
