drop database pm;
create database pm;
use pm;
create table t_user(
	id int primary key auto_increment,
	username varchar(10),
	password varchar(50),
	name varchar(10),
	phone varchar(20),
	regist_date date
)ENGINE=InooDB;
create table t_manager(
	id int primary key auto_increment,
	username varchar(10),
	password varchar(50)
)ENGINE=InooDB;