drop database ums;
create database ums charset=utf8;
use ums;
create table t_user(
	id int primary key auto_increment,
	username varchar(10),
	password varchar(50),
	name varchar(10),
	phone varchar(20),
	regist_date date
)ENGINE=InnoDB;
create table t_manager(
	id int primary key auto_increment,
	username varchar(10),
	password varchar(50)
)ENGINE=InnoDB;

insert into t_manager 
	(username,password)
values
	('admin','ISMvKXpXpadDiUoOSoAfww==');
commit;
