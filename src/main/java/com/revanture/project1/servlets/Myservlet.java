package com.revanture.project1.servlets;



import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import static com.revanture.project1.factories.ConnectionFactory.*;

@WebServlet(urlPatterns = {"/myservlet"})
public class Myservlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setStatus(200);
        response.getOutputStream().println("get");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String jsonIn = request.getReader().lines().collect(Collectors.joining());
        String jsonOut = "bitch";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> temp = mapper.readValue(jsonIn, Map.class);
        HashMap<String, String> myMap = new HashMap<>(temp);


    }
}