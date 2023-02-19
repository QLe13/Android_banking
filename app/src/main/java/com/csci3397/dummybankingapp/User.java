package com.csci3397.dummybankingapp;

import android.content.Intent;

public class User {

    private String userName;
    private String password;
    private String legalName;
    private String ssn;
    private String phoneNumber;
    private Double accountBalance;


    public User() {}
    public User(User other) {
        this.userName = other.userName;
        this.password = other.password;
        this.legalName = other.legalName;
        this.ssn = other.ssn;
        this.phoneNumber = other.phoneNumber;
        this.accountBalance = other.accountBalance;
    }

    public User(String userName, String password, String legalName, String ssn, String phoneNumber, Double accountBalance) {
        this.userName = userName;
        this.password = password;
        this.legalName = legalName;
        this.ssn = ssn;
        this.phoneNumber = phoneNumber;
        this.accountBalance = accountBalance;
    }

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public String getSsn() {
        return ssn;
    }
    public Double getBalance() {
        return accountBalance;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setBalance(Double n) {
        this.accountBalance = n;
    }


}

