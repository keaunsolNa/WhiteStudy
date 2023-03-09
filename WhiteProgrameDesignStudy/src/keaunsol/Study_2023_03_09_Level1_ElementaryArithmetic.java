package keaunsol;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Study_2023_03_09_Level1_ElementaryArithmetic extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JFrame fr = new JFrame("사칙연산 계산기");
	
	private static JTextArea answer = 
			Study_2023_03_09_Level1_NumberAndResultPanel.answer;
	
	private static StringBuilder sb = 
			Study_2023_03_09_Level1_NumberAndResultPanel.sb;
	
	private static Study_2023_03_09_Level1_CommonOperating commonOper = 
			new Study_2023_03_09_Level1_CommonOperating();
	
	private static Study_2023_03_09_Level1_NumberAndResultPanel numberAndResult = 
			new Study_2023_03_09_Level1_NumberAndResultPanel();
	
	// ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("연산")) {
			
			// 입력값이 없을 경우 Return
			if(answer.getText().length() == 0) return;
			
			// 기존 입력값 초기화
			answer.setText("");
			
			// 유저 입력값으로 사칙연산을 수행한 결과값을 int 변수에 할당
			long ans = operating(sb.toString());
			
			// ArithmeticException 시 결과창에 출력
			if(answer.getText().equals("0")) answer.setText("0으로 나눌 수 없습니다. ");
				
			// 결과창에 값 출력
			else answer.append("답은 " + ans + " 입니다.");
			
			// StringBuilder 객체 값 초기화
			sb.setLength(0);
			
			// 연산 중으로 패키지 전역 변수 값 초기화
			Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = true;
			
		}
		
		else if(e.getActionCommand().equals("종료")) {
			
			// JFrame 종료 Method
			commonOper.operatingExit(fr);
			
		} 
		
		else if(e.getActionCommand().equals("지우기")) {
			
			// 결과 창 지워주는 Method
			commonOper.operatingErase();
			
		}
		
		// 유저가 연산이 아닌 숫자와 연산자를 눌렀을 때
		else {
			
			// 이전 연산내역이 있을 경우
			if(Study_2023_03_09_Level1_NumberAndResultPanel.isOpering) {
				
				// answer 초기화
				answer.setText("");
				
				// 전역 변수 false로 초기화
				Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = false;
				
			}
			
			// 유저 입력값의 최신값 가져오기
			char temp = sb.charAt(sb.length() - 1);
			
			// 연산자 두 번 이상 연속 입력
			if(temp == '+' || temp == '-' || temp == '*' || temp == '/') {
				
				answer.setText("올바르지 않은 연산입니다. 재 실행 부탁드립니다. ");
				Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = true;
				sb.setLength(0);
				
			}
			
			else {
				
				answer.append(" " + e.getActionCommand() +" ");
				sb.append(e.getActionCommand());
				
			}
			
		}
	}
	
	public void returnExpression() {
		
    	JPanel pn = new JPanel();
    	JPanel pOper = new JPanel();
    	JButton[] btnOper = new JButton[7];
    	
    	BorderLayout fl = new BorderLayout();
    	pn.setLayout(fl);
    	
    	for(int i = 0; i < 7; i++) {
    		
    		btnOper[i] = (i == 0) ? new JButton("+") :
    				     (i == 1) ? new JButton("-") :
					     (i == 2) ? new JButton("*") :
				    	 (i == 3) ? new JButton("/") :
			    		 (i == 4) ? new JButton("연산") :
		    			 (i == 5) ? new JButton("지우기") :
					     		    new JButton("종료");
    		
    		btnOper[i].addActionListener(this);
    		pOper.add(btnOper[i]);
    		
    	}
    	
    	pn.add(numberAndResult.NumberAndResultPanel(), BorderLayout.NORTH);
    	pn.add(answer, BorderLayout.CENTER);
    	pn.add(pOper, BorderLayout.SOUTH);

    	commonOper.operatingFrameSetting(fr, pn);
	}
    
	// 재귀 형태로 연산 수행하는 Method
	public static long operating(String input) {
		
		// + 연산이 수행되는 곳 index 값
		int idx = input.indexOf('+');
		
		// + 연산이 하나라도 있을 경우 재귀 수행
		if (idx != -1) return operating(input.substring(0, idx)) + operating(input.substring(idx + 1)); 
		
		else { 
			
			idx = input.indexOf('-'); 
			
			if (idx != -1) return operating(input.substring(0, idx)) - operating(input.substring(idx + 1)); 
			
			else {
				
				idx = input.indexOf('*'); 
				if (idx != -1) return operating(input.substring(0, idx)) * operating(input.substring(idx + 1)); 
				 
				else { 
					
					idx = input.indexOf('/'); 
					
					try {
						
						if (idx != -1) return operating(input.substring(0, idx)) / operating(input.substring(idx + 1));
						
					} catch( java.lang.ArithmeticException e) {
						
						answer.append("0");
						return 0;
					}
					
				} 
			} 
		}
		
		// 공백 제거
		String data = input.trim();
		if (data == null || data.isEmpty()) return 0;
		
		return Long.parseLong(data); 
	}
}
