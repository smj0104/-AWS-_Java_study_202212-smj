package j18_제네릭;

public class TestData<T> {

	private String data1;
	private T data2; //제네릭은 일반자료형 사용불가, 무조건 wrapper class 사용

	public TestData(String data1, T data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	@Override
	public String toString() {
		return "TestData [data1=" + data1 + ", data2=" + data2 + "]";
	}
	
	
}
