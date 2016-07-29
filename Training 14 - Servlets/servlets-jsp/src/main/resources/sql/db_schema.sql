create database if not exists jsp;
use jsp;


create table if not exists user(
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL,
    password VARCHAR(10) NOT NULL
);