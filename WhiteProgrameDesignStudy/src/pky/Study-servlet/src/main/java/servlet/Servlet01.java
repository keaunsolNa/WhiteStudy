package servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet01
 */
@WebServlet("/Servlet01")
public class Servlet01 extends HttpServlet {
	
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		// 파일에 결과 저장
        String filename = "result.txt";
        String filepath = "C:\\Users\\kypark\\enterprise\\Study-servlet\\" + filename; // 경로 설정
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(filepath))) {
            fileWriter.println("계산 결과: " + result);
        } catch (IOException e) {
            out.println("파일에 결과를 저장하는 동안 오류가 발생했습니다: " + e.getMessage());
        }
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>계산 결과</TITLE></HEAD>");
		out.println("<BODY><CENTER>");
		out.println("<H2>계산 결과</H2>");
		out.println("<HR>");
		out.println(num1 + " " + op + " " + num2 + " = " + result);
		out.println("<br>");
        out.println("파일에 결과를 저장했습니다. (" + filename + ")");
        out.println("</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		return result;
	}
}
