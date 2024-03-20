package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet01")
public class Servlet01 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost()로 포워딩 하고 있다.
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변수선언
		int num1, num2 ,result;
		String op;
		// 클라이언트 응답시 전달된 컨텐츠에 대한 mime type과 캐릭터셋 지정
		response.setContentType("text/html; charset=UTF-8");
		// 클라이언트 응답을 위한 출력 스트림 확보
		PrintWriter out = response.getWriter();
		// jsp에서 입력 값을 받아옴
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		op = request.getParameter("operator");
		// calc 메소드 호출로 값을 가져옴
		result = calc(num1, num2, op);
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>계산 결과</TITLE></HEAD>");
		out.println("<BODY><CENTER>");
		out.println("<H2>계산 결과</H2>");
		out.println("<HR>");
		out.println(num1 + " " + op + " " + num2 + " = " + result);
		out.println("</BODY></HTML>");
	}
	
// 실제 계산 메소드
	private int calc(int num1, int num2, String op) {
		
		int result = 0;
		
		switch (op) {
		
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		}
		
	    // 연산 결과를 파일로 저장
        saveResultToFile(result);
        
		return result;
	}
	

	  // 결과를 파일로 저장하는 메소드
    private void saveResultToFile(int result) {
        try {
            // 사용자의 바탕화면 경로 얻기
            String desktopPath = System.getProperty("user.home") + "/Desktop";
            // 파일 경로 설정
            String filePath = desktopPath + "/result.txt";
            
            // 파일 객체 생성
            File file = new File(filePath);

            // 파일이 존재하지 않으면 생성
            if (!file.exists()) {
                file.createNewFile();
            }

            // 파일에 연산 결과 쓰기
            FileWriter writer = new FileWriter(file.getAbsoluteFile());
            writer.write("계산 결과: " + result);
            writer.close();

            System.out.println("파일이 바탕화면에 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    
   	}
}


