package pky;

import java.io.IOException;
import java.util.Scanner;

public class Study_2023_03_09_Level1 {

	public static void main(String[] args) throws IOException  {
		
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * 
		 * String num = br.readLine(); //String System.out.println("숫자를 입력하세요: "); int i
		 * = Integer.parseInt(br.readLine()); //Int int j =
		 * Integer.parseInt(br.readLine()); //Int
		 */		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사칙연산자를 고르세요 : ");
		String s = sc.nextLine();
		
		System.out.print("숫자1을 입력해 주소서 : ");
		int n1 = sc.nextInt();
		
		System.out.print("숫자2를 입력해 주소서 : ");
		int n2 = sc.nextInt();
		
		switch (s) {
			case "+":
				System.out.println(n1 + n2);
				break;
			case "-":
				System.out.println(n1 - n2);
				break;
			case "*":
				System.out.println(n1 * n2);
				break;
			case "/":
				System.out.println(n1 / n2);
				break;
		}
	}
}
