package keaunsol;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Study_2023_03_09_Level1 extends JFrame implements ActionListener {
	
	// Serialize
	private static final long serialVersionUID = 1L;
	
	// static JFrame 레퍼런스 변수 생성
	private static JFrame fr = new JFrame("계산기");
	
	// 공통 기능 참조를 위한 레퍼런스 변수 생성
	private static Study_2023_03_09_Level1_CommonOperating commonOper = 
			new Study_2023_03_09_Level1_CommonOperating();
	
	// Main
	public static void main(String[] args) {
		new Study_2023_03_09_Level1();
	}
	
	// Constructor 생성
    Study_2023_03_09_Level1() {
    	
    	// Main 화면에서 사용할 Panel과 Button 배열 레퍼런스 변수 생성
    	JPanel pn = new JPanel();
    	JPanel pbt = new JPanel();
    	JButton[] pBtn = new JButton[5];
    	
    	// 프레임 설정을 위한 BorderLayout 레퍼런스 변수 생성
    	BorderLayout fl = new BorderLayout();
    	pn.setLayout(fl);
    	
    	for(int i = 0; i < 5; i++) {
    		
    		// for문으로 JButton 배열에 값(JButton) 할당 
    		pBtn[i] = (i == 0) ? new JButton("사칙연산 계산기") :
		    		  (i == 1) ? new JButton("윤년 계산기") :
	    			  (i == 2) ? new JButton("소수 계산기") :
    				  (i == 3) ? new JButton("최대 공약수 계산기") :
 				     		     new JButton("최소 공배수 계산기");
    		
    		// 각각의 버튼에 ActionListener 부여
    		pBtn[i].addActionListener(this);
    		
    		// 버튼 Panel에 배열 객체 부여
    		pbt.add(pBtn[i]);
    		
    	}
    	
    	// 메인 Panel에 버튼 Panel 부여
    	pn.add(pbt);
    	
    	// commonOper의 operatingFrameSetting Method 호출하여 static 변수인 frame 설정 부여
    	commonOper.operatingFrameSetting(fr, pn);
    	
    	// Main 화면만 크기가 다르기에 화면 크기 재할당
        fr.setSize(800, 300);
        
    }

    // Overide된 actionPerformed Method
	@Override
	public void actionPerformed(ActionEvent e) {
    
		// actionPerformed는 parameter로 눌려진 버튼에 대한 정보를 받는다. 해당 객체로부터 버튼의 이름을 받아 조건문을 시행한다.
		String str = e.getActionCommand(); 
        
		if(str.equals("사칙연산 계산기")) {
        
			// 사칙연산 클래스 레퍼런스 변수 생성
			Study_2023_03_09_Level1_ElementaryArithmetic eleArith = 
					new Study_2023_03_09_Level1_ElementaryArithmetic();
			
			// returnExpression Method 호출
			eleArith.returnExpression();
			
			// 이전의 Main Frame은 종료한다.
			fr.dispose();
			
        }
		
		else if(str.equals("윤년 계산기")) {
			
			Study_2023_03_09_Level1_LeafYear leafYear =
					new Study_2023_03_09_Level1_LeafYear();

			leafYear.returnExpression();
			fr.dispose();
        }
		
		else if(str.equals("소수 계산기")) {
			
			Study_2023_03_09_Level1_PrimeNumber primeNumber = 
					new Study_2023_03_09_Level1_PrimeNumber();
			
			primeNumber.returnExpression();
			fr.dispose();
        } 
		
		else if(str.equals("최대 공약수 계산기")) {
			
			Study_2023_03_09_Level1_GCD GCD = 
					new Study_2023_03_09_Level1_GCD();
			
			GCD.returnExpression();
			fr.dispose();
			
		}
		
		else if(str.equals("최소 공배수 계산기")) {
			
			Study_2023_03_09_Level1_LCM LCM = 
					new Study_2023_03_09_Level1_LCM();
			
			LCM.returnExpression();
			fr.dispose();
			
		}
		 
	}
	
    
}
