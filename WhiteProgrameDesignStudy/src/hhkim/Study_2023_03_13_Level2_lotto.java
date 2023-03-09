package hhkim;

import java.util.Arrays;

public class Study_2023_03_13_Level2_lotto {

	public static void main(String[] args) {

		//1. 배열 생성
		int[] num = new int[6]; //추첨 번호 6개를 저장할 배열

		//2. Random 클래스를 이용하여 랜덤 숫자 생성
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 45) + 1; //1부터 45까지 임의의 수를 추출
			for (int j = 0; j < i; j++) { //중복을 체크하기 위한 반복문
				if (num[i] == num[j]) { //중복되는 수가 있으면
					i--; //인덱스를 하나 줄이고 다시 추출
					break;
				}
			}
		}

		//3. 배열 정렬. sort()는 Arrays 클래스 안에 들어있는 함수이며, 배열 요소들을 오름차순으로 정렬하는 메소드이다.
		Arrays.sort(num);

		//4. 결과 출력 (Object 클래스에 있는 toString()메소드는 객체의 상태를 텍스트로 표현해준다.)
		System.out.println("오늘의 당첨 번호: " + Arrays.toString(num));

	}

}