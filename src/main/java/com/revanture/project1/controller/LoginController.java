package com.revanture.project1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revanture.project1.model.User;
import com.revanture.project1.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/login/*")
public class LoginController extends HttpServlet{

    public void init(ServletConfig config) {System.out.println("Step One");}
    public void destroy() {System.out.println("Step Two");}

    UserService userService = new UserService();
    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String JSON = req.getReader().lines().collect(Collectors.joining());
        System.out.println(JSON);
        User user = mapper.readValue(JSON, User.class);
        User dbUser = userService.validate(user);

        if(dbUser != null){
            JSON = mapper.writeValueAsString(dbUser);
            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.getOutputStream().println(JSON);
        }else{
            resp.setStatus(401);
            resp.getOutputStream().println("Login Failed");

        }
    }
}
