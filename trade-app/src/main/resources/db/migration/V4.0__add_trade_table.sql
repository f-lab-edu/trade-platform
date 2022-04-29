create table TRADE
(
    ID     bigint not null primary key AUTO_INCREMENT,
    USERNAME   varchar(100),
    PRODUCT_ID  bigint,
    STATUS text
) character set utf8;