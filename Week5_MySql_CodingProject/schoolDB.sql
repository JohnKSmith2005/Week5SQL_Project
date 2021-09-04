create database if not exists school;
use school;
drop table if exists students;

create table students (
	id int(10) not null auto_increment,
    first_name varchar(25) not null,
    last_name varchar(25) not null, 
	grade varchar(1) not null,
    primary key(id)
);