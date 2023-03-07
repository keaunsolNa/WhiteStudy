package keaunsol;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Study_2023_03_09_Level1_ElementaryArithmetic extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static StringBuilder sb = new StringBuilder();
	private static JTextArea answer = new JTextArea(5,20);

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("연산")) {
			
			operating(sb);
			answer.append(sb.toString());
		}
		
		else if(e.getActionCommand().equals("종료")) System.exit(0);
		
		else sb.append(e.getActionCommand());
	}
	
	public StringBuilder returnExpression() {
		JFrame fr = new JFrame("사칙연산 계산기");
    	
    	JPanel pn = new JPanel();
    	JPanel pNumberN = new JPanel();
    	JPanel pNumberC = new JPanel();
    	JPanel pNumberS = new JPanel();
    	JPanel pOper = new JPanel();
    			
    	JButton[] btNumberNorth = new JButton[3];
    	JButton[] btNumberCenter = new JButton[3];
    	JButton[] btNumberSouth = new JButton[3];
    	JButton[] btnOper = new JButton[6];
    	
    	BorderLayout fl = new BorderLayout();
    	pn.setLayout(fl);
    	
    	for(int i = 0; i < 9; i++) {
    		
    		
    		if (i < 3) {
    			
    			btNumberNorth[i] = new JButton("" + (i + 1));
    			btNumberNorth[i].addActionListener(this);
    			pNumberN.add(btNumberNorth[i]);
    			
    		}
    		
    		else if (i < 6) {
    			
    			btNumberCenter[i - 3] = new JButton("" + (i + 1));
    			btNumberCenter[i - 3].addActionListener(this);
    			pNumberC.add(btNumberCenter[i - 3]);
    			
    		}
    		
    		else {
    			
    			btNumberSouth[i - 6] = new JButton("" + (i + 1));
    			btNumberSouth[i - 6].addActionListener(this);
    			pNumberS.add(btNumberSouth[i - 6]);
    			
    		}
            
    	}
    	

    	
    	for(int i = 0; i < 6; i++) {
    		
    		btnOper[i] = (i == 0) ? new JButton("+") :
    				     (i == 1) ? new JButton("-") :
					     (i == 2) ? new JButton("*") :
				    	 (i == 3) ? new JButton("/") :
			    		 (i == 4) ? new JButton("연산") :
					     		    new JButton("종료");
    		
    		btnOper[i].addActionListener(this);
    		pOper.add(btnOper[i]);
    		
    	}
    	
    	
    	pn.add(pNumberN, BorderLayout.NORTH);
    	pn.add(pNumberC, BorderLayout.WEST);
    	pn.add(pNumberS, BorderLayout.EAST);
    	pn.add(answer, BorderLayout.CENTER);
    	pn.add(pOper, BorderLayout.SOUTH);

    	fr.setContentPane(pn);
        fr.setSize(400, 300);
        fr.setVisible(true);
        
        return sb;
	}
    
	public static int operating(StringBuilder expression) {
		
		return 1;
	}
}
