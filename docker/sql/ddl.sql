create database commerce CHARACTER SET utf8;

CREATE USER 'sclee'@'localhost' IDENTIFIED BY 'password!';
CREATE USER 'sclee'@'%' IDENTIFIED BY 'password!';

GRANT ALL PRIVILEGES ON shop.* TO 'sclee'@'localhost';
GRANT ALL PRIVILEGES ON shop.* TO 'sclee'@'%';

use commerce;

create table commerce.category (
    category_id bigint not null primary key,
    name varchar(100)
) character set utf8;

create table commerce.product (
    product_id varchar(50) not null primary key,
    name varchar(100),
    price int,
    detail text
) character set utf8;
