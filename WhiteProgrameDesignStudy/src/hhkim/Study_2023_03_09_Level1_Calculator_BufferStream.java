package hhkim;

import java.io.BufferedReader; //임포트 필수로 사용
import java.io.IOException; // 예외처리 필수로 해줘야 함. 또는 try~catch문 사용. 그러나 전자가 보통 많이 쓰임.
import java.io.InputStreamReader;


public class Study_2023_03_09_Level1_Calculator_BufferStream {

	public static void main(String[] args) throws IOException  {
		
		//입출력스트림 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
        System.out.println("첫 번째 수를 입력하세요: ");
        
        //입출력스트림 객체를 생성하면 타입이 string으로 고정되므로 강제형변환 실시
        //readline 함수는 한 줄만 읽을 수 있음.
        double num1 = Integer.parseInt(br.readLine());
        
        System.out.println("두 번째 수를 입력하세요: ");
        //나누기 시 0이 반환되므로 double을 사용하여 소수점까지 표시될 수 있도록 구현
        double num2 = Integer.parseInt(br.readLine());
        
		//1.더하기
        //정수로 나올 수 있게 int로 형변환 실시
		System.out.println("더하기 :" + (int)(num1 + num2) );
		//2.빼기
		System.out.println("빼기 :" + (int)(num1 - num2) );
		//3.곱하기
		System.out.println("곱하기 :" + (int)(num1 * num2) );
		//4.나누기
		System.out.println("나누기 :" + (num1 / num2) );

     
	}
}
