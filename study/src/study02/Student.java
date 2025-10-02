package study02;

public class Student {
	//멤버변수를 생성
	int studentId;
	String studentname;
	String address;
	
	public Student() {}
	
	//method
	public void showInfo() {
		System.out.println(studentname + ", " + address);
	}
	
}
