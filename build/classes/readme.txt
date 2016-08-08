1 导包
	mysql-jar
	jstl+standard.jar
	dbutils
	···


2 建库

建库： create database PrivilegeSystem

用户表：
create table user(
id varchar(40) primary key,
username varchar(100) not null,
password varchar(100) not null
);

角色表：
create table role(
id varchar(40) primary key,
name varchar(100) not null,
description varchar(255)
);


权限表：
create table privilege(
id varchar(40) primary key,
name varchar(100) not null,
description varchar(255)
);



角色权限表：

> create table role_privilege(
> role_id varchar(40),
> privilege_id varchar(40),
> primary key(role_id,privilege_id),
> constraint role_id_FK foreign key(role_id) references role(id),
> constraint privilege_id_FK foreign key(privilege_id) references privilege(id)
> );


用户角色表：
 create table user_role(
 user_id varchar(40),
 role_id varchar(40),
 primary key(user_id,role_id),
 constraint user_id_FK foreign key(user_id) references user(id),
 constraint role_id_FK1 foreign key(role_id) references role(id)
 );

 
3 。DAO层的实现