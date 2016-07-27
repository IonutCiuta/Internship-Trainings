create database if not exists JPA;
use JPA;


create table if not exists department(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100)
);

create table if not exists employee (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100),
	salary LONG,
	dept_id INT,
	street varchar(100),
	city varchar(100),
	state varchar(100),
	zip_code varchar(10),
	birthday TIMESTAMP,
	FOREIGN KEY(dept_id) REFERENCES department(id) ON DELETE CASCADE
);

create table if not exists project (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name varchar(100),
	project_manager varchar(100),
	description varchar(500)
);