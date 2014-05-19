CREATE TABLE `authors` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `biographies` (
  `author_id` int(6) NOT NULL,
  `information` varchar(100) NOT NULL,
  KEY `author_bio` (`author_id`),
  CONSTRAINT `author_bio` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `teams` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE `players` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(20) NOT NULL,
  `team_id` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `player's team` (`team_id`),
  CONSTRAINT `player's team` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
  
CREATE TABLE user_roles (
  user_role_id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  ROLE VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (ROLE,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
  
INSERT INTO users(username,password,enabled)
	VALUES ('arvind','123456', TRUE);
	INSERT INTO users(username,password,enabled)
	VALUES ('shivam','123456', TRUE);
	 
	INSERT INTO user_roles (username, ROLE)
	VALUES ('arvind', 'ROLE_USER');
	INSERT INTO user_roles (username, ROLE)
	VALUES ('arvind', 'ROLE_ADMIN');
	INSERT INTO user_roles (username, ROLE)
	VALUES ('shivam', 'ROLE_USER');