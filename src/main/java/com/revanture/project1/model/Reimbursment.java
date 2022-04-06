package com.revanture.project1.model;
import java.security.Timestamp;

public class Reimbursment {


    private int reimbId;
    private double amount;
    private Timestamp submittedTime;
    private Timestamp resolveTime;
    private String description;
    private byte receipt;
    private int paymentId;
    private String authorName;
    private String resolverName;
    private int authorId; //creator of the reimbursment
    private int  resolveId; // the id of the person who reimburs
    private ReimbursmentStatuses statusId; // status of the reimbursements, pending, approved, denied
    private ReimbursmentTypes typeId; // type of reimbursements food, travel, lodging, other


    public Reimbursment(){

    }

    public Reimbursment( double amount, int authorId){
        this.amount = amount;
        this.authorId = authorId;
    }

    public Reimbursment(int reimId, double amount, String description){

        this.reimbId = reimId;
        this.amount = amount;
        this.description = description;


    }

    public Reimbursment(int reimId, double amount, String description, String authorName){

        this.reimbId = reimId;
        this.amount = amount;
        this.submittedTime = submittedTime;
        this.resolveTime = resolveTime;
        this.description = description;
        this.authorName = authorName;
        this.resolverName = resolverName;
        this.statusId = statusId;
        this.typeId = typeId;
    }


 //reimId getter and setter
    public int getReimbId() {
        return reimbId;
    }

    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }
//amount getter and setter
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
// subTime getter and setter
    public Timestamp getSubmittedTime() {
        return submittedTime;
    }

    public void setSubmittedTime(Timestamp submittedTime) {
        this.submittedTime = submittedTime;
    }
// resTime getter and setter
    public Timestamp getResolveTime() {
        return resolveTime;
    }

    public void setResolveTime(Timestamp resolveTime) {
        this.resolveTime = resolveTime;
    }
// description getter and setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
//Receipt getter and setter
    public byte getReceipt() {
        return receipt;
    }

    public void setReceipt(byte receipt) {
        this.receipt = receipt;
    }
//paymentId getter and setter
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
//author Id getter and setter
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
//ResolveId getter and setter
    public int getResolveId() {
        return resolveId;
    }

    public void setResolveId(int resolveId) {
        this.resolveId = resolveId;
    }
//Status getter and setter
    public ReimbursmentStatuses getStatusId() {
        return statusId;
    }

    public void setStatusId(ReimbursmentStatuses statusId) {
        this.statusId = statusId;
    }
//TypeID getter and setter
    public ReimbursmentTypes getTypeId() {
        return typeId;
    }

    public void setTypeId(ReimbursmentTypes typeId) {
        this.typeId = typeId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getResolverName() {
        return resolverName;
    }

    public void setResolverName(String resolverName) {
        this.resolverName = resolverName;
    }
}
