package keaunsol;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Study_2023_03_09_Level2_RandomGenerator extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JFrame fr = new JFrame("로또 번호 생성기");
	private static Random random = new Random();
	
	private static JTextArea answer = 
			Study_2023_03_09_Level1_NumberAndResultPanel.answer;
	
	private static final Study_2023_03_09_Level1_CommonOperating commonOper = 
			new Study_2023_03_09_Level1_CommonOperating();
	
	
	public void returnExpression() {
		
		JPanel pn = new JPanel();
		
    	BorderLayout fl = new BorderLayout();
    	pn.setLayout(fl);
    	
    	JButton makeNumber = new JButton("번호생성");
    	JButton back = new JButton("뒤로가기");

    	makeNumber.addActionListener(this);
    	back.addActionListener(this);
    	
    	pn.add(makeNumber, BorderLayout.NORTH);
    	pn.add(back, BorderLayout.SOUTH);
    	pn.add(answer, BorderLayout.CENTER);
    	answer.setEditable(false);
    	
    	commonOper.operatingFrameSetting(fr, pn);
    	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 임의의 난수 번호 7개 생성
		if(e.getActionCommand().equals("번호생성")) {

			if(answer.getText().length() != 0) answer.setText("");
			
			answer.append("\n");
			
			// 중복값 방지를 위해 Set<Integer>로 할당한다.
			Set<Integer> lotto = new HashSet<>();
			
			while(lotto.size() != 7) {
				
				// Random 클래스를 이용해 1 ~ 45의 난수를 생성하여 할당한다.
				int number = random.nextInt(45) + 1;
				lotto.add(number);
			}

			// 결과값을 화면에 출력
			for (Integer integer : lotto) answer.append("\t 당첨 예상 번호는 : \t" + integer + "\n");
			
			answer.append("\n");
			
		}
		
		else if(e.getActionCommand().equals("뒤로가기")) {
			
			commonOper.operatingExitRandom(fr);
			
		}
	}
	
}
