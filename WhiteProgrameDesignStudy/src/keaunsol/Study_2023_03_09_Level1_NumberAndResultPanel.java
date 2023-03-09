package keaunsol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Study_2023_03_09_Level1_NumberAndResultPanel extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	static JTextArea answer = new JTextArea(5,20);
	static StringBuilder sb = new StringBuilder();
	static boolean isOpering;
	
	// 숫자칸과 결과창 JPanel 생성 후 반환하는 Method
	public JPanel NumberAndResultPanel() {
		
    	JPanel pNumber = new JPanel();
    	JButton[] btNumber = new JButton[10];
    	answer.setEditable(false);
    	
    	for(int i = 0; i < 10; i++) {
    		
    		btNumber[i] = new JButton("" + (i));
    		btNumber[i].addActionListener(this);
    		pNumber.add(btNumber[i]);
    		
    	}
    	
        return pNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(isOpering) {
			answer.setText("");
			isOpering = false;
		}
		
		answer.append(e.getActionCommand());
		sb.append(e.getActionCommand());
	}
}
