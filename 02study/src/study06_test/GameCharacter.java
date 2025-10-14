package study06_test;

public class GameCharacter {
	String name;
	int level;
	int hp;
	
	public GameCharacter(String name, int level, int hp) {
		this.name = name;
		this.level = level;
		this.hp = hp;
	}
	
	public void ShowInfo() {
		System.out.println("직업은 " + name + "이고, " + level + "레벨이며, 현재 hp는 " + hp + "입니다" );
	}
	
	public void Attack() {
		System.out.println(name);
	}
}

