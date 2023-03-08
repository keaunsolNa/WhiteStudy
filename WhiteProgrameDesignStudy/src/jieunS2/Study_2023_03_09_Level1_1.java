package jieunS2;

import java.util.Scanner;

public class Study_2023_03_09_Level1_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* if ~ else 문으로 사칙연산한 문제를 switch문으로 변경  */
		
		System.out.println("==두 수와 연산자 하나를 입력 받아 사칙연산을 해보자2==");
		
		System.out.print("+, -, /, * 중 연산자를 입력해주세요: ");
		String choice = sc.next();
		
		System.out.print("정수하나를 입력해주세요: ");
		int num1 = sc.nextInt();
		
		System.out.print("정수 하나를 한번 더 입력해주세요: ");
		int num2 = sc.nextInt();
		
		
		switch (choice) {
		case "+": 
			System.out.println("num1 + num2 : " + (num1 + num2));
			
			break;
			
		case "-":
			System.out.println("num1 - num2 : " + (num1 - num2));
			
			break;
		
		case "/":
			
			if(num1 == 0 || num2 ==0) {
				System.out.println("0을 입력했습니다.");
			}else {
				System.out.println("num1 / num2 : " + (num1 / num2));
			}
			break;
			
		case "*":
			System.out.println("num1 * num2 : " + (num1 * num2));
			
			break;
			
				
			
		}
	}
}
