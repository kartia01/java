package study02;

public class DeskLamp{
	private boolean isOn; //private : 접근 제어자 boolean :true or false
	String color;
	
//	public DeskLamp() {}

	public void turnOn() {
		isOn = true;
	}
	
	public void turnOff() {
		isOn = false;
	}
	
//	@Override
//	public String toString() {
//		return "DeskLamp [isOn=" + isOn + ", color=" + color + "]";
//	}
	
	public String toString() {
		return "현상태는 " + ((isOn==true)?"켜짐":"꺼짐");
	}
	
//toString : 객체를 문자열로 표현하여 반환
	
//	(isOn==true + "켜짐")
}
