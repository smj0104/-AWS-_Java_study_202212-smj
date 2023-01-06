package j12_배열;
//클린코드 개념 숙지
//코드가 짧다고 좋은코드는 아니다
//응집도는 높고 결합도는 낮게
public class Array5 {
	
	public static void transferArray(int[] oldArray, int[] newArray) { //배열값 옮겨주기
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
										//1,2,3
	public static int[] addArrayLength(int[] array) { //배열크기 늘리기
		int[] newArray = new int[array.length + 1]; //[0,0,0,0]
		transferArray(array, newArray);
		return newArray;
		
		
	}
									//1,2,3
	public static int[] addData(int[] array, int data) {
		int[] newArray = addArrayLength(array);
		newArray[array.length] = data;
		return newArray;
	}
	public static void main(String[] args) { //프로그램의 시작은 항상 main문
		
		int[] nums = new int[0];
		
		nums = addData(nums, 1); //num을 주고 새로추가하고싶은 값을 줌
		nums = addData(nums, 2);
		nums = addData(nums, 3);
		nums = addData(nums, 4);
		nums = addData(nums, 5);
		
		
		//nums = addArrayLength(nums); //기존의 배열을 주면 새로운 배열을 만들어준다
		addData(nums, 1);
		
		for(int i =0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
	}

}
