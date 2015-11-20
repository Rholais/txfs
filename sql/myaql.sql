create table tb_user(
user_id int auto_increment unique primary key,
user_username varchar(255) unique,
user_password varchar(255)
)

create table tb_userMsg(

user_id int,
user_name varchar(255),
user_sex varchar(255),
user_birth varchar(255),
user_memo text
)

create table tb_msg(
msg_id int auto_increment unique primary key,
user_id int,
msg_time varchar(255),
msg_objid int,
msg_addr varchar(255),
msg_owner varchar(255),
msg_zan int,
)

create table tb_obj(

obj_id int auto_increment unique primary key,
obj_name varchar(255),
obj_imageaddr varchar(255),
obj_demo text

)




