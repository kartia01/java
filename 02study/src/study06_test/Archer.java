package study06_test;

public class Archer extends GameCharacter{

	String bowType;
	
	public Archer(String name, int level, int hp, String bowType) {
		super(name, level, hp);
		this.bowType = bowType;
	}
	
	@Override
	public void Attack() {
		System.out.println(name + "은 " + bowType + "을 사용합니다.");
	}

	public void hide() {
		System.out.println(name + "은 은신을 사용합니다.");
	}
}
