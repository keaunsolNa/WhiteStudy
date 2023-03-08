package hhkim;

import java.util.Scanner;


public class Study_2023_03_09_Level1_Calculator_case {

	public static void main(String[] args)   {
		
		//스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 수를 입력하세요.");
		//1.스캐너로 입력받은 정수를 저장 
		double num1 = sc.nextInt();
		
		//3.사칙연산을 입력하기
		System.out.println("사칙연산을 입력해주세요.");
		String str = sc.next();
		//3.스캐너로 입력받은 정수를 저장
		
		System.out.println("두번째 수를 입력하세요.");
		double num2 = sc.nextInt();
     
		switch (str) {
		case "+": 
			System.out.println((num1 + num2));
			break;
		case "-": 
			System.out.println((num1 - num2));
			break;
		case "*": 
			System.out.println((num1 * num2));
			break;
		case "/": 
			System.out.println((num1 / num2));
			break;
		
		}
	}
}