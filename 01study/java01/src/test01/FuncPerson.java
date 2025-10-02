package test01;

public class FuncPerson {

    public static Person creatPerson(String name, int age){
        Person result = new Person(name, age);
        return result;
    }
    public static void main(String[] args) {
        Person p = creatPerson("홍길동", 18);
        System.out.println("이름 : " + p.name + ", 나이 : " + p.age);
        
        Person p1 = creatPerson("홍길동", 18);
        System.out.println("이름 : " + p1.name + ", 나이 : " + p1.age);
    }
}
