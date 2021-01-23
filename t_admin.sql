drop table if exists t_admin;

create table t_admin(
	id int not null primary key auto_increment,
	username varchar(50) not null,
	password varchar(50) not null
);

insert into t_admin(username,password) value("admin","123");