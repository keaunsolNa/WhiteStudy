package hsy;

import java.util.Scanner;

public class Study_2023_03_09_Level1_intCalculator {

	public static void main(String[] args)  {
		//유저 입력값으로 계산기 (사칙연산, 윤년 등등)

		// 같은 종류(정수와 정수 혹은 실수와 실수)의 데이터 타입을 연산하면 해당 데이터타입이 결과로 나오지만
		// 다른 종류(정수와 실수)의 데이터 타입을 연산하면 데이터 손실이 발생되지 않는 데이터 타입이 결과값으로 나옴
		
		// 산술연산자 + - * / %
		// 수학의 우선순위가 그대로 적용됨 *, /, %가 -보다 먼저 실행
		// 같은 우선순위의 연산자를 여러개 사용할 경우 왼쪽부터 차례대로 실행됨
		
		// Integer형 계산기
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수형 계산기 만들기"); 
		
		System.out.println("integer1: ");
		String num1 = scanner.nextLine();
		
		System.out.println("산술연산자를 입력하세요: ");
		String oper = scanner.nextLine();
		
		System.out.println("integer2: ");
		String num2 = scanner.nextLine();
		
		
		try { // 문자열 입력시 익셉션 처리를 위해 try catch문으로 감싼다.
			
			// 문자열을 기본형 정수로 리턴함
			int number1 = Integer.parseInt(num1);
			int number2 = Integer.parseInt(num2);
			
			int number3;

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
