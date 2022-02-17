create database commerce CHARACTER SET utf8;

CREATE USER 'sclee'@'localhost' IDENTIFIED BY 'password!';
CREATE USER 'sclee'@'%' IDENTIFIED BY 'password!';

GRANT ALL PRIVILEGES ON commerce.* TO 'sclee'@'localhost';
GRANT ALL PRIVILEGES ON commerce.* TO 'sclee'@'%';