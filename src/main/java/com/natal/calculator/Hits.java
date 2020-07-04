package com.natal.calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "hits", urlPatterns = "/hits")
public class Hits extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html");
        PrintWriter output = response.getWriter();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("hits")) {
                    String hits = cookie.getValue();
                    output.println("<h2 style=\"width: 400px; " +
                            "border-bottom: 3px dashed black; " +
                            "background-color: #A9A9A9; " +
                            "padding: 0; " +
                            "margin: 0; " +
                            "text-align: center;\">This calculator has been used " + hits + " times since last cache reset!</h2>");
                    this.goToHitsPage(request, response);
                }
            }
        }
    }

    private void goToHitsPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/hits.html");
        rd.include(request, response);
    }

}
