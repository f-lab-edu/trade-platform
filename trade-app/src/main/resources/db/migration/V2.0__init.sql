create table CATEGORY
(
    ID   bigint not null primary key AUTO_INCREMENT,
    NAME varchar(100)
) character set utf8;

create table PRODUCT
(
    ID     bigint not null primary key AUTO_INCREMENT,
    NAME   varchar(100),
    PRICE  int,
    DETAIL text
) character set utf8;

create table ACCOUNT
(
    ID       bigint not null primary key AUTO_INCREMENT,
    USERNAME varchar(100),
    EMAIL    varchar(100),
    PASSWORD varchar(100)
)