#删除数据库
DROP DATABASE IF EXISTS subentry01;
#创建数据库并为其设置字符集
CREATE DATABASE subentry01 DEFAULT CHARACTER SET utf8;
#使用数据库
USE subentry01;
#删除数据表
DROP TABLE IF EXISTS `user`;
#创建数据表
CREATE TABLE IF NOT EXISTS `user`(
	`id` INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(255) NOT NULL,
	`userpwd` VARCHAR(255) NOT NULL
);




#查询所有
SELECT * FROM `user`;
#添加用户信息
INSERT INTO `user`(id,username,userpwd)VALUES(2,'jreey','123');
#根据ID查询
SELECT * FROM `user` WHERE id=1; 
#根据ID查询修改用户信息
UPDATE `user` SET username='tom',userpwd='123456' WHERE id=1;
#根据ID删除
DELETE FROM `user` WHERE id=2;
