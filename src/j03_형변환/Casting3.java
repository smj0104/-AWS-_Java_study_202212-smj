package j03_형변환;

public class Casting3 {

	public static void main(String[] args) {
		
		 double kor = 87.5;
		 double eng = 95.7;
		 double math = 80.5;
		 
		 int total = (int)kor + (int)eng + (int)math;
		 double avg = total / 3.0; //묵시적 형변환이 이루어짐
		 
		 System.out.println("합계: " + total);
		 System.out.println("평균: " + avg);
		 
	}

}
