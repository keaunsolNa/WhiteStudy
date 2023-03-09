package hhkim;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Study_2023_03_10_Level1_Calculator_leapYear {

	public static void main(String[] args)   {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("원하는 계산기를 선택해 주세요.");
		int choice = sc.nextInt();
		
		if(choice == 1) calCulator();
		else calCulator2();
		
	}
	
	//메소드 1
	public static void calCulator() {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("년도를 입력하세요.");
			int year = sc.nextInt();
			
			if (year % 4 == 0 && year / 100 != 0 || year % 400 == 0) {
				System.out.println("평년/윤년 계산: " + year + "년도는 윤년입니다.");
			}else {
				System.out.println("평년/윤년 계산: " + year + "년도는 윤년이 아닙니다.");
			}
		
			//입력받을 때 숫자를 입력하지 않으면 에러처리할 수 있도록 예외상황 발생
		} catch (Exception e) {
			System.out.println("숫자만 입력해 주세요.");
		}

	}
		
	//메소드 2
	public static void calCulator2() {
		
		try {
			//Scanner 객체 생성
			Scanner sc = new Scanner(System.in);
			
			System.out.println("년도를 입력해 주세요.");
			//스캐너 클래스 안에 있는 nextInt 메소드를 사용, 유저가 입력한 년도를 year 변수에 담는다.
			int year = sc.nextInt();
			
			//gre = GregorianCalendar 클래스의 객체를 생성하여 GregorianCalendar 클래스를 타입으로 가지는 gre 변수 생성
			GregorianCalendar gre = new GregorianCalendar();
			
			//isLeapYear 메소드를 사용하여 윤년/평년 계산
			if(gre.isLeapYear(year)) {
				System.out.println("윤년입니다.");
			}else {
				System.out.println("평년입니다.");
			
			}	 
		
			//입력받을 때 숫자를 입력하지 않으면 에러처리할 수 있도록 예외상황 발생
			}catch (Exception e) {
				System.out.println("숫자만 입력해 주세요.");
			}
	}
		
}