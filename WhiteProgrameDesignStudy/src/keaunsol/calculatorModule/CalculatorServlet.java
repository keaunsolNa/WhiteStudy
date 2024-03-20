package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/calculate")
public class CalculatorServlet implements Servlet {
    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);
    private ServletConfig servletConfig;


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        log.info("init");
        this.servletConfig = servletConfig;

    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        log.info("service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(request);
    }

    @Override
    public void destroy() {

        // resource release
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

}
