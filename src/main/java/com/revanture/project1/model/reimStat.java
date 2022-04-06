package com.revanture.project1.model;

public enum reimStat {

    PENDING("PENDING"),
    APPROVED("APPROVED"),
    DENIED("DENIED");

    public final String status;

    reimStat(String status) {
        this.status = status;
    }

}
