package pky;

import java.io.IOException;
import java.util.Scanner;

public class Study_2023_03_09_Level1_lotto {

	public static void main(String[] args) throws IOException  {
		
		System.out.println("LOTTO를 JOTTO 해보자");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1 ~ 10 사이의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		int lottoNum = (int)((Math.random()*10000)%10);

		if(num <= 0 || num > 10) {
			System.out.println("잘못된 숫자입니다. 다시 실행해주세요.");
		}else {
			System.out.println("당첨번호는 " + lottoNum + "번 입니다.");
			if(num == lottoNum) {
				System.out.println("당첨입니다. 축하드립니다.");
			}else {
				System.out.println("다음 기회를 노려주세요.");
			}
		}
	}
}
