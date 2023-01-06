package j12_배열;
// 선형탐색 알고리즘 알아보기
import java.util.Random;

public class Array3 {
	
	public static void main(String[] args) {
		 
		Random random = new Random();
		
		int[] nums = new int[10];
		
		for(int i = 0; i < nums.length; i++) {
			while(true) { //무한루프 시작
				boolean findFlag = true;
				
				int randomNum = random.nextInt(nums.length) + 1; // randomNum은 배열의 칸수(10)+1만큼 무작위 숫자를 받음
				
				for(int j = 0; j < nums.length; j++) {
					if(nums[j] == randomNum) { 
						findFlag = false;
						break; //안의 for문을 멈추는 break
					}
				}
				
				if (findFlag) {  // findFlag == true
					nums[i] = randomNum; 
					break; //while을 멈추는 break   이 변수가 true일때 break실행
				}
			}
		}
		
		
		for(int i = 0; i < nums.length; i++ ) {
			System.out.println(nums[i]);
		}
		
	//	System.out.println(random.nextInt(10)); //범위 0 ~ 9 까지
		
		//로또번호 만들기
		
		
	}
	

	
}
