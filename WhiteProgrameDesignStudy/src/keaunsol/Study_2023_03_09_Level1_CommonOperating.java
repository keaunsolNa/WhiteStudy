package keaunsol;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Study_2023_03_09_Level1_CommonOperating {

	// 결과값이 나오게 될 JTextArea static 참조 변수 생성
	private static JTextArea answer = 
			Study_2023_03_09_Level1_NumberAndResultPanel.answer;

	// 결과값에 보여질 텍스트인 StringBuilder static 참조 변수 생성
	private static StringBuilder sb = 
			Study_2023_03_09_Level1_NumberAndResultPanel.sb;
	
	// 결과값이 적히는 JTextArea를 초기화하는 Method
	public void operatingErase() {
		
		// 연산 처리 진행 중 여부를 결정하는 패키지 전역 static 변수
		Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = false;
		answer.setText("");
		
	}
	
	// Level1의 JFrame을 닫아주는 Method 
	public void operatingExit(JFrame fr) {
		
		Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = false;
		answer.setText("");
		
		// 열려 있던 JFrame을 닫아준다.
		fr.dispose();
		
		// Main Frame은 생성자에서 Frame을 그려주기에 레퍼런스 변수 생성 시 바로 Frame이 그려진다.
		Study_2023_03_09_Level1 cal = new keaunsol.Study_2023_03_09_Level1();
		
	}
	
	// Level2의 JFrame을 닫아주는 Method 
	public void operatingExitRandom(JFrame fr) {
		
		answer.setText("");
		fr.dispose();
		Study_2023_03_09_Level2 cal = new keaunsol.Study_2023_03_09_Level2();
		
	}
	
	// Level3의 JFrame을 닫아주는 Method 
	public void operatingExitEncryption(JFrame fr) {

		answer.setText("");
		fr.dispose();
		Study_2023_03_09_Level3 cal = new keaunsol.Study_2023_03_09_Level3();
		
	}
	
	// LCM과 GCD class에서 And 버튼 시행 시 발동하는 Method
	public int operatingAnd(Integer prevNumber) {
		
		// 기존에 입력되었던 내용이 없을 경우 And 연산을 시행하지 않는다.
		if(sb.length() == 0) {
			
			// 결과창 값 초기화
			answer.setText("");
			
			// 결과창에 오류 내용 출력
			answer.append("잘못된 입력입니다.");
			Study_2023_03_09_Level1_NumberAndResultPanel.isOpering = true;
		
		}
		
		// 기존 입력 내용 있을 경우 And 연산 시행
		else {
			
			// 결과창에 AND를 추가한다.
			answer.append(" AND ");
			
			// 두 수 중 이전 값에 기존에 입력되었던 정수로 초기화한다.
			prevNumber = Integer.parseInt(sb.toString());
			
			// 입력용 StringBuilder 객체의 이전 입력값을 지운다.
			sb.setLength(0);
		}
		
		// 이전 값 반환
		return prevNumber;
		
	}

	// JFrame의 전체적인 Setting을 정의하는 Method
	public void operatingFrameSetting(JFrame fr, JPanel pn) {
		
		// 매개변수인 특정 class의 JFrame에 매개변수인 JPanel을 컨테이너로 추가.
    	fr.setContentPane(pn);
    	
    	// JFrame 사이즈 설정
		fr.setSize(500, 300);
		
		// JFrame은 초기값이 보이지 않게 설정되어 있다. 설정값을 true로 변경하여 frame이 보이게 한다.
        fr.setVisible(true);
        
        // Dimension class로 매개변수 JFrame의 사이즈를 값으로 가지는 변수 생성 및 초기화
        Dimension frameSize = fr.getSize();
        
        // Dimension class로 현재 스크린의 사이즈를 값으로 가지는 변수 생성 및 초기화
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // JFrame 객체의 위치를 화면 중앙으로 설정한다.         
        fr.setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
        
        // JFrame 객체의 소멸 옵션 (DISPOSE_ON_CLOSE)
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
	}

}
