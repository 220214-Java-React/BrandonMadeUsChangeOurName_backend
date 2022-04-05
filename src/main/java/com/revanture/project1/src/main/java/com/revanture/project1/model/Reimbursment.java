package com.revanture.project1.model;

public class Reimbursment {
    private int reimbId;
    private double amount;
    private String submittedTime;
    private String resolveTime;
    private String description;
    private byte receipt;
    private int paymentId;
    private int authorId; //creator of the reimbursment
    private int  resolveId; // the id of the person who reimburs
    private int statusId; // status of the reimbursements, pending, approved, denied
    private int typeId; // type of reimbursements food, travel, lodging, other


    public Reimbursment(){

    }

    public Reimbursment( double amount, int authorId){
        this.amount = amount;
        this.authorId = authorId;
    }

    public Reimbursment(int reimId, double amount, String submittedTime, String resolveTime, String description, int authorId, int resolvedId, int statusId, int typeId){

        this.reimbId = reimId;
        this.amount = amount;
        this.submittedTime = submittedTime;
        this.resolveTime = resolveTime;
        this.description = description;
        this.authorId = authorId;
        this.resolveId = resolvedId;
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
    public String getSubmittedTime() {
        return submittedTime;
    }

    public void setSubmittedTime(String submittedTime) {
        this.submittedTime = submittedTime;
    }
// resTime getter and setter
    public String getResolveTime() {
        return resolveTime;
    }

    public void setResolveTime(String resolveTime) {
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
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
//TypeID getter and setter
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
