package keaunsol;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Study_2023_03_09_Level3_SHA_256 extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static JFrame fr = new JFrame("SHA_256 암호화 알고리즘");
	private static JTextArea plainText = new JTextArea();
	
	private static JTextArea answer = 
			Study_2023_03_09_Level1_NumberAndResultPanel.answer;
	
	private static final Study_2023_03_09_Level1_CommonOperating commonOper = 
			new Study_2023_03_09_Level1_CommonOperating();
	
	public void returnExpression() {

		JPanel pn = new JPanel();
		JPanel pOper = new JPanel();
		
		JButton[] btnOper = new JButton[2];
		
    	BorderLayout fl = new BorderLayout();
    	pn.setLayout(fl);
    	
    	for(int i = 0; i < 2; i++) {
    		
    		btnOper[i] = (i == 0) ? new JButton("암호화") 
    							  : new JButton("뒤로가기");
    		
    		btnOper[i].addActionListener(this);
    		pOper.add(btnOper[i]);
    		
    	}
    	
    	answer.setBackground(Color.black);
    	plainText.setText("");
    	
    	pn.add(pOper, BorderLayout.NORTH);
    	pn.add(plainText, BorderLayout.CENTER);
    	pn.add(answer, BorderLayout.SOUTH);
    	answer.setEditable(false);
    	
    	commonOper.operatingFrameSetting(fr, pn);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("암호화")) {
			
			try {
				
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(plainText.toString().getBytes());
				byte[] data = md.digest();
				
				for (byte b : data) {
					
					answer.append(String.format("%02x", b));
					
					answer.setForeground(Color.WHITE);
				}
				
			} catch (NoSuchAlgorithmException e1) {
				
				e1.printStackTrace();
				
			}
			
		}
		
		else if(e.getActionCommand().equals("뒤로가기")) {
			
			commonOper.operatingExitEncryption(fr);
			
		}
	}
	
}
