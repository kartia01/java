package study06_override;

public class Cat extends Animal{
	
	String color;

	public Cat(String name, int age,String color) {
		super(name, age);
		this.color = color;
	}
	
	public void scratch() {
		System.out.println(name + "이 할퀴기 시작합니다.");
	}

	@Override
	public void makeSound() {
		System.out.println(name + "이(가) 야옹 소리를 냅니다.");
	}

}
