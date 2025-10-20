package com.pluralsight;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("-----Welcome to our hotel:------");
        System.out.println("Please Enter your name");
        String customerName = scanner.nextLine().trim();
        System.out.printf("%s, Please Enter How many days your stay is:",customerName);
        int days = scanner.nextInt();


    }
}