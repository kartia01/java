package test01;

public class Functiontest01 {
    public static void sayHello(String name, int year){//매개변수
        System.out.println(name + "님, 안녕하세요!" + year);
    }
    
    public static int add(int a, int b){
        return a + b;
    }

    public static String text(String a){
        return a;
    }

    public static void main(String[] args) {
        sayHello("가",21); //인자
        sayHello("나",21); //인자
        sayHello("다",21); //인자
        sayHello("라",21); //인자

        int result = add(10, 20);
        System.out.println("합은 : " + result);

        String result1 = text("반갑습니다.");
        System.out.println(result1);
    }
}
