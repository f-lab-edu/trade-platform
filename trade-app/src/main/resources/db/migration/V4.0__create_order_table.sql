create table ORDERS
(
    ID           bigint not null auto_increment primary key,
    USERNAME     varchar(50),
    PRODUCT_ID   bigint,
    ADDRESS      varchar(50),
    ZIPCODE      varchar(50),
    ORDER_TIME   datetime,
    ORDER_STATUS varchar(50)
) character set utf8;


