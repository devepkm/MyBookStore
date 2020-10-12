create database bookstore;
use book;

create table user (
`id` int primary key auto_increment,
`username` varchar (20) not null unique ,
`password` varchar (20) not null ,
`email` varchar (50)
);

insert into user(username, password, email) values ('admin','admin','admin@devepkm.com');
insert into user(username, password, email) values ('test','test','test@devepkm.com');

select * from user;


