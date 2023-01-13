package j18_제네릭;

public class TestData<T, E> {

	private T data1;
	private E data2; //제네릭은 일반자료형 사용불가, 무조건 wrapper class 사용

	public TestData(T data1, E data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	@Override
	public String toString() {
		return "TestData [data1=" + data1 + ", data2=" + data2 + "]";
	}
	
	
}
