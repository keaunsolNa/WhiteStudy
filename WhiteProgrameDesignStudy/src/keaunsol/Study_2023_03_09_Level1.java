package keaunsol;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Study_2023_03_09_Level1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JFrame fr = new JFrame("계산기");
	
	
	private static Study_2023_03_09_Level1_CommonOperating commonOper = 
			new Study_2023_03_09_Level1_CommonOperating();
	
	public static void main(String[] args) {
		new Study_2023_03_09_Level1();
	}
	
    Study_2023_03_09_Level1() {
    	
    	JPanel pn = new JPanel();
    	JPanel pbt = new JPanel();
    	JButton[] pBtn = new JButton[5];
    	
    	BorderLayout fl = new BorderLayout();
    	pn.setLayout(fl);
    	
    	for(int i = 0; i < 5; i++) {
    		
    		pBtn[i] = (i == 0) ? new JButton("사칙연산 계산기") :
		    		  (i == 1) ? new JButton("윤년 계산기") :
	    			  (i == 2) ? new JButton("소수 계산기") :
    				  (i == 3) ? new JButton("최대 공약수 계산기") :
 				     		     new JButton("최소 공배수 계산기");
    		
    		pBtn[i].addActionListener(this);
    		pbt.add(pBtn[i]);
    		
    	}
    	
    	pn.add(pbt);
    	
    	commonOper.operatingFrameSetting(fr, pn);
        fr.setSize(800, 300);
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
    
		String str = e.getActionCommand(); 
        
		if(str.equals("사칙연산 계산기")) {
        
			Study_2023_03_09_Level1_ElementaryArithmetic eleArith = 
					new Study_2023_03_09_Level1_ElementaryArithmetic();
			
			eleArith.returnExpression();
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
