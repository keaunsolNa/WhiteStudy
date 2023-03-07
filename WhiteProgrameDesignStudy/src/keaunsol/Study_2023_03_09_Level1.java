package keaunsol;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Study_2023_03_09_Level1 extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Study_2023_03_09_Level1();
	}
	
    private Study_2023_03_09_Level1() {
        setTitle("게산기 연습 에제"); //프레임 타이틀
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container contentPane = getContentPane(); 
        contentPane.setBackground(Color.white); 
        contentPane.setLayout(new FlowLayout()); 
        
        contentPane.add(new JButton("사칙연산 계산기")); 
        contentPane.add(new JButton("윤년 계산기")); 
        contentPane.add(new JButton("소수 계산기")); 
        contentPane.add(new JButton("최대 공약수 계산기")); 
        contentPane.add(new JButton("최소 공배수 계산기"));
        
        setSize(700, 300); 
        setVisible(true); 
        
    }
}
