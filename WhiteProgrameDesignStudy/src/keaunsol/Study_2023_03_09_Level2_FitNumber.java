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
			
			int[] number = new int[7];
			Set<Integer> set = new HashSet<>();
			
			for(int i = 2; i < btnNumber.length; i++) {
				
				String temp = (btnNumber[i].getText().toString());
				
				if(temp.equals("")) number[i - 2] = -1;
				else number[i - 2] = Integer.parseInt(temp);
				
				set.add(number[i - 2]);
			}
			
			Arrays.sort(number);
			
			for(int i = 0; i < number.length; i++) {
				
				if(number[i] == -1) {
					answer.setText("잘못 입력하거나 빈 칸이 있습니다. ");
					return;
				}
			}
			
			if(set.size() != 7) {
				answer.setText("중복 번호가 존재합니다. ");
				return;
			}
			
			try {
				
				getAnswerNumberArray(Integer.parseInt(btnNumber[1].getText().toString()));
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
			}
			
			boolean bonusCorect = false;
			int isAnswer = 0;
			
			List<Integer> answerList = new ArrayList<>();
			for(int i = 0; i < 6; i++) answerList.add(answerNumber[i]);
					
			for(int j = 0; j < number.length; j++) {
				
				
				if(number[j] == answerNumber[6]) bonusCorect = true;
				
				if(answerList.contains(number[j])) isAnswer++;
				
			}
			
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
	
	public void getAnswerNumberArray(int roundNumber) throws IOException {
		
	    URL url = new URL("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=" + roundNumber);
	    HttpURLConnection conn = null;
	    conn = (HttpURLConnection) url.openConnection();
	    
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Content-Type", "application/json");
	    
	    conn.setDoOutput(true);
	    
	    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String retrunMsg[] = in.readLine().replaceAll("\"|}", "").split(",");
	
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
