ALTER TABLE IMAGE DROP COLUMN PRODUCT_ID;

ALTER TABLE IMAGE CHANGE UPLOAD_TOME UPLOAD_TIME datetime;

ALTER TABLE IMAGE MODIFY ID bigint;

ALTER TABLE PRODUCT ADD COLUMN IMAGE_PATH varchar(100);