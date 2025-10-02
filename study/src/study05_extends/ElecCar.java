package study05_extends;

public class ElecCar extends Car{
	int battery;
	
//	public ElecCar(int speed, String eName, int battery) {
//		super(speed);
//		this.eName = eName;
//		this.battery = battery;
//	}
	
	public ElecCar(int speed, String name, int battery) {
		super(speed, name); // super : 부모 클래스
		this.battery = battery;
	}

	public void charge(int amount) {
		battery += amount;
	}

	@Override
	public String toString() {
		return "ElecCar [battery=" + battery + ", speed=" + speed + ", name=" + name + "]";
	}
}
