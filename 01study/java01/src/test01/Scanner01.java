package test01; //폴더

import java.util.Scanner;

public class Scanner01 {
    public static void main(String[] args) {
        // 숫자 입력
        Scanner scan = new Scanner(System.in);
        System.out.println("숫자를 입력하세요");
        // String strInput = scan.nextLine();
        // String strInput1 = scan.nextLine();
        // System.out.println("입력된 값 : " + strInput + ", " + strInput1);
        // scan.close();

        String strInput1 = scan.nextLine();
        int num1 = Integer.parseInt(strInput1); // 문자를 숫자로 변환
        int num2 = 5;
        System.out.println(num1 + num2);
    }
}
