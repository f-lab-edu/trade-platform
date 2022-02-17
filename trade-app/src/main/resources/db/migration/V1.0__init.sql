use commerce;

create table commerce.category (
    id bigint not null primary key AUTO_INCREMENT,
    name varchar(100)
) character set utf8;

create table commerce.product (
    id bigint not null primary key AUTO_INCREMENT,
    name varchar(100),
    price int,
    detail text
) character set utf8;