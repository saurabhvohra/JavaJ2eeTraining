/*
SQLyog Community v9.50 
MySQL - 5.5.37 : Database - javaj2eetraining
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`javaj2eetraining` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `javaj2eetraining`;

/*Table structure for table `agent` */

DROP TABLE IF EXISTS `agent`;

CREATE TABLE `agent` (
  `agentid` int(15) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  PRIMARY KEY (`agentid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `agent` */

insert  into `agent`(`agentid`,`firstname`,`lastname`) values (6,'gaurav','Sachdev'),(7,'gaurav','Sachdev'),(8,'gaurav','Sachdev'),(9,'gaurav','Sachdev');

/*Table structure for table `agentbidirectional` */

DROP TABLE IF EXISTS `agentbidirectional`;

CREATE TABLE `agentbidirectional` (
  `agentid` int(15) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  PRIMARY KEY (`agentid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `agentbidirectional` */

insert  into `agentbidirectional`(`agentid`,`firstname`,`lastname`) values (1,'Rahul','Sachdev');

/*Table structure for table `agentdetails` */

DROP TABLE IF EXISTS `agentdetails`;

CREATE TABLE `agentdetails` (
  `agent_details` int(15) NOT NULL,
  `shopnumber` int(30) NOT NULL,
  `street` varchar(30) NOT NULL,
  `province` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `pincode` varchar(30) NOT NULL,
  KEY `agent_details` (`agent_details`),
  CONSTRAINT `agent_details` FOREIGN KEY (`agent_details`) REFERENCES `agent` (`agentid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `agentdetails` */

insert  into `agentdetails`(`agent_details`,`shopnumber`,`street`,`province`,`country`,`pincode`) values (6,255,'de maisonneuve','QUEBEC','CANADA','H3H 2N3'),(7,255,'de maisonneuve','QUEBEC','CANADA','H3H 2N3'),(8,255,'de maisonneuve','QUEBEC','CANADA','H3H 2N3'),(9,255,'de maisonneuve','QUEBEC','CANADA','H3H 2N3');

/*Table structure for table `agentdetailsbidirectional` */

DROP TABLE IF EXISTS `agentdetailsbidirectional`;

CREATE TABLE `agentdetailsbidirectional` (
  `agent_id` int(15) NOT NULL,
  `shopnumber` int(30) NOT NULL,
  `street` varchar(30) NOT NULL,
  `province` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `pincode` varchar(30) NOT NULL,
  PRIMARY KEY (`agent_id`),
  CONSTRAINT `agent_detail_id` FOREIGN KEY (`agent_id`) REFERENCES `agentbidirectional` (`agentid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `agentdetailsbidirectional` */

insert  into `agentdetailsbidirectional`(`agent_id`,`shopnumber`,`street`,`province`,`country`,`pincode`) values (1,255,'de maisonneuve','QUEBEC','CANADA','H3H 2N3');

/*Table structure for table `agents` */

DROP TABLE IF EXISTS `agents`;

CREATE TABLE `agents` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) CHARACTER SET latin1 NOT NULL,
  `lastname` varchar(30) CHARACTER SET latin1 NOT NULL,
  `city_id` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cityagents` (`city_id`),
  CONSTRAINT `cityagents` FOREIGN KEY (`city_id`) REFERENCES `province` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

/*Data for the table `agents` */

insert  into `agents`(`id`,`firstname`,`lastname`,`city_id`) values (33,'khushal','Singh',34),(34,'Saurabh','Vohra',34),(43,'khushal','Singh',39),(44,'Saurabh','Vohra',39),(45,'khushal','Singh',40),(46,'Saurabh','Vohra',40),(47,'khushal','Singh',41),(48,'Saurabh','Vohra',41),(49,'Saurabh','Vohra',42),(50,'khushal','Singh',42),(51,'Saurabh','Vohra',43),(52,'khushal','Singh',43),(53,'Saurabh','Vohra',44),(54,'khushal','Singh',44);

/*Table structure for table `appartments` */

DROP TABLE IF EXISTS `appartments`;

CREATE TABLE `appartments` (
  `id` int(15) NOT NULL,
  `appartment_number` int(30) NOT NULL,
  `appartment_id` int(30) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`appartment_id`),
  KEY `appartment_agents` (`id`),
  CONSTRAINT `appartment_agents` FOREIGN KEY (`id`) REFERENCES `agents` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `appartments` */

/*Table structure for table `authors` */

DROP TABLE IF EXISTS `authors`;

CREATE TABLE `authors` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `authors` */

insert  into `authors`(`id`,`name`) values (5,'Jack London'),(6,'Jack London'),(7,'Jack London'),(8,'Jack London'),(9,'Chamkila'),(10,'Chamkila'),(11,'Chamkila'),(12,'Chamkila'),(13,'Chamkila'),(14,'Chamkila'),(15,'Chamkila'),(16,'Chamkila'),(17,'Chamkila'),(18,'Chamkila'),(19,'Chamkila'),(20,'Chamkila'),(21,'Chamkila');

/*Table structure for table `biographies` */

DROP TABLE IF EXISTS `biographies`;

CREATE TABLE `biographies` (
  `author_id` int(6) NOT NULL,
  `information` varchar(100) NOT NULL,
  KEY `author_bio` (`author_id`),
  CONSTRAINT `author_bio` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `biographies` */

insert  into `biographies`(`author_id`,`information`) values (5,'Jack London was an American author..'),(6,'Jack London was an American author..'),(7,'Jack London was an American author..'),(8,'Jack London was an American author..'),(9,'Kan kar gal sun mitra'),(10,'Kan kar gal sun mitra'),(11,'Kan kar gal sun mitra'),(12,'Kan kar gal sun mitra'),(13,'Kan kar gal sun mitra'),(14,'Kan kar gal sun mitra'),(15,'Kan kar gal sun mitra'),(16,'Kan kar gal sun mitra'),(17,'Kan kar gal sun mitra'),(18,'Kan kar gal sun mitra'),(19,'Kan kar gal sun mitra'),(20,'Kan kar gal sun mitra'),(21,'Kan kar gal sun mitra');

/*Table structure for table `contacts` */

DROP TABLE IF EXISTS `contacts`;

CREATE TABLE `contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `telephone` varbinary(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

/*Data for the table `contacts` */

insert  into `contacts`(`id`,`firstname`,`lastname`,`telephone`,`email`,`created`) values (2,'S','V','5149636381','as@g.com','2014-05-02 21:49:58'),(3,'as','ss','54564','ssss','2014-05-02 22:28:27'),(4,'Saurabh','Vohra','4389934074','s.vohra1991@gmail.com','2014-05-02 22:29:06'),(5,'','','','','2014-05-28 13:06:00'),(6,'saurabh','vohra','123456','abcx@gmail.com','2014-05-31 20:46:50'),(7,'saurabh','vohra','4542123131','vngb@gmail.com','2014-05-31 22:04:28'),(8,'saurabh','ljlj','lkk','kjnkjnkjn','2014-05-31 22:05:20'),(9,'saurabh','vohra','4521212','jkjkjk','2014-05-31 22:15:50'),(10,'saurabh','mk','fsd','sfds','2014-05-31 22:19:00'),(11,'gffg','dsd','vf','sw','2014-05-31 22:22:59'),(12,'ds','fds','32','a@g.com','2014-05-31 22:35:53'),(13,'ds','fds','32','a@g.com','2014-05-31 22:40:26'),(14,'ds','fds','32','a@g.com','2014-05-31 22:40:45'),(15,'ds','fds','32','a@g.com','2014-05-31 22:43:07'),(16,'ds','fds','32','a@g.com','2014-05-31 22:46:14'),(17,'saurabh','v','1111','111@mail.com','2014-05-31 22:49:56'),(18,'s','ss','2','2','2014-05-31 22:50:49'),(19,'s','s','s','s@mail.com','2014-05-31 22:51:44'),(20,'saurabh','vohra','5456464651','sfds@hjahjkah.com','2014-05-31 22:56:58'),(21,'jahkjha','lamlma','123165451','ajkjank@gamial.com','2014-06-01 20:33:47'),(22,'ds','fds','32','a@g.com','2014-06-01 20:54:19'),(23,'das','dsa','das','a@g.com','2014-06-01 21:02:16'),(24,'jij',',m m,','lknkln','ryty@hjhkjj.com','2014-06-01 21:09:11'),(25,'nkjn','kmknkn','65465484','hhgh@gjhj.com','2014-06-01 21:11:42'),(26,'kjakjbajba','jhgjhbjhbjh','4654616156','vhvg@gjnn.com','2014-06-01 21:13:13'),(27,'kjhkjkj','joijkhn','4561656','jhjhb@gmail.com','2014-06-01 21:15:38'),(28,'hjhjb','jhbjhbjh','122354654','hghbhj@gmail.com','2014-06-01 21:16:52'),(29,'bjbkbj','bjbjbjbh','6461316','bhvh@jhbbb.com','2014-06-01 21:18:10'),(30,'kjbjbjbhjh','bjbjbjhb','1316513515','jbjbhj@kjnkjnkj.com','2014-06-01 21:26:34'),(31,',nkj','lknkn','64648','jbjhb@gbjhb.com','2014-06-01 21:28:28'),(32,'nbkjbjbjNKNKJNK','nkjnjjbj23516','161616kjnjNKN','NKNKNK@NMNK.COM','2014-06-01 21:37:40'),(33,'hkjhkjbjkbJHJHBJ','hihkjhijnjb','16545444','jknjn@jnknlkkm.com','2014-06-01 21:44:54'),(34,'N M MNK NKJN KJ','NKJKJNK','25156161','MLKMKJ@HMAIL.COM','2014-06-01 21:49:24'),(35,'hj','lknkjkj','5455','hbhjh@gmail.com','2014-06-01 22:40:08'),(36,'jj','kjnkbjhbjh','21252155','kjbjhhj@hmlk.com','2014-06-01 22:42:42'),(37,'','','','111@mail.com','2014-06-01 22:44:10'),(38,'','','','111@mail.com','2014-06-01 22:44:57'),(39,'sdsd','','','a@g.com','2014-06-01 23:08:28');

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `customers` */

/*Table structure for table `players` */

DROP TABLE IF EXISTS `players`;

CREATE TABLE `players` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(20) NOT NULL,
  `team_id` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `player's team` (`team_id`),
  CONSTRAINT `player's team` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `players` */

insert  into `players`(`id`,`lastname`,`team_id`) values (7,'Messi',7),(8,'Xavi',7),(9,'dhoni',8),(10,'Yuvi',8),(11,'Yuvi',9),(12,'dhoni',9),(13,'dhoni',10),(14,'Yuvi',10),(15,'dhoni',11),(16,'Yuvi',11),(17,'dhoni',12),(18,'Yuvi',12),(19,'Yuvi',13),(20,'dhoni',13),(21,'Yuvi',14),(22,'dhoni',14),(23,'Yuvi',15),(24,'dhoni',15),(25,'dhoni',16),(26,'Yuvi',16),(27,'dhoni',17),(28,'Yuvi',17),(29,'Yuvi',18),(30,'dhoni',18),(31,'dhoni',19),(32,'Yuvi',19),(33,'Yuvi',20),(34,'dhoni',20),(35,'dhoni',21),(36,'Yuvi',21),(37,'Yuvi',22),(38,'dhoni',22);

/*Table structure for table `province` */

DROP TABLE IF EXISTS `province`;

CREATE TABLE `province` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

/*Data for the table `province` */

insert  into `province`(`id`,`name`) values (34,'Quebec'),(39,'Quebec'),(40,'Quebec'),(41,'Quebec'),(42,'Quebec'),(43,'Quebec'),(44,'Quebec');

/*Table structure for table `provinceagentsdetails` */

DROP TABLE IF EXISTS `provinceagentsdetails`;

CREATE TABLE `provinceagentsdetails` (
  `agent_id` int(15) NOT NULL AUTO_INCREMENT,
  `shopnumber` int(30) NOT NULL,
  `street` varchar(30) NOT NULL,
  `province` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `pincode` varchar(30) NOT NULL,
  PRIMARY KEY (`agent_id`),
  CONSTRAINT `agent_detail` FOREIGN KEY (`agent_id`) REFERENCES `agents` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

/*Data for the table `provinceagentsdetails` */

insert  into `provinceagentsdetails`(`agent_id`,`shopnumber`,`street`,`province`,`country`,`pincode`) values (33,2000,'du fort','quebec','canada','h3h 2n7'),(43,2000,'du fort','quebec','canada','h3h 2n7'),(45,2000,'du fort','quebec','canada','h3h 2n7'),(48,2000,'du fort','quebec','canada','h3h 2n7'),(50,2000,'du fort','quebec','canada','h3h 2n7'),(52,2000,'du fort','quebec','canada','h3h 2n7'),(53,2000,'du fort','quebec','canada','h3h 2n7');

/*Table structure for table `teams` */

DROP TABLE IF EXISTS `teams`;

CREATE TABLE `teams` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `teams` */

insert  into `teams`(`id`,`name`) values (7,'Barcelona'),(8,'India'),(9,'India'),(10,'India'),(11,'India'),(12,'India'),(13,'India'),(14,'India'),(15,'India'),(16,'India'),(17,'India'),(18,'India'),(19,'India'),(20,'India'),(21,'India'),(22,'India');

/*Table structure for table `userdetails` */

DROP TABLE IF EXISTS `userdetails`;

CREATE TABLE `userdetails` (
  `userid` int(30) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `postalcode` varchar(30) DEFAULT NULL,
  `birthday` varchar(30) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `userdetails` */

insert  into `userdetails`(`userid`,`firstname`,`lastname`,`email`,`username`,`password`,`country`,`postalcode`,`birthday`,`gender`) values (1,'saurabh','vohra','s.vohra1991@gmail.com','saurabh','123456','india','H3H2R7','05/11/1991','M');

/*Table structure for table `userinformation` */

DROP TABLE IF EXISTS `userinformation`;

CREATE TABLE `userinformation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `number` varbinary(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Data for the table `userinformation` */

insert  into `userinformation`(`id`,`firstname`,`lastname`,`number`) values (1,'saurabh','vohra','4389934074'),(2,'gaurav','vohra','4389934074'),(3,'tuti','singh','4389934074'),(4,'ram','singh','4389934074'),(5,'sham','singh','4389934074'),(6,'kamal','singh','4389979879'),(7,'deep','singh','438809809'),(8,'hardeep','singh','43887989809'),(9,'hapal','singh','4388790909'),(10,'halal','singh','4388790909'),(11,'gugu','singh','4388790909'),(12,'love','singh','4388790909'),(14,'Ritham','SINGH','4389934074'),(15,'kartar','SINGH','4389934074'),(16,'dildar','SINGH','4389934074'),(17,'satar','SINGH','4389934074'),(18,'lovepreet','SINGH','4389934074'),(19,'sunpreet','SINGH','4389934074'),(20,'ishqpreet','SINGH','4389934074'),(21,'uffpreet','SINGH','4389934074'),(22,'oppsreet','SINGH','4389934074'),(23,'dilpreet','SINGH','4389934074'),(24,'kishpreet','SINGH','4389934074'),(25,'udeypreet','SINGH','4389934074');

/*Table structure for table `web_address` */

DROP TABLE IF EXISTS `web_address`;

CREATE TABLE `web_address` (
  `number` int(30) NOT NULL,
  `street` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `province` varchar(30) NOT NULL,
  `zip` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `propertyItems_id` int(15) NOT NULL,
  KEY `propertyItems` (`propertyItems_id`),
  CONSTRAINT `propertyItems` FOREIGN KEY (`propertyItems_id`) REFERENCES `web_property_items` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `web_address` */

insert  into `web_address`(`number`,`street`,`city`,`province`,`zip`,`country`,`propertyItems_id`) values (214,'De Maisonneuve','Montreal','Quebec','H2H-2N3','Canada',56),(215,'De Maisonneuve','Montreal','Quebec','H2H-2N3','Canada',57),(216,'De Maisonneuve','Montreal','Quebec','H2H-2N3','Canada',58),(217,'De Maisonneuve','Montreal','Quebec','H2H-2N3','Canada',59);

/*Table structure for table `web_c_language` */

DROP TABLE IF EXISTS `web_c_language`;

CREATE TABLE `web_c_language` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `languageName` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `web_c_language` */

insert  into `web_c_language`(`id`,`languageName`) values (3,'french'),(4,'english'),(5,'english'),(6,'french'),(7,'english'),(8,'french'),(9,'french'),(10,'english'),(11,'french'),(12,'english');

/*Table structure for table `web_city_language` */

DROP TABLE IF EXISTS `web_city_language`;

CREATE TABLE `web_city_language` (
  `cities_id` int(15) NOT NULL,
  `languages_id` int(15) NOT NULL,
  PRIMARY KEY (`cities_id`,`languages_id`),
  KEY `fkLanguag` (`languages_id`),
  CONSTRAINT `fkCity` FOREIGN KEY (`cities_id`) REFERENCES `webcity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkLanguag` FOREIGN KEY (`languages_id`) REFERENCES `web_c_language` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `web_city_language` */

insert  into `web_city_language`(`cities_id`,`languages_id`) values (3,3),(4,3),(3,4),(4,4),(5,5),(6,5),(5,6),(6,6),(7,7),(8,7),(7,8),(8,8),(9,9),(10,9),(9,10),(10,10),(11,11),(12,11),(11,12),(12,12);

/*Table structure for table `web_p_language` */

DROP TABLE IF EXISTS `web_p_language`;

CREATE TABLE `web_p_language` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `languageName` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `web_p_language` */

insert  into `web_p_language`(`id`,`languageName`) values (11,'english'),(12,'french'),(13,'english'),(14,'french'),(15,'english'),(16,'french');

/*Table structure for table `web_property` */

DROP TABLE IF EXISTS `web_property`;

CREATE TABLE `web_property` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

/*Data for the table `web_property` */

insert  into `web_property`(`id`,`name`) values (38,'Apartments');

/*Table structure for table `web_property_items` */

DROP TABLE IF EXISTS `web_property_items`;

CREATE TABLE `web_property_items` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `property_type_id` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `property_type` (`property_type_id`),
  CONSTRAINT `property_type` FOREIGN KEY (`property_type_id`) REFERENCES `web_property_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

/*Data for the table `web_property_items` */

insert  into `web_property_items`(`id`,`name`,`property_type_id`) values (56,'apartmentOne',54),(57,'apartmentTwo',54),(58,'apartmentOne',55),(59,'apartmentTwo',55);

/*Table structure for table `web_property_type` */

DROP TABLE IF EXISTS `web_property_type`;

CREATE TABLE `web_property_type` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `property_id` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `property` (`property_id`),
  CONSTRAINT `property` FOREIGN KEY (`property_id`) REFERENCES `web_property` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

/*Data for the table `web_property_type` */

insert  into `web_property_type`(`id`,`name`,`property_id`) values (54,'threeRoomSet',38),(55,'fourRoomSet',38);

/*Table structure for table `web_province_language` */

DROP TABLE IF EXISTS `web_province_language`;

CREATE TABLE `web_province_language` (
  `province_id` int(15) NOT NULL,
  `languages_id` int(15) NOT NULL,
  PRIMARY KEY (`province_id`,`languages_id`),
  KEY `fklanguage` (`languages_id`),
  CONSTRAINT `fkprovince` FOREIGN KEY (`province_id`) REFERENCES `webprovince` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fklanguage` FOREIGN KEY (`languages_id`) REFERENCES `web_p_language` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `web_province_language` */

insert  into `web_province_language`(`province_id`,`languages_id`) values (16,11),(17,11),(17,12),(22,13),(23,13),(23,14),(25,15),(26,15),(26,16);

/*Table structure for table `webcity` */

DROP TABLE IF EXISTS `webcity`;

CREATE TABLE `webcity` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `cityname` varchar(30) NOT NULL,
  `pr_id` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkPvn` (`pr_id`),
  CONSTRAINT `fkPvn` FOREIGN KEY (`pr_id`) REFERENCES `webprovince` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `webcity` */

insert  into `webcity`(`id`,`cityname`,`pr_id`) values (3,'QuebecCity',18),(4,'Montreal',18),(5,'Montreal',19),(6,'QuebecCity',19),(7,'Montreal',20),(8,'QuebecCity',20),(9,'QuebecCity',21),(10,'Montreal',21),(11,'QuebecCity',24),(12,'Montreal',24);

/*Table structure for table `webprovince` */

DROP TABLE IF EXISTS `webprovince`;

CREATE TABLE `webprovince` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `provinceName` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

/*Data for the table `webprovince` */

insert  into `webprovince`(`id`,`provinceName`) values (16,'Alberta'),(17,'Quebec'),(18,'Quebec'),(19,'Quebec'),(20,'Quebec'),(21,'Quebec'),(22,'Alberta'),(23,'Quebec'),(24,'Quebec'),(25,'Alberta'),(26,'Quebec');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
