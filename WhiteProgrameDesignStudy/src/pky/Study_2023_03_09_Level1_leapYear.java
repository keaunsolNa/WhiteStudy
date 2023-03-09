package pky;

import java.io.IOException;
import java.util.Scanner;

public class Study_2023_03_09_Level1_leapYear {

	public static void main(String[] args) throws IOException  {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("년도를 입력해주세요 : ");
		
		int year = sc.nextInt();
		
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "년은 윤년입니다.");
		}else {
			System.out.println(year + "년은 평년입니다.");
		}
		
	}
}
