package com.revanture.project1.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//http://localhost:8080
@WebServlet(urlPatterns = "/hello")

public class testservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String json="{\"id\", \"name\":\"Chas Stevens\"}";
        resp.setContentType("application/json");
        resp.setStatus(200);
        resp.getOutputStream().print(json);
    }

}
