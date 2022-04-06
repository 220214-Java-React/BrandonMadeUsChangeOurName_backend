package com.revanture.project1.repository;

import com.revanture.project1.DAO.DAO;
import com.revanture.project1.model.ReimbursmentStatuses;
import com.revanture.project1.model.ReimbursmentTypes;
import com.revanture.project1.model.Reimbursment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.revanture.project1.factories.ConnectionFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties
public class ReimbursmentsReppository implements DAO<Reimbursment> {

    private static final Logger logger = LogManager.getLogger(UserRepository.class);

    @Override
    public void create(Reimbursment reimbursements) {
        Connection connection = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "insert into ers_reimbursements(amount, submitted, resolved, description, payment_id, author_id, status_id1, type_id1) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setDouble(1, reimbursements.getAmount());
            stmt.setInt(2, reimbursements.getSubmittedTime());
            stmt.setInt(3, reimbursements.getResolveTime());
            stmt.setString(4, reimbursements.getDescription());
            stmt.setInt(5, reimbursements.getPaymentId());
            stmt.setInt(6, reimbursements.getAuthorId());
            stmt.setInt(7, reimbursements.getTypeId().ordinal());
            stmt.setInt(8, reimbursements.getStatusId().ordinal());

//            stmt.setInt(7, reimbursements.getResolver_id());


            stmt.executeUpdate();
            System.out.println(stmt);
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }

    }

    @Override
    public Reimbursment getById(int id) {
        return null;
    }

    public List<Reimbursment> getByAuthorId(int author_id) {
        List<Reimbursment> reimbursements = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from ers_reimbursements where author_id = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, author_id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                reimbursements.add(
                        new Reimbursment(
                                rs.getInt("reimb_id"),
                                rs.getDouble("amount"),
                                rs.getInt("submittedTime"),
                                rs.getInt("resolveTime"),
                                rs.getString("description"),
                                rs.getInt("paymentId"),
                                rs.getInt("authorId"),
                                ReimbursmentStatuses.values()[rs.getInt("status_id")],
                                ReimbursmentTypes.values()[rs.getInt("type_id")]));


            }
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }
        return reimbursements;

    }

    @Override
    public List<Reimbursment> getAll() {
        List<Reimbursment> reimbursements = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from ers_reimbursements";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                reimbursements.add(new Reimbursment(
                        resultSet.getInt("reimb_id"),
                        resultSet.getDouble("amount"),
                        resultSet.getInt("submittedTime"),
                        resultSet.getInt("resolveTime"),
                        resultSet.getString("description"),
                        resultSet.getInt("paymentId"),
                        resultSet.getInt("authorId"),
                        ReimbursmentStatuses.values()[resultSet.getInt("statusId")],
                        ReimbursmentTypes.values()[resultSet.getInt("type_id")]));

            }


        } catch (Exception e) {
            logger.warn(e);
        }
        return reimbursements;


    }

    @Override
    public void update(Reimbursment reimbursements) {

    }

    @Override
    public void deleteById(int id) {

    }
}
