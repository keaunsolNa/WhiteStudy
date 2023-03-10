package keaunsol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Study_2023_03_10_Level4  {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder upperLine = new StringBuilder();
	private static StringBuilder middleLine = new StringBuilder();
	private static StringBuilder downLine = new StringBuilder();
	private static StringBuilder map;
	
	// 중복 입력 방지를 위한 boolean 배열
	private static boolean[] pressMap = new boolean[9];
	
	// 우승자 판별을 위한 int 배열
	private static int[] winningMap = new int[9];
	
	// 컴퓨터 입력값을 받기 위한 Random static class
	private static Random random = new Random();
	
	public static void main(String[] args) throws IOException {
		
		// 무한 반복
		while(true) {
			
			// 시작 전 초기화
			map = new StringBuilder();
			upperLine.setLength(0);;
			middleLine.setLength(0);;
			downLine.setLength(0);;
			pressMap = new boolean[9];
			winningMap = new int[9];
			
			// 최초의 스도쿠 맵
			map.append("\t   <★★★ 틱택토 게임 ★★★> \n\n");
			upperLine.append("\t\t_|_|_\n");
			middleLine.append("\t\t_|_|_\n");
			downLine.append("\t\t | | \n\n");
			
			// 초기화
			for(int i = 0; i < 9; i++) winningMap[i] = 0;
			
			// 위, 중간, 아래 줄을 하나의 맵으로 합친다.
			map.append(upperLine).append(middleLine).append(downLine);
			
			System.out.println("스도쿠 게임입니다.");
			System.out.println("원하시는 모드를 선택하세요");
			System.out.println("1 :  VS 인간");
			System.out.println("2 :  VS 컴퓨터");
			System.out.println("3 :  게임 종료");
			
			String input = br.readLine();
			
			if(input.equals("1") || input.contains("인간")) {
				
				man();
			}
			
			else if(input.equals("2") || input.contains("컴퓨터")) {
				
				computer();
				
			} else if(input.equals("3") || input.contains("게임 종료")) {
				
				System.out.println("안녕히 가세요~");
				System.exit(0);
				
			} else {
				
				System.out.println("잘못된 입력입니다.");
				System.out.println();
				continue;
			}
			 
			System.out.println("LOOP END 이후");
			System.out.println(map);
		}
		
	}
	
	// 사람 VS 사람 method
	public static void man() throws IOException {
		
		// 플레이어 번호 변수
		int player = 1;
		
		// 승리 판별 여부 변수
		int winChk = 0;
		
		// 무한 반복
		while(true) {

			boolean exit = true;
			// 모든 칸이 채워졌으면 무승부
			for(int i = 0; i < pressMap.length; i++ ) if(pressMap[i] == false && winningMap[i] == 0) exit = false;
				
			if(exit) {
				System.out.println("무승부!");
				return;
			}
			
			System.out.println(map);
			System.out.println("PLAYER " + player + " 차례입니다.");

			System.out.println();
			choiseAndPress(player, 1);
			System.out.println();
			
			// 맵 초기화
			map.setLength(0);
			map.append(upperLine).append(middleLine).append(downLine);

			// 이후 승리 판별
			winChk = winningChk();

			// 승리했다면 승리자 번호 출력
			if(winChk != 0) {
				System.out.println(map);
				System.out.println("PLAYER " + winChk + " 승리! 축하합니다.");
				System.out.println();

				return;
			}
			
			// loop 단위로 player 변경
			player = (player == 1) ? 2 : 1;
			
			
		}
	}
	
	// 번호를 그리고 맵을 그리는 method
	public static void choiseAndPress(int player, int comOrHuman) throws IOException {

		// 중복 선택 판별 변수
		boolean chk = false;
		
		// 초기값 위한 변수
		String number ="";
		
		// 유저의 선택 번호
		int choise = -1;
		
		// 화면에 그려질 기호
		char XO = ' ';
		
		// 유저일 경우 br로 입력을 받는다.
		if(comOrHuman == 1) {
			
			while(!chk) {
				
				System.out.println("1 ~ 9 중 원하는 숫자를 눌러 표시하세요");
				
				number = br.readLine();
				
				// 입력값은 1 - 9 사이의 숫자로만 정규식
				if(!number.matches("[1-9]")) {
					System.out.println(" 1 ~ 9 사이의 숫자로만 입력 해 주세요");
					continue;
				}
				
				
				// 플레이어에 따른 기호 판별
				XO = (player == 1) ? 'X' : 'O';
				
				
				// boolean 배열 변수의 해당 칸을 true로 체크
				if(!pressMap[Integer.parseInt(number) - 1]) chk = true;
				
				else System.out.println("이미 입력된 칸입니다.");
				
			}
			choise = Integer.parseInt(number);
		}
		
		// 컴퓨터일 때는 입력을 받지 않는다.
		else {
			
			while(!chk) {
					
				// 1 ~ 9 사이의 번호로 랜덤 번호 (추후 알고리즘 고민)
				choise = random.nextInt(9) + 1;
				
				XO = 'O';
				
				if(!pressMap[choise - 1]) chk = true;
				
			}
			
			
		}
		
		// 입력 값에 따른 StringBuilder 객체 초기화
		switch(choise) {
			
			case 1 : 
			case 2 : 
			case 3 : 
				
				upperLine.setCharAt(choise * 2, XO);
				break;
				
			case 4 :
			case 5 : 
			case 6 :
				
				middleLine.setCharAt((choise - 3) * 2, XO);
				break;
				
			case 7 : 
			case 8 : 
			case 9 : 
				
				downLine.setCharAt((choise - 6) * 2, XO);
				
		}
		
		pressMap[choise - 1] = true;
		winningMap[choise - 1] = player;
		
	}
	
	public static void computer() throws IOException {
		
		int player = 1;
		int winChk = 0;
		while(true) {
			
			boolean exit = true;
			for(int i = 0; i < pressMap.length; i++ ) if(pressMap[i] == false && winningMap[i] == 0) exit = false;
			
			if(exit) {
				System.out.println("무승부!");
				return;
			}
			
			System.out.println(map);
			
			if(player == 1) {
				
				System.out.println("PLAYER의 차례입니다.");
				
			} else System.out.println("COMPUTER의 차례입니다.");

			System.out.println();
			choiseAndPress(player, player);
			System.out.println();
			
			map.setLength(0);
			map.append(upperLine).append(middleLine).append(downLine);
			
			winChk = winningChk();
			
			if(winChk != 0) {
				
				if(winChk == 2) {
					
					System.out.println(map);
					System.out.println("COMPUYER 승리!");
					System.out.println();
				} 
				
				else {
					
					System.out.println(map);
					System.out.println("PLAYER " + winChk + " 승리! 축하합니다.");
					System.out.println();
				}
				
				return;
				
			}
			
			player = (player == 1) ? 2 : 1;
			
		}
		
	}

	// 승리 판별 Method
	public static int winningChk() {
		
		// 1 - 2 - 3 동일
		if(winningMap[0] != 0
				&& (winningMap[0] == winningMap[1] 
				&& winningMap[0] == winningMap[2])) 
				
			return winningMap[0];

		// 3 - 4 - 5 동일
		if(winningMap[3] != 0
				&& (winningMap[3] == winningMap[4] 
				&& winningMap[3] == winningMap[5])) 
			
			return winningMap[3];			
		
		// 6 - 7 - 8 동일
		if(winningMap[6] != 0
				&& (winningMap[6] == winningMap[7] 
						&& winningMap[6] == winningMap[8])) 
			
			return winningMap[6];			
		
		// 1 - 5 - 9 동일
		if(winningMap[0] != 0
				&& (winningMap[0] == winningMap[4] 
						&& winningMap[0] == winningMap[8])) 
			
			return winningMap[0];			
		
		// 3 - 5 - 7 동일
		if(winningMap[2] != 0
				&& (winningMap[2] == winningMap[4] 
						&& winningMap[2] == winningMap[6])) 
			
			return winningMap[2];			
		
		// 1 - 4- 7 동일
		if(winningMap[0] != 0
				&& (winningMap[0] == winningMap[3] 
						&& winningMap[0] == winningMap[6])) 
			
			return winningMap[0];			
		
		// 2 - 5 - 8 동일
		if(winningMap[1] != 0
				&& (winningMap[1] == winningMap[4] 
						&& winningMap[1] == winningMap[7])) 
			
			return winningMap[1];			
		
		// 3 - 6 - 9 동일
		if(winningMap[2] != 0
				&& (winningMap[2] == winningMap[5] 
						&& winningMap[2] == winningMap[8])) 
			
			return winningMap[2];			

		return 0;
	}
}
