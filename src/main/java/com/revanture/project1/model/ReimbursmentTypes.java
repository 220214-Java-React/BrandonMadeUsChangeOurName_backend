package com.revanture.project1.model;

public enum ReimbursmentTypes {
    Lodging("Lodging"),
    Travel("Travel"),
    Food("Food"),
    Other("Other");

    public final String value;

    ReimbursmentTypes(String value){
        this.value = value;
    }
}
