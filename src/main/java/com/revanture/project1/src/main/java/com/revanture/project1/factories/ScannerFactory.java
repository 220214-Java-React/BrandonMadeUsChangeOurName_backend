package com.revanture.project1.factories;

import java.util.Scanner;

public class ScannerFactory {
    private static Scanner instance;

    public static Scanner getScanner(){
        if(instance == null){
            instance = new Scanner(System.in);
        }

        return instance;
    }

    private ScannerFactory(){}
}
