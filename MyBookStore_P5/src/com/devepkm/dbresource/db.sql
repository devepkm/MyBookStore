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


create table book(
	`id` int(11) primary key auto_increment,
	`name` varchar(50) not null,
	`author` varchar(50) not null,
	`price` decimal(11,2) not null,
	`sales` int(11) not null,
	`stock` int(11) not null,
	`img_path` varchar(200) not null
);


insert into book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`)
values(null , 'java从入门到放弃' , '国哥' , 80 , 9999 , 9 , 'static/img/default.jpg');

insert into book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`)
values(null , '数据结构与算法' , '严敏君' , 78.5 , 6 , 13 , 'static/img/default.jpg');

insert into book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`)
values(null , '怎样拐跑别人的媳妇' , '龙伍' , 68, 99999 , 52 , 'static/img/default.jpg');