package classpart;

public class Student {
	// class : 클래스를 만드는 예약어
	// Student : 클래스 이름
	int studentID; // 학번
	String studentName; // 학생 이름      
	int grade;        // 학년
	String address;  // 사는 곳
	
    // studentID, studentName, grade, address는 Studentd의 매개변수	 
	
	public void showStudentInfo(){
		System.out.println(studentName + "," + address);  //�̸�, �ּ�
	}
	
	public String getStudentName() {
		return studentName;
	}	
	
	public void setStudentName(String name){
		studentName = name;
	}
	
	public static void main(String[] args) {
		Student studentAhn = new Student();
		studentAhn.studentName = "안연수";
		
		System.out.println(studentAhn.studentName);
		System.out.println(studentAhn.getStudentName());
	}
}
