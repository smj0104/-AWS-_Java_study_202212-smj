insert into 학생
values (1, '김춘식');
insert into 학생
values(2, '손흥민');

insert into 과목
values (1, '컴퓨터 구조');
insert into 과목
values (2, '데이터베이스');
insert into 과목
values (3, '인공지능');

insert into 성적
values (1, 1, 1, 95);
insert into 성적
values (2, 2, 1, 84);
insert into 성적
values (3, 1, 2, 89);
insert into 성적
values (4, 2, 2, 92);
insert into 성적
values (5, 1, 3, 100);
insert into 성적
values (6, 2, 3, 88);

select
	c.순번,
    c.학번,
    a.이름,
    c.과목번호,
    b.과목이름,
    c.점수
from 성적 as c
left join 과목 as b
on c.과목번호 = b.과목번호
left join 학생 as a
on c.학번 = a.학번
where
	c.과목번호 = 1 or c.과목번호 = 2;


