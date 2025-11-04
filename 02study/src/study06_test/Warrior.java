package study06_test;

public class Warrior extends GameCharacter{

    String weapon;
    
	public Warrior(String name, int level, int hp, String weapon) {
		super(name, level, hp);
		this.weapon = weapon;
	}
	
	
	
	@Override
	public void Attack() {
		System.out.println(name + "는 " + weapon + "을 사용합니다.");
	}

	public void defend() {
		System.out.println(name + "은 방패를 사용합니다.");
	}
}
