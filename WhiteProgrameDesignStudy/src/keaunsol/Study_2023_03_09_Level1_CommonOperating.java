package keaunsol;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Study_2023_03_09_Level1_CommonOperating {

	private static JTextArea answer = 
			Study_2023_03_09_Level1_NumberAndResultPanel.answer;
	
	private static StringBuilder sb = 
			Study_2023_03_09_Level1_NumberAndResultPanel.sb;
	
	public void operatingExit(JFrame fr) {
		
		Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = false;
		answer.setText("");
		fr.dispose();
		Study_2023_03_09_Level1 cal = new keaunsol.Study_2023_03_09_Level1();
		
	}
	
	public void operatingErase() {
		
		Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = false;
		answer.setText("");
		
	}
	
	public void operatingAnd(Integer prevNumber) {
		
		if(sb.length() == 0) {
			
			answer.setText("");
			answer.append("잘못된 입력입니다.");
			Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = true;
		
		}
		
		else {
			
			answer.append(" AND ");
			prevNumber = Integer.parseInt(sb.toString());
			sb.setLength(0);
		}
		
	}
}
