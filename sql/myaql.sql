create table tb_user(
user_id int auto_increment unique primary key,
user_username VARCHAR(255) unique,
user_password VARCHAR(255)
)

create table tb_userMsg(

user_id int,
user_name VARCHAR(255),
user_sex VARCHAR(255),
user_birth VARCHAR(255),
user_email VARCHAR(255), 
user_memo text
)

create table tb_msg(
msg_id int auto_increment unique primary key,
user_id int,
msg_time VARCHAR(255),
msg_objid int,
msg_addr VARCHAR(255),
msg_owner VARCHAR(255),
msg_zan int,
)

create table tb_obj(

obj_id int auto_increment unique primary key,
obj_name VARCHAR(255),
obj_imageaddr VARCHAR(255),
obj_demo text

)




