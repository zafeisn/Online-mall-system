drop table if exists t_category;

create table t_category(
	cid int(50) not null primary key auto_increment,
	cname varchar(50)
);

insert into t_category(cname) value("电脑办公");
insert into t_category(cname) value("家具家居");
insert into t_category(cname) value("鲜果时光");
insert into t_category(cname) value("图书音像");
insert into t_category(cname) value("母婴孕婴");