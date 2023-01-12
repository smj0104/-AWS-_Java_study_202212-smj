package j17_스태틱;

import java.time.LocalDate;
import java.util.Date;

public class Car {
	                                     // .now() .getyear()같이 .이 붙은것은 static0
	private static final int NOW_YEAR = LocalDate.now().getYear();// 해당년도 집어넣기 new Date().getYear()

	private static final String CODE = "KIA" + NOW_YEAR + "-";
	private static int num = 0;

	private String serialCode; // KIA-2023-0000
	private String modelName;

	public Car(String car) {               //4데시멀  %는 앞에 공간4개를 만들어두겠다(0개 표현) num은 이 숫자를 표현하겠다
 		serialCode = CODE + String.format("%04d", num);  //결과가 string으로 나옴
		num++;
		this.modelName = car;
	}

	@Override
	public String toString() {
		return "Car [serialCode=" + serialCode + ", modelName=" + modelName + "]";
	}

}
