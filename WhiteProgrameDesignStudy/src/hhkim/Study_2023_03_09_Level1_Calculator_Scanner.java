package hhkim;

import java.util.Scanner;


public class Study_2023_03_09_Level1_Calculator_Scanner {

	public static void main(String[] args)   {
		
		//스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 수를 입력하세요.");
		//1.스캐너로 입력받은 정수를 저장 
		double num1 = sc.nextInt();
		
		//2.스캐너로 입력받은 정수를 저장
		System.out.println("두번째 수를 입력하세요.");
		double num2 = sc.nextInt();
     
		//1.더하기
		System.out.println("더하기 :" + (int)(num1 + num2) );
		//2.빼기
		System.out.println("빼기 :" + (int)(num1 - num2) );
		//3.곱하기
		System.out.println("곱하기 :" + (int)(num1 * num2) );
		//4.나누기
		System.out.println("나누기 :" + (num1 / num2) );
		
	}
}
