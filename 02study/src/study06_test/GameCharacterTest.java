package study06_test;

public class GameCharacterTest {

	public static void main(String[] args) {
		GameCharacter w = new Warrior("전사", 20, 50, "검");
		GameCharacter m = new Mage("마법사", 15, 60, "원소");
		GameCharacter a = new Archer("궁수",10, 40, "활");
		
		w.ShowInfo();
		m.ShowInfo();
		a.ShowInfo();
		
		w.Attack();
		m.Attack();
		a.Attack();
		
		Warrior s1 = (Warrior) w;
		s1.defend();
		
		Mage s2 = (Mage) m;
		s2.teleport();
		
		Archer s3 = (Archer) a;
		s3.hide();
	}

}
