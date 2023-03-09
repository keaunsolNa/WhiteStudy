package keaunsol;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Study_2023_03_09_Level1_LCM extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JFrame fr = new JFrame("최소 공배수 계산기");
	
	private static JTextArea answer = 
			Study_2023_03_09_Level1_NumberAndResultPanel.answer;
	
	private static StringBuilder sb = 
			Study_2023_03_09_Level1_NumberAndResultPanel.sb;
	
	private static Study_2023_03_09_Level1_CommonOperating commonOper = 
			new Study_2023_03_09_Level1_CommonOperating();
	
	private static Study_2023_03_09_Level1_NumberAndResultPanel numberAndResult = 
			new Study_2023_03_09_Level1_NumberAndResultPanel();
	
	private static Integer prevNumber;
	private static Integer nextNumber;
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("확인")) {
			
			if(answer.getText().length() == 0) return;
			
			if(sb.length() == 0) {
				
				answer.setText("");
				answer.append("잘못된 입력입니다.");
				Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = true;
				return;
				
			}
			
			nextNumber = Integer.parseInt(sb.toString());
			answer.setText("");

			if(prevNumber == null) answer.append("잘못된 입력입니다.");
			
			else answer.append("최소 공배수는 " + operating(prevNumber, nextNumber) + " 입니다.");
			
			sb.setLength(0);
			Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = true;
			
		}
		
		else if(e.getActionCommand().equals("종료")) {
			
			commonOper.operatingExit(fr);
			
		} 
		
		else if(e.getActionCommand().equals("지우기")) {
			
			commonOper.operatingErase();
			
		}
		
		else if(e.getActionCommand().equals("AND")) {
			
			prevNumber = commonOper.operatingAnd(prevNumber);
			
		}
		
	}
	
	public void returnExpression() {
		
		JPanel pn = new JPanel();
    	JPanel pOper = new JPanel();
    	JButton[] btnOper = new JButton[4];
    	
    	BorderLayout fl = new BorderLayout();
    	pn.setLayout(fl);
    	
    	for(int i = 0; i < 4; i++) {
    		
    		btnOper[i] = (i == 0) ? new JButton("확인") :
    					 (i == 1) ? new JButton("AND") :
		    			 (i == 2) ? new JButton("지우기") :
					     		    new JButton("종료");
    		
    		btnOper[i].addActionListener(this);
    		pOper.add(btnOper[i]);
    		
    	}
    	
    	pn.add(numberAndResult.NumberAndResultPanel(), BorderLayout.NORTH);
    	pn.add(answer, BorderLayout.CENTER);
    	pn.add(pOper, BorderLayout.SOUTH);

    	commonOper.operatingFrameSetting(fr, pn);
	}
	
	// 최대공약수를 이용한 최소공배수 유클리드 호제법 알고리즘
	private static long operating(long num1, long num2) {

		long gcd = Study_2023_03_09_Level1_GCD.operating(num1, num2);
		return (num1 * num2 / gcd);
		
	}
	
}
