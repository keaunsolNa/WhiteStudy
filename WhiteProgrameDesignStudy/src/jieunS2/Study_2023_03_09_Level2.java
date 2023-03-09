package jieunS2;

public class Study_2023_03_09_Level2 {

	public static void main(String[] args) {

		/* 랜덤 수를 만들어서 복권 생성 및 정답 확인 */
		
		/*
		 * Math.rambom()함수를 사용해서 랜덤 7자리?를 만들고
		 * 정답이랑 맞는지 확인하기 
		 * 
		 * 정답은 내가 지정한 숫자
		 * 1057회차 1등인 8, 13, 19, 27, 40, 45, 12
		 */
		int num1 = 1;
		
		//렌덤 수
		for(int i = 1; i <=7; i++) {
			num1 = (int) (Math.random() * 50);  //num1 = Math.random() * 7; 타입이 안맞기 때문에 int라고 명시
			System.out.println(num1);
		}
		
		//lotto 당첨 번호 확인
		//String lotto = "8, 13, 19, 27, 40, 45, 12";	//이것은 문자열이라 형변환이 필요할듯 함
		//배열 사용해보자 
		System.out.println("당첨 번호 확인하기");
		//당첨 번호를 어케 확인하면 좋을까요??? 랜덤한 숫자와 정답과 ....
		
		
				
		
		
		
	}

}
