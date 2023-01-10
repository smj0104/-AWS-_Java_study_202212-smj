package j13_상속;

public class Car {
	private String company; //상속은 했는데 통장 비번 안알려준셈
	private String model;
	private int price;

	
	public Car() {
		System.out.println("부모");
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	public int discountPrice(int percentage) {
		return price - (price * percentage / 100);
	}
}
