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

public class Study_2023_03_09_Level1_GCD extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JFrame fr = new JFrame("최대 공약수 계산기");
	
	private static JTextArea answer = 
			Study_2023_03_09_Level1_NumberAndResultPanel.answer;
	
	private static StringBuilder sb = 
			Study_2023_03_09_Level1_NumberAndResultPanel.sb;
	
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
			
			else answer.append("최대 공약수는 " + operating(prevNumber, nextNumber) + " 입니다.");
			
			sb.setLength(0);
			Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = true;
			
		}
		
		else if(e.getActionCommand().equals("종료")) {
			
			Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = false;
			answer.setText("");
			fr.dispose();
			Study_2023_03_09_Level1 cal = new keaunsol.Study_2023_03_09_Level1();
			
		} 
		
		else if(e.getActionCommand().equals("지우기")) {
			
			Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = false;
			answer.setText("");
			
		}
		
		else if(e.getActionCommand().equals("AND")) {
			
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
	
	public void returnExpression() {
		
		Study_2023_03_09_Level1_NumberAndResultPanel numberAndResult = new Study_2023_03_09_Level1_NumberAndResultPanel();
    	
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

    	fr.setContentPane(pn);
        fr.setSize(500, 300);
        fr.setVisible(true);
        Dimension frameSize = fr.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        fr.setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static long operating(long num1, long num2) {
	
		if(num2 == 0) return num1;
		
		else return operating(num2, num1 % num2);
		
	}
}
