alter table PRODUCT change ID PRODUCT_ID bigint AUTO_INCREMENT;
alter table CATEGORY change ID CATEGORY_ID bigint AUTO_INCREMENT;

create table PRODUCT_CATEGORY
(
    PRODUCT_ID bigint not null,
    CATEGORY_ID bigint not null,
    constraint primary key (product_id, category_id)
)