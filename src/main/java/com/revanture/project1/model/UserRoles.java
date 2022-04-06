package com.revanture.project1.model;

public enum UserRoles {

    Admin("Admin"),
    FinanceManager("Finance Manager"),
    Employee("Employee");


    public final String value;

    UserRoles(String value){
        this.value = value;



    }
}
