package com.revanture.project1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revanture.project1.model.ReimbursmentStatuses;
import com.revanture.project1.model.Reimbursment;

import com.revanture.project1.service.ReimbursmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/reimbursment/*")
public class ReimbursmentController extends HttpServlet{

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LogManager.getLogger(ReimbursmentController.class);
    //TODO Create Reimbursement Service
    private static final ReimbursmentService reimbursementsService = new ReimbursmentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String JSON = req.getReader().lines().collect(Collectors.joining());
        ReimbursmentStatuses reimbursementStatuses = ReimbursmentStatuses.valueOf("Pending");
        Reimbursment reimbursements;
        System.out.println(JSON);
        int paymentID = 0;
        try {
            reimbursements = mapper.readValue(JSON, Reimbursment.class);

            reimbursements.setStatusId(reimbursementStatuses);
            //reimbursements.setPayment_id(Integer.parseInt(String.valueOf(paymentID)));
            reimbursementsService.create(reimbursements);
            resp.setStatus(204);

        } catch (Exception e) {
            logger.warn(e);
            resp.setStatus(500);
        }
    }

    @Override
    //TODO Working on getting information according to the authors ID
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //List<Reimbursements> reimbursements;
        String authorId = request.getParameter("author_id");
        String role_id = request.getParameter("role_id");

        logger.info(authorId);
        logger.info(role_id);

        if(role_id.equals("Employee")) {


            List<Reimbursment> reimbursements;
            if (authorId != null) {
                //List<Reimbursements>
                reimbursements = reimbursementsService.getByAuthorId(Integer.parseInt(authorId));
                String JSON = mapper.writeValueAsString(reimbursements);
                response.setContentType("application/json");
                response.setStatus(200);
                response.getOutputStream().println(JSON);

                logger.info(JSON);
            } else {
                try {

                    reimbursements = reimbursementsService.getAll();
                    String JSON = mapper.writeValueAsString(reimbursements);
                    response.setContentType("application/json");
                    response.setStatus(200);
                    response.getOutputStream().println(JSON);
                } catch (Exception e) {
                    logger.warn(e);
                }
            }
        }
        else{
            List<Reimbursment> reimbursements = reimbursementsService.getAll();
            String JSON = mapper.writeValueAsString(reimbursements);
            response.setContentType("application/json");
            response.setStatus(200);
            response.getOutputStream().println(JSON);
        }
    }
}
