package study04;

public class HeroTest {
	public static void main(String[] args) {
		String[] ironman = {"레이저","미사일", "비행"};
		String[] thor = {"소환","번개", "망치"};
		String[] hulk = {"펀치","도약", "날리기"};
		String[] spiderman = {"거미줄","벽타기", "초감각"};		
		
		Hero hero1 = new Hero("아이언맨", "하이테크슈트",90,80,ironman);
		Hero hero2 = new Hero("토르", "번개",100,90);
		Hero hero3 = new Hero("헐크", "주먹",150,150,hulk);
		Hero hero4 = new Hero("스파이더맨", "거미줄",70,50,spiderman);
		
		hero1.showHeroInfo();
		hero2.showHeroInfo();
		hero3.showHeroInfo();
		hero4.showHeroInfo();
		}
	}

