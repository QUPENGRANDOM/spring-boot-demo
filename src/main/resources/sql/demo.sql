DROP DATABASE IF EXISTS demo;

CREATE DATABASE demo;

USE demo;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 NOT NULL,
  `address` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `mail` varchar(50) CHARACTER SET utf8 NOT NULL,
  `role` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=innoDB DEFAULT CHARSET=utf8;
