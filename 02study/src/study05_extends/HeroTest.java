package study05_extends;

public class HeroTest {

	public static void main(String[] args) {
		
		IronMan IronLee = new IronMan("이순신", "슈트",90,80);
		IronLee.showHeroInfo();
		
		Hulk hulkHong = new Hulk("홍길동", "펀치",100, 150);
		hulkHong.showHeroInfo();
		
	}
}
		

