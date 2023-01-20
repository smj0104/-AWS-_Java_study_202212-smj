/*
	DML
    C: insert / into
    R: select / from
    U: update / set
    D: delete / from
*/
	
/*=============<<insert>>================*/

select * from student_mst;

insert into
 `db_study2_explain`.`student_mst`
 (`student_id`, `student_name`)
 values (4, '손지호');
    /* 지정 칼럼에만 값을 넣고 나머지는 null값 부여시 사용*/
    
    select * from student_mst;
    
    insert into student_mst
		(student_id, student_name, mentor_id)
    values
		( 5, 			'이강용',		 10),		/*괄호 단위로 끊어주기,  tab을 줘서 라인을 맞춰줄수도있다 */
		( 6, '김준경', 10),
		( 7, '이현수', 10),
		( 8, '정의현', 10);
        
	insert into university_mst
		(university_id, university_name)
        values
        (4, '동아대'),
        (5, '경북대'),
        (6, '동북대'),
        (7, '경성대');
        
        
	/*============<<update>>===============*/
    
    select * from student_mst;
    
    update student_mst
    set
		student_name = '김재영',
		mentor_id = 15
	where
		student_id = 5;  /* 키값으로 접근하는게 좋다 */
        
        /*멘토 아이디가 10인 학생들의 멘토 아이디를 1로 바꿔라*/
        
	update student_mst    /* edit  preference  sqlEditor safeUpdates 체크해제*/
    set   /*비교*/
		mentor_id = 1
	where /*대입*/
		mentor_id = 10;
        
        
	/*============<<delete>>============*/
    delete
    from
		student_mst
	where
		student_id = 4   /*반드시 key값 사용하기*/
	and student_name = '손지호';
    
    delete
    from
		university_mst
	where  /* where은 key값 */
		university_id = 7
	and university_name = '경성대';
        
	
    
    