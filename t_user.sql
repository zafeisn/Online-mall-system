drop table if exists t_user;

create table t_user(
	cid varchar(50) not null primary key,
	username varchar(20) not null,
	password varchar(30) not null,
	phone varchar(20) not null
);
