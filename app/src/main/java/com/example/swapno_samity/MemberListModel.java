package com.example.swapno_samity;

public class MemberListModel {
    String name;
    String amount;
    String interest;

    public MemberListModel() {
    }

    public MemberListModel(String name, String amount, String interest) {
        this.name = name;
        this.amount = amount;
        this.interest = interest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String loan) {
        this.amount = loan;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
