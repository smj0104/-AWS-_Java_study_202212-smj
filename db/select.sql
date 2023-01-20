/*=======================<<select>>======================*/

select * from student_mst;

/*전체 칼럼 조회 (test code시에만 사용) */
select
	*
from
	student_mst;
    
/*지정 컬럼 조회*/
select
	student_id,
    student_name,
    mentor_id
from
	student_mst;
    
/* 임시 컬럼 추가 */
select
	1 as num,
    '김준일' as name;
    
select
	student_id,
    student_name,
	'김준일' as instructor_name
from
	student_mst;
    
/* 컬럼명을 임시로 바꾸는 방법 as(alias) 알리아스*/
select
	sm.student_id as studentId /*나중에 자바에서 카멜표기법으로 변수와 매칭해줘야한다*/
from
	student_mst sm;  /* 보통 테이블명을 생략*/
    
/* 조회조건 where */
select  /* 쿼리의 실행순서 from -> where -> select*/
	*
from	
	student_mst
where  /* 서브쿼리 (타당한 이유가 있을때만 사용할것)*/
	mentor_id = (select
					mentor_id
				from
					mentor_mst
				where
					mentor_name = '문자영');
    
select  /*멘토 아이디를 뽑아와라*/
	mentor_id = s
from 
	mentor_mst
where
	mentor_name = '문자영';
    
select
	student_id,
    student_name,
    mentor_id,
    (select
		mentor_name
	from
		mentor_mst
    where
		mentor_id = student_mst.mentor_id) as mentor_name
from
	student_mst;
    
/* 그룹으로 묶어서 조회하기*/

select
	count(mentor_id),
    min(student_id),
    max(student_id),
    avg(student_id),
    sum(student_id),
	mentor_id
from
	student_mst
group by  
	mentor_id;


/* 그룹으로 조회한 결과에 조건주는 방법*/
select
	count(mentor_id) as mentor_count,
    min(student_id),
    max(student_id),
    avg(student_id),
    sum(student_id),
	mentor_id
from
	student_mst
group by  
	mentor_id
having
	mentor_count = 5;


/* 정렬 */
select
	*
from
	student_mst
order by
	mentor_id desc,
	student_id desc;

    
/* 중복 제거 */
select distinct
	mentor_id
from
	student_mst;
    
/* 전체 조합 실습 */
select
	count(*) as student_count,
    mentor_id
from
	student_mst
where
	student_id > 2
group by 
	mentor_id
having  /* group by로 묶은것들중에서 조건*/
	student_count = 1
order by
	mentor_id desc;
    
    
    