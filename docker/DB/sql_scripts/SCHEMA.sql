CREATE DATABASE  IF NOT EXISTS `guilddb`;
USE `guilddb`;

CREATE TABLE IF NOT EXISTS wow_character (
	ID      bigint not null auto_increment,
	last_modified timestamp not null,
	name varchar(255) collate utf8_bin,
	realm varchar(255),
	classe tinyint,
	race tinyint,
	gender tinyint,
	level  tinyint unsigned default 1,
	achievement int unsigned default 0,
	thumbnail varchar(255),
	honorable_kill bigint unsigned default 0,
	rating_2v2 int default 0,
	rating_3v3 int default 0,
    rating_5v5 int default 0,
	rating_RBG int default 0,
constraint pk_computer primary key (id));



