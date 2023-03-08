package keaunsol;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Study_2023_03_09_Level1_PrimeNumber extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JFrame fr = new JFrame("소수 계산기");
	
	private static JTextArea answer = 
			Study_2023_03_09_Level1_NumberAndResultPanel.answer;
	
	private static StringBuilder sb = 
			Study_2023_03_09_Level1_NumberAndResultPanel.sb;
	
	private static final Study_2023_03_09_Level1_CommonOperating commonOper = 
			new Study_2023_03_09_Level1_CommonOperating();

	private static final Study_2023_03_09_Level1_NumberAndResultPanel numberAndResult = 
			new Study_2023_03_09_Level1_NumberAndResultPanel();

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("확인")) {
			
			if(answer.getText().length() == 0) return;
			
			answer.setText("");
			answer.append((operating() ? "소수입니다." : "소수가 아닙니다."));
			sb.setLength(0);
			Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = true;
			
		}
		
		else if(e.getActionCommand().equals("종료")) {
			
			commonOper.operatingExit(fr);
			
		} 
		
		else if(e.getActionCommand().equals("지우기")) {
			
			commonOper.operatingErase();
	
		}
		
	}
	
	public void returnExpression() {
		
		
    	
		JPanel pn = new JPanel();
    	JPanel pOper = new JPanel();
    	JButton[] btnOper = new JButton[3];
    	
    	BorderLayout fl = new BorderLayout();
    	pn.setLayout(fl);
    	
    	for(int i = 0; i < 3; i++) {
    		
    		btnOper[i] = (i == 0) ? new JButton("확인") :
		    			 (i == 1) ? new JButton("지우기") :
					     		    new JButton("종료");
    		
    		btnOper[i].addActionListener(this);
    		pOper.add(btnOper[i]);
    		
    	}
    	
    	pn.add(numberAndResult.NumberAndResultPanel(), BorderLayout.NORTH);
    	pn.add(answer, BorderLayout.CENTER);
    	pn.add(pOper, BorderLayout.SOUTH);

    	commonOper.operatingFrameSetting(fr, pn);

	}
	
	public static boolean operating() {
	
		long number = Long.parseLong(sb.toString());
	       
		if(number == 1 || number == 0) return false;
		for(long i = 2; i <= Math.sqrt(number); i++) if(number % i == 0) return false;

		return true;
	}
}
