package study08_abstract;

public class DeskTop extends Computer{
	
	@Override
//	부모에 있는 메소드를 사용하거나 변경시킨다.
	public void turnOff() {
	System.out.println("DeskTop을 끕니다.");	
	}
	
	@Override
//	부모에 있는 메소드를 사용하거나 변경시킨다.
	public void turnOn() {
		
	}
//	implement : 구현하다

	@Override
	public void display() {
		
	}
	
	public void han() {}
}
