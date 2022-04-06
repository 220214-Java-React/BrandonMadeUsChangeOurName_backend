package com.revanture.project1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import java.io.*;
import java.io.PrintWriter;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import  com.revanture.project1.factories.ConnectionFactory;

@WebServlet(urlPatterns = {"/servlet"})


public class reiServlet extends HttpServlet{



    public void init(ServletConfig config) {System.out.println("Servlet is being initialized");}
    public void destroy() {System.out.println("Servlet is being destroyed");    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        ArrayList<HashMap> rei = new ArrayList<>();
        String json = "";
        ObjectMapper mapper = new ObjectMapper();

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "select * from ERS_REIMBURSEMENTS";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            int i =0;

            while(rs.next()){
                System.out.println("row: " + ++i);
                HashMap<String, String> myREI = new HashMap<String, String>();
                myREI.put("REIMB_ID", String.valueOf(rs.getInt("REIMB_ID")));
                myREI.put("AMOUNT", String.valueOf(rs.getFloat("AMOUNT")));
                myREI.put("SUBMITTED", rs.getString("SUBMITTED"));
                myREI.put("RESOLVED", rs.getString("RESOLVED"));
                myREI.put("DESCRIPTION", rs.getString("DESCRIPTION"));
                myREI.put("RECEIPT", rs.getString("RECEIPT"));
                myREI.put("PAYMENT_ID", rs.getString("PAYMENT_ID"));
                myREI.put("AUTHOR_ID", String.valueOf(rs.getInt("AUTHOR_ID")));
                myREI.put("RESOLVER_ID", String.valueOf(rs.getInt("RESOLVER_ID")));
                myREI.put("STATUS_ID", String.valueOf(rs.getInt("STATUS_ID")));
                myREI.put("TYPE_ID", String.valueOf(rs.getInt("TYPE_ID")));

                rei.add(myREI);
            }

            json = mapper.writeValueAsString(rei);

            response.setContentType("application/json");
            response.getOutputStream().println(json);
        }
        catch(Exception e)  {System.out.println(e);}
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Function Scope Variables
        int typeNum = 4;

        double amount = Double.parseDouble(request.getParameter("amo"));
        String desc = request.getParameter("desc");
        int authorID = Integer.parseInt(request.getParameter("aid"));
        String type = request.getParameter("type");


        // Type Translation: String to Int
        if (type.toLowerCase().equals("lodging")) typeNum = 1;
        if (type.toLowerCase().equals("travel")) typeNum = 2;
        if (type.toLowerCase().equals("food")) typeNum = 3;

        // Console print functionality
        System.out.println(amount + " " + desc + " " + authorID + " " + type + " " + typeNum);

        try (Connection con = ConnectionFactory.getConnection()) {
            System.out.println("Connection made.");

            PreparedStatement stmt = con.prepareStatement("insert into ERS_REIMBURSEMENTS (AMOUNT, DESCRIPTION, AUTHOR_ID, STATUS_ID, TYPE_ID) values (?,?,?,?,?)");

            stmt.setFloat(1, (float) amount);
            stmt.setString(2, desc);
            stmt.setInt(3, authorID);
            stmt.setInt(4, 1);
            stmt.setInt(5, typeNum);
            stmt.execute();

        }
        catch (SQLException e) {
            System.out.println(e);
            System.out.println("Unable to download customers. Please contact the system administrator.");
        }

        response.setContentType("text/html");//setting the content type
        PrintWriter pw=response.getWriter();//get the stream to write the data

        //writing html in the stream
        pw.println("<html><body>");
        pw.println("Reimbursement Complete. Close tab when finished. Create a new Reimbursement in the previous tab.");
        pw.println("</body></html>");

        pw.close();//closing the stream
    }
}