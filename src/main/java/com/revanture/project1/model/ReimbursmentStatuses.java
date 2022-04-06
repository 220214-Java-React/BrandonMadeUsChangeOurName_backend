package com.revanture.project1.model;

public enum ReimbursmentStatuses {

    Pending("Pending"),
    Approved("Approved"),
    Denied("Denied");

    public final String value;

    ReimbursmentStatuses(String value){
        this.value = value;
    }
}
