package study09_interface;

public abstract class Calcurator implements Calc{
// implements : 상속, 구현한다

	@Override
	public int add(int num1, int num2) {
		// 형 = type
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1 - num2;
	}
}