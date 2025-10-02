package study05_extends;

public class DogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog mypet = new Dog("퍼피",5);
		Cat mycat = new Cat("나비",3);
		
		Animal mydog1 = new Dog("코코",3);
		Animal mycat1 = new Cat("타코",5);
		Animal tigerMan = new Tiger("티거",5);
		
//		mypet.foot = 4;
		
		mydog1.makeSound();
		mycat1.makeSound();
		tigerMan.makeSound();
		mydog1.toString();
		
		Dog mypet2 = (Dog)mydog1;
		mypet2.foot = 10;
		
//		mypet.name = "퍼피";
//		System.out.println(mypet.name);
		mypet.showInfo();
		System.out.println(mypet.toString());
		mypet.makeSound();

		System.out.println(mycat.toString());
		mycat.makeSound();
		
		
		
	}
// 참조변수 : id 값(주소값만 갖고 있음)
}
