package j19_컬렉션;

import lombok.AllArgsConstructor;
import lombok.Data;

// ctrl shift o 안쓰는것들 정리 
//@NoArgsConstructor  //생성자의 매개변수 없음  기본 생성자
@AllArgsConstructor // 전체 생성자
@Data


//@RequiredArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString

public class Student {
	private String name; // 이름
	private int year; // 학년
	// private final String address;
}
