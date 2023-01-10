package j14_추상;
//클래스 안에 추상 메소드가 하나라도 존재하면 추상클래스 (abstract 달아놓기) 일반클래스랑 똑같은 특징을 지님
public abstract class Transportation { //추상클래스

	
	//추상 메소드 abstract method
	public abstract void go(); //설계만 할뿐 구현은 하지X 

	public abstract void stop(); //메소드에 중괄호가 없다 = 메소드 실행시 행할 명령이 없다(그냥 설계도 상태)

	
}
