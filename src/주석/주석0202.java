package 주석;

public class 주석0202 {
/*https://code-lab1.tistory.com/51
 *트랜잭션 : dml에서 사용하며 작업의 일부만 적용되지 않게 한다 (작업을 모두 한번에 처리하거나 모두 처리하지않음)
 * 원자성 : 하나의 단위로 묶여있어야함
 * 독립성 : 트랜잭션은 독립적으로 작동 하나가 작업을 마칠때까지 다른 트랜잭션을 참조할 수 없음 
 * 
 * 워크벤치 오토커밋(자동으로 커밋)
 * 
 * 커밋 이전에 롤백이 일어나야한다
 * 
 * if(청구기호 = '','기호없음', 청구기호) as 청구기호 /* 삼항 연산자  청구기호의 값이 비었으면 기호없음 출력 있으면 청구기호 표시
 *
 *   case
		when 발행연도 is null then '2050'
        when 발행연도 = '' then '2090'
	end as 발행연도,
	if(ifnull(발행연도, '') = '', '2023', 발행연도) as 발행연도2, 앞에 값이 null이면 바꿔줌
    nullif(발행연도, '')) as 발행연도3,    두개의 값 (발행연도, 공백)을 비교해 null이면 공백으로 바꿈
    if(청구기호 = '','기호없음', 청구기호) as 청구기호                                               		삼항 연산자  청구기호의 값이 비었으면 기호없음 출력 있으면 청구기호 표시
from
	db_study3.library_mst;
where
	발행연도 like '20_6';             _ == 와일드카드           % == 여러개를 의미
	
	
	
	show index from product_mst; 해당 테이블의 인덱스 조회법
	
	
	create index product_id on product_mst(product_code); 

show index from product_mst;

alter table product_mst
add unique product_names(product_name);

alter table product_mst
drop index product_id1;
	
	
	
	java의 삼항연산자가 sql에서는 if로 사용
	ifnull = if문에서 null인지 체크 
	
	ifnull(발행연도, '2051') as 발행연도2, =발행연도가 null 이면 2051로 바꿔라
	
	
	
	Python 0202
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 */ 
	
	
}
