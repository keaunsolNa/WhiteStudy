package keaunsol;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	
	public void operatingExitRandom(JFrame fr) {
		
		answer.setText("");
		fr.dispose();
		Study_2023_03_09_Level2 cal = new keaunsol.Study_2023_03_09_Level2();
		
	}
	
	public void operatingErase() {
		
		Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = false;
		answer.setText("");
		
	}
	
	public int operatingAnd(Integer prevNumber) {
		
		System.out.println(sb);
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
		
		return prevNumber;
		
	}

	public void operatingFrameSetting(JFrame fr, JPanel pn) {
		
    	fr.setContentPane(pn);
		fr.setSize(500, 300);
        fr.setVisible(true);
        Dimension frameSize = fr.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        fr.setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
	}
}
