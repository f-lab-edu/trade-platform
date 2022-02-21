CREATE USER 'sclee'@'localhost' IDENTIFIED BY 'password!';
CREATE USER 'sclee'@'%' IDENTIFIED BY 'password!';

GRANT ALL PRIVILEGES ON mysql.* TO 'sclee'@'localhost';
GRANT ALL PRIVILEGES ON mysql.* TO 'sclee'@'%';
use mysql

create table ACCOUNT (
    ID   bigint not null primary key AUTO_INCREMENT,
    USERNAME varchar(100),
    EMAIL varchar(100),
    PASSWORD varchar(100)
) character set utf8;