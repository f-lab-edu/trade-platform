create database mysql CHARACTER SET utf8;

CREATE USER 'sclee'@'localhost' IDENTIFIED BY 'password!';
CREATE USER 'sclee'@'%' IDENTIFIED BY 'password!';

GRANT ALL PRIVILEGES ON mysql.* TO 'sclee'@'localhost';
GRANT ALL PRIVILEGES ON .* TO 'sclee'@'%';