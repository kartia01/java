package study06_test;

public class Mage extends GameCharacter{

	String element;
	public Mage(String name, int level, int hp, String element) {
		super(name, level, hp);
		this.element=element;
	}
	
	@Override
	public void Attack() {
		System.out.println(name + "은 " + element + "을 사용합니다.");
	}

	public void teleport() {
		System.out.println(name + "는 순간이동을 합니다.");
	}
}
