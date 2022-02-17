use commerce;

truncate table category;
truncate table product;

insert into category values (1, '전자제품');
insert into category values (2, '필기구');

insert into product values (1, '라즈베리파이3 모델B', 56000, '모델B');
insert into product values (2, '어프로치 휴대용 화이트보드 세트', 11920, '화이트보드');
insert into product values (3, '볼펜 겸용 터치펜', 9000, '볼펜과 터치펜을 하나로!');