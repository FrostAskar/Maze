DROP DATABASE IF EXISTS maze;
CREATE DATABASE maze;
USE maze;

DROP TABLE IF EXISTS winners;
CREATE TABLE winners(
    id int PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100),
	coins int,
	time time;
);
