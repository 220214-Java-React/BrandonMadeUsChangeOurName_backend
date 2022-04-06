package com.revanture.project1.service;

import com.revanture.project1.model.Reimbursment;
import com.revanture.project1.repository.ReimbursmentsReppository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ReimbursmentService {
    private final Logger logger;
    private final ReimbursmentsReppository reimbursementsRepository;

    public ReimbursmentService(){
        this.logger = LogManager.getLogger(ReimbursmentService.class);
        this.reimbursementsRepository = new ReimbursmentsReppository();
    }

    public void create(Reimbursment reimbursements) {
        reimbursementsRepository.create(reimbursements);
    }

    public List<Reimbursment> getAll() {
        return reimbursementsRepository.getAll();}

    public List<Reimbursment> getByAuthorId(int parseInt) {
        return reimbursementsRepository.getByAuthorId(parseInt);

    }
}

