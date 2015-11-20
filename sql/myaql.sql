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
  exb_id int,
  user_id int,
  user_name VARCHAR(255),
  msg_time VARCHAR(255),
  msg_addr VARCHAR(255),
  msg_plus int
)

create table tb_exb(
  exb_id int auto_increment unique primary key,
  exb_name VARCHAR(255),
  exb_imageaddr VARCHAR(255),
  exb_demo text
)




