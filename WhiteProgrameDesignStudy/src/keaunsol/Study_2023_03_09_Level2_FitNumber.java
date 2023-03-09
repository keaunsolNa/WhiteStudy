package keaunsol;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Study_2023_03_09_Level2_FitNumber  extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private static JFrame fr = new JFrame("로또 번호 생성기");
	private static JTextArea[] btnNumber = new JTextArea[9];
	private static Integer[] answerNumber = new Integer[7];
	
	private static JTextArea answer = 
			Study_2023_03_09_Level1_NumberAndResultPanel.answer;
	
	private static final Study_2023_03_09_Level1_CommonOperating commonOper = 
			new Study_2023_03_09_Level1_CommonOperating();

	public void returnExpression() {
		
		JPanel pn = new JPanel();
		JPanel pInput = new JPanel();
		JPanel pOper = new JPanel();
		
		JButton[] btnOper = new JButton[2];
		
    	BorderLayout fl = new BorderLayout();
    	pn.setLayout(fl);
    	
    	for(int i = 0; i < 2; i++) {
    		
    		btnOper[i] = (i == 0) ? new JButton("확인") 
    							  : new JButton("뒤로가기");
    		
    		btnOper[i].addActionListener(this);
    		pOper.add(btnOper[i]);
    		
    	}
    	
    	btnNumber[0] = new JTextArea(1, 5);
    	btnNumber[0].setEditable(false);
    	btnNumber[0].setText(" 회차와 번호를 입력하세요 : ");
    	
    	btnNumber[1] = new JTextArea(1, 3);
    	
    	pInput.add(btnNumber[0]);
    	pInput.add(btnNumber[1]);
    	
    	for(int i = 2; i < 9; i++) {
    		
    		btnNumber[i] = new JTextArea(1, 3);
    		btnNumber[i].setBackground(Color.YELLOW);
    		pInput.add(btnNumber[i]);
    	}
    	
    	pn.add(pInput, BorderLayout.NORTH);
    	pn.add(pOper, BorderLayout.SOUTH);
    	pn.add(answer, BorderLayout.CENTER);
    	answer.setEditable(false);
    	
    	commonOper.operatingFrameSetting(fr, pn);
    	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("확인")) {

			if(answer.getText().length() != 0) answer.setText("");
			
			if(btnNumber[1].getText().toString().equals("")) {
				answer.setText("회차정보를 입력하세요");
				return;
			}
			
			// 유저가 입력한 숫자를 담기 위한 int 배열
			int[] number = new int[7];
			
			// 중복값 판별을 위한 Set<Integer> 레퍼런스 변수 생성
			Set<Integer> set = new HashSet<>();
			
			for(int i = 2; i < btnNumber.length; i++) {
				
				String temp = (btnNumber[i].getText().toString());
				
				// 공란이 입력값으로 들어올 경우 number 배열에 -1을 임의 할당한다.
				if(temp.equals("")) number[i - 2] = -1;
				else number[i - 2] = Integer.parseInt(temp);
				
				set.add(number[i - 2]);
			}
			
			Arrays.sort(number);
			
			// 잘못 입력한 숫자 판별
			for(int i = 0; i < number.length; i++) {
				
				if(number[i] == -1) {
					answer.setText("잘못 입력하거나 빈 칸이 있습니다. ");
					return;
				}
			}
			
			// 중복 번호 판별
			if(set.size() != 7) {
				answer.setText("중복 번호가 존재합니다. ");
				return;
			}
			
			try {
				
				// 로또 당첨번호를 가져오기 위한 Method 호출
				getAnswerNumberArray(Integer.parseInt(btnNumber[1].getText().toString()));
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
			}
			
			// 보너스 번호 맞춤 여부 판별을 위한 boolean 변수
			boolean bonusCorect = false;
			
			// 맞춘 숫자 누적을 위한 int 변수
			int isAnswer = 0;
			
			// contains method를 통한 탐색을 위해 List<Integer> 레퍼런스 변수 생성
			List<Integer> answerList = new ArrayList<>();
			
			// 받아온 당첨 번호를 List에 할당
			for(int i = 0; i < 6; i++) answerList.add(answerNumber[i]);
					
			for(int j = 0; j < number.length; j++) {
				
				// 보너스 번호 맞출 경우
				if(number[j] == answerNumber[6]) bonusCorect = true;
				
				// 당첨 번호 중 입력 번호가 있을 경우
				if(answerList.contains(number[j])) isAnswer++;
				
			}

			// 맞춘 숫자에 따른 결과값 처리
			if(isAnswer >= 6) answer.setText("1등 당첨! 축하합니다. ");
			else if(isAnswer == 5 && bonusCorect) answer.setText("2등 당첨! 축하합니다.");
			else if(isAnswer == 5) answer.setText("3등 당첨! 축하합니다.");
			else if(isAnswer == 4) answer.setText("4등 당첨! 축하합니다.");
			else if(isAnswer == 3) answer.setText("5등 당첨! 축하합니다.");
			else answer.setText("당첨되지 않았습니다. 유감!");
			
			return;
			
		}
			
		
		else if(e.getActionCommand().equals("뒤로가기")) {
			
			commonOper.operatingExitRandom(fr);
			
		}
		
	}
	
	// 나눔로또 사이트로부터 당첨번호 받아오는 Method
	public void getAnswerNumberArray(int roundNumber) throws IOException {
		
		// 당첨번호를 json 문자열 형태로 알려주는 사이트 url 변수 설정. 회차 정보(roundNumber)에 따라 결과값이 변경된다.
	    URL url = new URL("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=" + roundNumber);
	
	    // NPL 방지용 HttpURLConnection 빈 객체 생성
	    HttpURLConnection conn = null;
	    
	    // connection 객체 열기
	    conn = (HttpURLConnection) url.openConnection();
	    
	    // Get 방식의, json 방식 통신
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Content-Type", "application/json");
	    
	    // REST API 방식으로 통신한다.
	    conn.setDoOutput(true);
	    
	    // 결과값을 받기 위한 BufferedReader 레퍼런스 변수 생성
	    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    
	    // 결과값은 json 문자열이기에 적절히 replaceAll 이후 배열로 변환한다.
	    String retrunMsg[] = in.readLine().replaceAll("\"|}", "").split(",");
	
	    // 결과값 번호를 static 배열 변수에 할당하는 반복문
	    for(String string : retrunMsg) {
	    	
	    	String key = string.split(":")[0];
	    	String value = string.split(":")[1];
	    	
	    	if(key.equals("drwtNo1")) answerNumber[0] = Integer.parseInt(value);
	    	else if(key.equals("drwtNo2")) answerNumber[1] = Integer.parseInt(value);
	    	else if(key.equals("drwtNo3")) answerNumber[2] = Integer.parseInt(value);
	    	else if(key.equals("drwtNo4")) answerNumber[3] = Integer.parseInt(value);
	    	else if(key.equals("drwtNo5")) answerNumber[4] = Integer.parseInt(value);
	    	else if(key.equals("drwtNo6")) answerNumber[5] = Integer.parseInt(value);
	    	else if(key.equals("bnusNo")) answerNumber[6] = Integer.parseInt(value);
	    	
		}
			
	}
	
}
