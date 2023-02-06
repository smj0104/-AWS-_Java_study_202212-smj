select @@autocommit;
set autocommit=0;


create table 상품

(

    상품코드 INT primary key auto_increment,

    상품명 VARCHAR(45) not null,

    수량 VARCHAR(45) not null


    );
    
insert into 상품
values(1, '딸기사탕', 50);
insert into 상품
values(2, '누룽지사탕', 100);

start transaction;

insert into 상품
values(0, '오렌지사탕', 20);

commit;
savepoint aa;

update 상품
set
	수량 = 200
where
	상품코드 = 2;
    


delete
from
	상품
where
	상품코드 = 2;

rollback to aa;
commit;

 