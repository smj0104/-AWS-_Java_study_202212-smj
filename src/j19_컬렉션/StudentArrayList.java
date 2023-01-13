package j19_컬렉션;

import java.util.ArrayList;
import java.util.List;

public class StudentArrayList {

	public static void updateYear(List<Student> students, String searchname, int newYear) {

		for (Student student : students) {
			if (student.getName().equals(searchname)) {
				student.setYear(newYear);
				return;
			}
		}

	}

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("김종환", 1));
		students.add(new Student("고병수", 2));
		students.add(new Student("손민재", 3));
		students.add(new Student("황창욱", 4));

		System.out.println(students);

		// System.out.println(students.get(0).getName());
		// 한번의 반복문 안에서 if문을 두번 사용하면 좋지않다
		String searchName = "손민재";

		// length가 아닌 size 사용
		for (Student student : students) {
			student.setYear(4);
		}

		System.out.println(students);
		updateYear(students, "김준일", 1);
		System.out.println(students);
	}

	// 이름이 searchName인 학생을 찾아서 학년을 4학년으로 바꿔라
	// 만약 searchName과 동일한 이름이 없으면 "검색실패" 메세지 출력
}
