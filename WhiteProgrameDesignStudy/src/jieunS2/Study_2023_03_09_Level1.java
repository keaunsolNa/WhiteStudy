package jieunS2;

import java.util.Scanner;

public class Study_2023_03_09_Level1 {

	public static void main(String[] args)  {
		
		System.out.println("==유저 입력 값으로 계산기(사칙연산, 윤년 등등)==");
		
		//사용자에게 입력 받을 스캐너
		Scanner sc = new Scanner(System.in);
		
		/*
		 * System.out.println("숫자를 입력해 주세요: "); int num1 = sc.nextInt();
		 * 
		 * System.out.println("사용자가 입력한 숫자는 " + num1 + "입니다.");
		 * 
		 * System.out.print("숫자를 입력해주세요: "); int num2 = sc.nextInt();
		 * 
		 * System.out.println("사용자가 두번쨰로 입력한 숫자는 " + num2 +"입니다.");
		 */
		
		
		//숫자 더하기
		System.out.println("==사용자가 입력한 숫자 더하기==");
		//사용자가 입력한 숫자 더하기
		System.out.print("숫자를 입력해주세요: ");
		int num1 = sc.nextInt();
		
		System.out.print("숫자를 한번 더 입력해주세요: ");
		int num2 = sc.nextInt();
		
		System.out.println("사용자가 입력한 숫자 합 구하기1 : " + num1 + num2);			
		System.out.println("사용자가 입력한 숫자 합 구하기2: " + (num1 + num1));		
		System.out.println("사용자가 입력한 숫자 빼기: " + (num1 -  num2)); 			
		
		
		System.out.println("==재밌는 숫자놀이ㅋㅋ==");
		System.out.println("숫자를 입력해주세요: ");
		int a = sc.nextInt();		
		int b = a * 2;				
		int c = sc.nextInt();		
		
		System.out.println("a + c - b의 값은? : " + (a + c - b)); 
		//System.out.println(a+a);
		//System.out.println(a-b);
		//System.out.println(a*b);
		//System.out.println(a/b);
		
		
		System.out.println("==두 수와 연산자 하나를 입력 받아 사칙연산을 해보자1==");
			
		System.out.print("+, -, /, * 중 연산자를 입력해주세요: ");
		String choice = sc.next();
				
		
		/*
		 * next()메소드는 공백(space)전까지 이벽받은 문자열을 반환하는 것
		 * nextLine()메소드는 Enter를 치기 전까지 쓴 문자열 모두 반환하는 것
		 */
		
		if(choice.equals("+, -, / *")) {
			System.out.println("연산자를 입력하지 않았습니다.");
			//연산자를 입력하지 않았을 때 다시 입력 문구로 돌아가고 싶을 때는 어떻게 하는 것이 좋은지?
		}
		
		System.out.print("정수하나를 입력해주세요: ");
		int number1 = sc.nextInt();
		                                                                 
		System.out.print("정수 하나를 한번 더 입력해주세요: ");
		int number2 = sc.nextInt();
		
		//equals는 문자열 비교 사용자가 입력한 연산자(choice)가 "+"와 같은지 확인
		
		if(choice.equals("+") ) {		//사용자가 입력한 연산자가 +와 같다면
			System.out.println("number1 + number2 : " + (number1 + number2));
		} else if(choice.equals("-")) {
			System.out.println("number1 - number2 : " + (number1 - number2));
		} else if(choice.equals("/")) {
			
			//만약 * 선택 후 정수를 0을 선택했을 경우 0입력할 수 없습니다. 멘트 추가 
			// num1 - num2숫자가 계산되지 않아야 함.
			if(number1 == 0 || number2 ==0) {
				System.out.println("0을 입력했습니다.");
			} else {
				
				System.out.println("number1 / number2 :" + (number1 / number2));	
			}
			
		} else if(choice.equals("*")) {
			System.out.println("number1 * number2 : " + (number1 * number2));
		}
		
			System.out.println("문제풀이가 끝났습니다. 감사합니다");
		
		
		
		
	}
}
