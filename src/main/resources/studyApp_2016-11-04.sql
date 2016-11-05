# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.15)
# Database: studyApp
# Generation Time: 2016-11-04 19:36:18 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table journals
# ------------------------------------------------------------

DROP TABLE IF EXISTS `journals`;

CREATE TABLE `journals` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `directory` varchar(255) DEFAULT NULL,
  `machine` varchar(255) DEFAULT NULL,
  `my_date` datetime DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `journals` WRITE;
/*!40000 ALTER TABLE `journals` DISABLE KEYS */;

INSERT INTO `journals` (`id`, `comments`, `directory`, `machine`, `my_date`, `project`, `version`)
VALUES
	(1,'this is the root of my spring boot learning, lots of great stuff here','directory','mbp13',NULL,'SpringBootLearning',0),
	(2,'good mvc example from spring guru','/workspace/springbootlearning/springmvc','mbp13',NULL,'Spring - Java',0),
	(3,'Study app in node/mongo, deployed to CF','/nodework/DougStudyApp','imac',NULL,'node',0),
	(4,'simple git example of basic operations','/gitwork/git-exampleDoug','imac',NULL,'node',0),
	(5,'good example of using thymeleaf','~/workspace/springbootlearning/sfgthymeleaf','mbp13',NULL,'SfgthymeleafDoug',0);

/*!40000 ALTER TABLE `journals` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_created` datetime DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO `role` (`id`, `date_created`, `last_updated`, `version`, `role`)
VALUES
	(1,'2016-11-02 17:47:35','2016-11-02 17:47:35',0,'CUSTOMER'),
	(2,'2016-11-02 17:47:35','2016-11-02 17:47:35',0,'ADMIN');

/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table role_users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role_users`;

CREATE TABLE `role_users` (
  `role_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `users_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_created` datetime DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `encrypted_password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `date_created`, `last_updated`, `version`, `enabled`, `encrypted_password`, `username`)
VALUES
	(1,'2016-11-02 17:47:35','2016-11-02 18:29:38',2,b'1','Iq2AJ6uIoEQsWNnBHckc18o6ZyzCIcujqExmEyJKnvj7w6yTDiBXwL5f+PpiHt6u','mweston'),
	(2,'2016-11-02 17:47:35','2016-11-02 18:29:38',3,b'1','4J17i0tWDYorieT0lZTs8XHT8BOpYMRkBIRMcqH/ELcEbcc2dogdw3qPNILe2SPH','fglenanne'),
	(3,'2016-11-02 17:47:35','2016-11-02 18:29:38',2,b'1','wykZnr6aGNMUYgVraXEYcuy39CLHQUyTWnpSDK5q2QJ4+SWqhPYmHgnGAAJz5/ff','saxe'),
	(4,'2016-11-02 17:47:35','2016-11-02 18:29:38',2,b'1','ZmTfiWrE9mdIHXdgU40YArqx3NLN1yIVw4Wk441JdUHn5zRtPPFCAnma4BN7nK3w','doug');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_roles
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL,
  `roles_id` int(11) NOT NULL,
  KEY `FKj9553ass9uctjrmh0gkqsmv0d` (`roles_id`),
  KEY `FK55itppkw3i07do3h7qoclqd4k` (`user_id`),
  CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKj9553ass9uctjrmh0gkqsmv0d` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;

INSERT INTO `user_roles` (`user_id`, `roles_id`)
VALUES
	(1,1),
	(1,1),
	(4,2),
	(2,2),
	(2,1);

/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
