package com.example.swapno_samity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MemberDetailsActivity extends AppCompatActivity {
    private TextView etName, etEmail, etDob, etGender, etPhoneNumber, etAddress, etIdCard, etPenCard, etAdarCard, etAmountOfLoan, etInterest, etCurrentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_details);
        etName = findViewById(R.id.textNameID);
        etEmail = findViewById(R.id.textEmailId);
        etDob = findViewById(R.id.textDobID);
        etGender = findViewById(R.id.textGenderID);
        etPhoneNumber = findViewById(R.id.textPhoneNumberID);
        etAddress = findViewById(R.id.textAddressID);
        etIdCard = findViewById(R.id.textIdCardID);
        etPenCard = findViewById(R.id.textPenCardID);
        etAdarCard = findViewById(R.id.textAdarCardID);
        etAmountOfLoan = findViewById(R.id.textAmountID);
        etInterest = findViewById(R.id.textInterestID);
        etCurrentDate = findViewById(R.id.textCurrentPickDateID);

        Intent data = getIntent();
        String name= data.getStringExtra("NAME");
        String email= data.getStringExtra("EMAIL");
        String dob= data.getStringExtra("DOB");
        String gender= data.getStringExtra("GENDER");
        String address= data.getStringExtra("ADDRESS");
        String phoneNumber= data.getStringExtra("PHONE_NUMBER");
        String idCard= data.getStringExtra("ID_CARD");
        String penCard= data.getStringExtra("PEN_CARD");
        String adarCard= data.getStringExtra("ADAR_CARD");
        String amount= data.getStringExtra("AMOUNT");
        String interest= data.getStringExtra("INTEREST");
        String loanPickDate= data.getStringExtra("LOAN_PICK_DATE");

        etName.setText(name);
        etEmail.setText(email);
        etDob.setText(dob);
        etGender.setText(gender);
        etAddress.setText(address);
        etPhoneNumber.setText(phoneNumber);
        etIdCard.setText(idCard);
        etPenCard.setText(penCard);
        etAdarCard.setText(adarCard);
        etAmountOfLoan.setText(amount);
        etInterest.setText(interest);
        etCurrentDate.setText(loanPickDate);

    }
}