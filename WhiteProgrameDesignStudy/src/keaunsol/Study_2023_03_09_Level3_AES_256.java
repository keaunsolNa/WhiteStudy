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

/*
 * AES-256 알고리즘은 암호화 / 복호화에 동일한 고정키를 사용하는 대칭 키 알고리즘이다.
 * SPN(Substitution - Permutation Network) 구조를 이용한다.
 */
public class Study_2023_03_09_Level3_AES_256 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JFrame fr = new JFrame("AES_256 암호화/복호화 알고리즘");
	
	// 유저 입력값(평문, 암호문) 
	private static JTextArea plainText = new JTextArea();
	
	// 암호화에 필요한 Key static 변수
	private static String key;
	
	// 초기화용 벡터를 지정한다.
	private static final String IV = "ShVmYq3t6w9y$B&E";
	
	// 변환 알고리즘 
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
			
			// JOptionPane 클래스의 showInputDialog method로 받은 입력값을 암호화의 공개키로 할당한다.
			key = JOptionPane.showInputDialog("암호화에 사용할 32byte 키를 입력해주십시오.");
			
			try {

				// Cipher 암호화 알고리즘 레퍼런스 변수 생성
				Cipher cipher = Cipher.getInstance(TRANSFORMATION);
				
				// 암호화 알고리즘은 AES로 지정한다.
				SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
				
				// static 변수로 선언 및 초기화 한 IV 변수의 값으로 IvParameterSpec 클래스의 초기화 벡터를 지정한다.
				IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));
				
				// Cipher 객체의 init method로 암호화 타입, 암호화 키, 초기화 벡터를 매개변수로 cipher 암호키 레퍼런스 객체를 초기화한다.
				cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
				
		        // 정답란에 암호화 된 입력값을 할당
		        answer.append(Base64.getEncoder()
		        					.encodeToString(cipher.doFinal(plainText.getText().toString().getBytes(StandardCharsets.UTF_8))));
		        
		        // 정답란 텍스트 색상 변경
		        answer.setForeground(Color.WHITE);
		        
		        // 예외 처리.
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
		
		
		// AES 복호화 알고리즘
		else if(e.getActionCommand().equals("복호화")) {

			if(answer.getText().toString().length() != 0) answer.setText("");

			// 복호화에 사용할 Key 값 할당
			key = JOptionPane.showInputDialog("복호화 사용할 32byte 키를 입력해주십시오.");
			
			try {
				
				// AES-256은 암호화 - 복호화가 역순이다. 
				Cipher cipher = Cipher.getInstance(TRANSFORMATION);
				SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
				IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));

				// Decrypt 시행
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
