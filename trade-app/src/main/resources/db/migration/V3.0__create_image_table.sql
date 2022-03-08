create table IMAGE
(
    ID          int not null auto_increment primary key,
    PRODUCT_ID  varchar(50),
    IMAGE_PATH  varchar(255),
    UPLOAD_TOME datetime
) character set utf8;