package com.natal.calculator;

import com.natal.calculator.model.Operation;
import com.natal.calculator.service.Addition;
import com.natal.calculator.service.Multiplication;
import com.natal.calculator.service.Subtraction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servletcalculator", urlPatterns = "/calculator")
public class Calculator extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter output = response.getWriter();

            this.addHit(request, response);

            int numberOne= Integer.parseInt(request.getParameter("firstNumber"));
            int numberTwo= Integer.parseInt(request.getParameter("secondNumber"));

            output.println("<h1 style=\"width : 400px; height: 60px; " +
                    "border-left: 3px solid black; border-top: 3px solid black; border-right: 3px solid black; border-bottom: 3px dashed black;" +
                    "background-color: #A9A9A9; " +
                    "padding-top: 25px; " +
                    "margin: 0; " +
                    "text-align: center;\">Results</h1>");

            if(request.getParameter("addition") != null) {
                int result = Addition.execute(numberOne, numberTwo);
                this.answer(output, Operation.ADDITION, numberOne, numberTwo, result);
            }
            if(request.getParameter("subtraction") != null) {
                int result = Subtraction.execute(numberOne, numberTwo);
                this.answer(output, Operation.SUBTRACTION, numberOne, numberTwo, result);
            }
            if(request.getParameter("multiplication") != null) {
                int result = Multiplication.execute(numberOne, numberTwo);
                this.answer(output, Operation.MULTIPLICATION, numberOne, numberTwo, result);
            }
            this.goToResultPage(request, response);
        } catch(Exception e)
        {
            log("Failed to calculate :(" , e);
        }

    }

    private void addHit(HttpServletRequest request, HttpServletResponse response) {
        String cookieName = "hits";
        String hits = "1";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie value : cookies) {
                if (cookieName.equals(value.getName())) {
                    hits = String.valueOf(Integer.parseInt(value.getValue()) + 1);
                }
            }
        }
        Cookie newHitsNumber = new Cookie("hits", hits);
        response.addCookie(newHitsNumber);
    }

    private void answer(PrintWriter output, Operation operation, int numberOne, int numberTwo, int result) {
        output.println("<h2 style=\"width : 400px; " +
                "border-left: 3px solid black; border-right: 3px solid black; " +
                "background-color: #C0C0C0; " +
                "margin: 0px; " +
                "padding-top: 10px; padding-bottom: 10px;\">" +
                operation.getValue() + ": " + numberOne + operation.getOperator() + numberTwo + " = " + result + "</h2>");
    }

    private void goToResultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/result.html");
        rd.include(request, response);
    }
}
