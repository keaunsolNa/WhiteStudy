package keaunsol;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Study_2023_03_09_Level1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new Study_2023_03_09_Level1();
	}
	
    private Study_2023_03_09_Level1() {
    	
    	JButton b1 = new JButton("사칙연산 계산기");
        JButton b2 = new JButton("윤년 계산기");
        JButton b3 = new JButton("소수 계산기");
        JButton b4 = new JButton("최대 공약수 계산기");
        JButton b5 = new JButton("최소 공배수 계산기");
        setLayout(new FlowLayout());
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        
        setSize(800,500);
        setAlwaysOnTop(true);
        setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
    
		String str = e.getActionCommand(); 
        
		if(str.equals("사칙연산 계산기")) {
        
			Study_2023_03_09_Level1_ElementaryArithmetic ea = 
					new Study_2023_03_09_Level1_ElementaryArithmetic();
			dispose();
			
			System.out.println(ea.returnExpression());
			
        }
		
		else if(str.equals("윤년 계산기")) {
			
            System.out.println("버튼 2 이벤트 발생");
            setBackground(Color.BLUE);
            
        }
		
		else if(str.equals("소수 계산기")) {
			
            System.out.println("버튼 3 이벤트 발생");
            setBackground(Color.pink);
            
        } 
		
		else if(str.equals("최대 공약수 계산기")) {
			
			System.out.println("이벤트4");
			
		}
		
		else if(str.equals("최소 공배수 계산기")) {
			
			System.out.println("이벤트5");
		}
		 
	}
	
    
}
