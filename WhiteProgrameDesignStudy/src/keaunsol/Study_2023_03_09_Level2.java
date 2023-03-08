package keaunsol;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Study_2023_03_09_Level2 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static JFrame fr = new JFrame("★★로또★★");
	
	private static Study_2023_03_09_Level1_CommonOperating commonOper = 
			new Study_2023_03_09_Level1_CommonOperating();

	public static void main(String[] args) {
		new Study_2023_03_09_Level2();	
	}
	
	Study_2023_03_09_Level2() {
    	JPanel pn = new JPanel();
    	JPanel pbt = new JPanel();
    	JButton[] pBtn = new JButton[2];
    	
    	BorderLayout fl = new BorderLayout();
    	pn.setLayout(fl);
    	
    	for(int i = 0; i < 2; i++) {
    		
    		pBtn[i] = (i == 0) ? new JButton("랜덤 번호 생성") :
 				     		     new JButton("당첨 확인");
    		
    		pBtn[i].addActionListener(this);
    		pbt.add(pBtn[i]);
    		
    	}
    	
    	pn.add(pbt);

    	commonOper.operatingFrameSetting(fr, pn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String str = e.getActionCommand(); 		
	
		if(str.equals("랜덤 번호 생성")) {
	        
			
        } 
		
		else if(str.equals("당첨 확인")) {
        	
        }
		
	}
}
