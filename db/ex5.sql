create table 학생
(
	학번 INT primary key not null,
    이름 VARCHAR(45) not null,
    전공 VARCHAR(45) not null
   
    );
 
 insert into 학생
 values (20013001, '홍길동', '컴퓨터공학과');
  insert into 학생
 values (20013002, '김철수', '전자공학과');
 
 create index STUDENT_CODE_INDEX
 on 학생 (학번);
 
 show index
 from 학생;