package study06_test;

public class Member {
	String name;
	int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void showInfo() {
		System.out.println(name + " , " + age);
	}
	
	public void join() {
		System.out.println(name + "님, 회원가입이 완료되었습니다.");
	}
}
