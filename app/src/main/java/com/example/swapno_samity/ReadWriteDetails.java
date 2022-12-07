package com.example.swapno_samity;

public class ReadWriteDetails {
    private String id, name, email, dob, gender, address, phoneNumber, idCard, penCard, adarCard, amount, interest;
    private String current_Date_Pick;

    public ReadWriteDetails(String id, String name, String email, String dob, String gender, String address, String phoneNumber, String idCard, String penCard, String adarCard, String amount, String interest, String current_Date_Pick) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.idCard = idCard;
        this.penCard = penCard;
        this.adarCard = adarCard;
        this.amount = amount;
        this.interest = interest;
        this.current_Date_Pick = current_Date_Pick;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPenCard() {
        return penCard;
    }

    public void setPenCard(String penCard) {
        this.penCard = penCard;
    }

    public String getAdarCard() {
        return adarCard;
    }

    public void setAdarCard(String adarCard) {
        this.adarCard = adarCard;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getCurrent_Date_Pick() {
        return current_Date_Pick;
    }

    public void setCurrent_Date_Pick(String current_Date_Pick) {
        this.current_Date_Pick = current_Date_Pick;
    }
}
