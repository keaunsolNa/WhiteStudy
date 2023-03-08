package keaunsol;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Study_2023_03_09_Level3_AES_256 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JFrame fr = new JFrame("AES_256 암호화/복호화 알고리즘");
	private static JTextArea plainText = new JTextArea();
	
	private static String key;
	private static final String IV = "ShVmYq3t6w9y$B&E";
	private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
	
	
	private static JTextArea answer = 
			Study_2023_03_09_Level1_NumberAndResultPanel.answer;
	
	private static final Study_2023_03_09_Level1_CommonOperating commonOper = 
			new Study_2023_03_09_Level1_CommonOperating();
	
	public void returnExpression() {
		
		JPanel pn = new JPanel();
		JPanel pOper = new JPanel();
		
		JButton[] btnOper = new JButton[3];
		
    	BorderLayout fl = new BorderLayout();
    	pn.setLayout(fl);
    	
    	for(int i = 0; i < 3; i++) {
    		
    		btnOper[i] = (i == 0) ? new JButton("암호화") :
    					 (i == 1) ? new JButton("복호화") :
    							    new JButton("뒤로가기");
    		
    		btnOper[i].addActionListener(this);
    		pOper.add(btnOper[i]);
    		
    	}
    	
    	answer.setBackground(Color.black);
    	plainText.setText("");
    	
    	pn.add(pOper, BorderLayout.NORTH);
    	pn.add(plainText, BorderLayout.SOUTH);
    	pn.add(answer, BorderLayout.CENTER);

    	answer.setEditable(false);
    	commonOper.operatingFrameSetting(fr, pn);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getActionCommand().equals("암호화")) {
			
			if(answer.getText().toString().length() != 0) answer.setText("");
			key = JOptionPane.showInputDialog("암호화에 사용할 32byte 키를 입력해주십시오.");
			
			try {
				
				Cipher cipher = Cipher.getInstance(TRANSFORMATION);
				SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
				IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));
				cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
				
		        
		        answer.append(Base64.getEncoder()
		        					.encodeToString(cipher.doFinal(plainText.getText().toString().getBytes(StandardCharsets.UTF_8))));
		        
		        answer.setForeground(Color.WHITE);
		        
			} catch (	NoSuchAlgorithmException 
						| NoSuchPaddingException 
						| InvalidKeyException 
						| InvalidAlgorithmParameterException 
						| IllegalBlockSizeException 
						| BadPaddingException e1) {
				
				e1.printStackTrace();
				
			}
			
			plainText.setText("");
		}
		
		else if(e.getActionCommand().equals("복호화")) {

			if(answer.getText().toString().length() != 0) answer.setText("");

			key = JOptionPane.showInputDialog("복호화 사용할 32byte 키를 입력해주십시오.");
			
			try {
				
				Cipher cipher = Cipher.getInstance(TRANSFORMATION);
				SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
				IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));
				
				cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
				
				answer.append(new String(cipher.doFinal(Base64.getDecoder().decode(plainText.getText().toString())), "UTF-8"));
				answer.setForeground(Color.WHITE);
				
			} catch (	NoSuchAlgorithmException 
						| NoSuchPaddingException 
						| InvalidKeyException 
						| InvalidAlgorithmParameterException 
						| UnsupportedEncodingException 
						| IllegalBlockSizeException 
						| BadPaddingException e1) {

				e1.printStackTrace();
				
			}
					
		}
		
		else if(e.getActionCommand().equals("뒤로가기")) {
			
			commonOper.operatingExitEncryption(fr);
			
		}
		
	}

}
