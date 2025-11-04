package test01;

import java.util.Scanner;

public class Scanner02 {
    public static void main(String[] args) { // 단축키 : main
        // 두 숫자 더하기
        Scanner scan = new Scanner(System.in); // 단축키 : new
        
        System.out.println("숫자를 입력하세요 :");
        int num1 = scan.nextInt();
        System.out.println("다음 숫자를 입력하세요 :");
        int num2 = scan.nextInt();

        System.out.println("두 수의 합은 : " + (num1 + num2));
    }
}
