package j01_출력;

public class FactoryName {
	private static FactoryName instance = null;

	private FactoryName() {
	}

	public static FactoryName getInstance() {
		if (instance == null) {
			instance = new FactoryName();
		}
		return instance;
	}

}