package j17_스태틱.싱글톤;

public class KIA {
	
	private static KIA instance = null;// 일반적인 싱글톤의 세트 
	
	private KIA() {}  //싱글톤의 특징     생성자가 private

	public static KIA getInstance() { //사실상 getter와 같다 (비어있는지 확인후 생성해서 넣어줌) static이 private으로 잡혀 getter역할을 해줌
		if(instance == null) {  //instance가 비어있는지 확인
			instance = new KIA();//두번은 생성안한다. 어디서나 getinstance를 해도 처음 생성후 생성불가 , 2번째부터는 만들어진 값을 바로 리턴
		}
		return instance;
	}									//여기까지
	
	public void printCompanyName() {
		System.out.println(getClass().getSimpleName());
		
	}
}
