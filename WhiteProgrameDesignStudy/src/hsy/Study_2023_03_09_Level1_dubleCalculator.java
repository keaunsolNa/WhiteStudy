package hsy;

import java.util.Scanner;

public class Study_2023_03_09_Level1_dubleCalculator {
	public static void main (String[] args) {
		// Double형 계산기
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("실수형 계산기 만들기");
		
		System.out.println("double1:");
		String num1 = scanner.nextLine();
		
		System.out.println("산술연산자를 입력하세요:");
		String oper = scanner.nextLine();
		
		System.out.println("double2:");
		String num2 = scanner.nextLine();
		
		
		try {
			
			// 문자열을 기본형 정수로 리턴함
			double number1 = Double.parseDouble(num1);
			double number2 = Double.parseDouble(num2);
			
			
			double number3;

			if (oper.equals("+")) {
				number3 = number1 + number2; 
				
			} else if (oper.equals("-")) {
				number3 = number1 - number2; 
				
			} else if (oper.equals("*")) {
				number3 = number1 * number2; 
				
			} else {
				number3 = number1 / number2; 
			} 
			
			
			System.out.println(number1 + oper + number2 + " = " + number3);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
	}
}
