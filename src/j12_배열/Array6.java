package j12_배열;
//대입과 해당 인덱스에 넣는것의 차이점 알기
public class Array6 {
	
	public static void main(String[] args) {
		
		String[] names = {"박성진", "조병철", "황창욱"};
		
	
	for(String name : names) { // :이후 배열이나 리스트가 들어간다 names에서 하나 꺼내서 name에 넣음
		System.out.println(name); 
		//name = "김준일"; 불가능함
	}
		
		System.out.println("==========<forEach>==========="); //forEach 특징 : 처음부터 끝까지 하나씩 꺼낸다
		
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]); //꺼내고나면 돌아갈수없음
		}
		
		int nums[] = {1,2,3,4,5};
		
		for(int num : nums) {
			System.out.println("i: " + num);
		}
		
	}

}
