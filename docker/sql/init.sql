use commerce;

truncate table category;
truncate table product;

insert into category values (1001, '전자제품');
insert into category values (2001, '필기구');

insert into product values ('prod-001', '라즈베리파이3 모델B', 56000, '모델B');
insert into product values ('prod-002', '어프로치 휴대용 화이트보드 세트', 11920, '화이트보드');
insert into product values ('prod-003', '볼펜 겸용 터치펜', 9000, '볼펜과 터치펜을 하나로!');