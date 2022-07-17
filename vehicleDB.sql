create database if not exists vehicle;
use vehicle;
drop table if exists vehicle;

create table vehicle (
id int(10) not null auto_increment,
make varchar(15) not null,
model varchar(15) not null,
year int(4) not null,
primary key(id)
);