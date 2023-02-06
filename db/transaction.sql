show variables like 'AUTOCOMMIT';
set autocommit = 0;

start transaction;

savepoint sp2; /* 지금부터 저장하겠다*/

insert into user_mst
values (0, 'qqq', '1234', '김준일', 'aqqc@gail.com');

select * from user_mst;

rollback to sp2;

commit;