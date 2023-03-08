package keaunsol;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("연산")) {
			
			if(answer.getText().length() == 0) return;
			
			answer.setText("");
			answer.append("답은 " + operating(sb.toString()) + " 입니다.");
			sb.setLength(0);
			Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = true;
			
		}
		
		else if(e.getActionCommand().equals("종료")) {
			
			commonOper.operatingExit(fr);

			
		} 
		
		else if(e.getActionCommand().equals("지우기")) {
			
			commonOper.operatingErase();
			
		}
		
		else {
			
			if(Study_2023_03_09_Level1_NumberAndResultPanel.isOpering) {
				
				answer.setText("");
				Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = false;
				
			}
			
			char temp = sb.charAt(sb.length() - 1);
			
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
    
	public static int operating(String input) {
		
		int idx = input.indexOf('+');
		
		if (idx != -1) return operating(input.substring(0, idx)) + operating(input.substring(idx + 1)); 
		
		else { 
			
			idx = input.indexOf('-'); 
			
			if (idx != -1) return operating(input.substring(0, idx)) - operating(input.substring(idx + 1)); 
			
			else {
				
				idx = input.indexOf('*'); 
				if (idx != -1) return operating(input.substring(0, idx)) * operating(input.substring(idx + 1)); 
				 
				else { 
					
					idx = input.indexOf('/'); 
					if (idx != -1) return operating(input.substring(0, idx)) / operating(input.substring(idx + 1));
					
				} 
			} 
		}
		
		String data = input.trim();
		if (data == null || data.isEmpty()) return 0;
		
		return Integer.parseInt(data); 
	}
}
