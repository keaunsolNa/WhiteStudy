package keaunsol;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Study_2023_03_09_Level3 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JFrame fr = new JFrame("암호화 알고리즘");
	
	private static Study_2023_03_09_Level1_CommonOperating commonOper = 
			new Study_2023_03_09_Level1_CommonOperating();
	
	public static void main(String[] args) {
		new Study_2023_03_09_Level3();	
	}
	
	Study_2023_03_09_Level3() {
		
    	JPanel pn = new JPanel();
    	JPanel pbt = new JPanel();
    	JButton[] pBtn = new JButton[3];
    	
    	BorderLayout fl = new BorderLayout();
    	pn.setLayout(fl);
    	
    	for(int i = 0; i < 3; i++) {
    		
    		pBtn[i] = (i == 0) ? new JButton("SHA-256") :
 				     		     new JButton("DES");
    		
    		pBtn[i].addActionListener(this);
    		pbt.add(pBtn[i]);
    		
    	}
    	
    	pn.add(pbt);
    	
    	commonOper.operatingFrameSetting(fr, pn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = e.getActionCommand(); 			
	
		if(str.equals("SHA-256")) {
			
			Study_2023_03_09_Level3_SHA_256 sha_256 = 
					new Study_2023_03_09_Level3_SHA_256();
			
			sha_256.returnExpression();
			fr.dispose();
			
        } 
		
		else if(str.equals("AES-256")) {
        	
			Study_2023_03_09_Level3_AES_256 aes_256 = 
					new Study_2023_03_09_Level3_AES_256();
			
			aes_256.returnExpression();
			fr.dispose();
        }
		
	}

}
