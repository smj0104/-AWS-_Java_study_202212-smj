select
	*
from
	library_mst
where
	저작자 in('최인철 지음', '채사장 지음');
	/*도서명 like '%나를%';   앞뒤로 뭐가 와도 상관없음*/ 
    
    /*====================<<select insert>>======================*/
    
insert into author_mst
	(author_name)
select distinct
	저작자
from
	library_mst
order by
	저작자;

select * from author_mst;


insert into publisher_mst
	(publisher_name)
select distinct
	출판사
from
	library_mst
order by
	출판사;

select * from publisher_mst;

/*====================<<select update>>====================*/

/*update library_mst lm
set lm.저작자 = (select
					am.author_id
				from
					author_mst am
				where
					am.author_name = lm.저작자);
  */                  
update library_mst, author_mst
set
	저작자 = author_id
where
	저작자 = author_name;
    
update library_mst, publisher_mst
set
	출판사 = publisher_id
where
	출판사 = publisher_name;
    
select
	*
from
	library_mst lm
	left outer join author_mst am on(am.author_id = lm.저작자)
    left outer join publisher_mst pm on(pm.publisher_id = lm.출판사);
    
/*=========================================*/

select
	도서관명,
    도서명
from  /* 1번으로 동작*/
	library_mst lm
    left outer join author_mst am on(am.author_id = lm.저작자)
where
	am.author_name like '%김주%';
    
    show profiles;

/* author_name like '%김주%'
	or author_name like '%김민');

/*'김주'가 들어간 저작자 있을시 도서관, 책 나오도록*/
set profiling = 1;
set profiling_history_size = 30;


    
    

