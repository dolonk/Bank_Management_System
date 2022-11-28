package com.example.swapno_samity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
    }

    public void membersEntry(View view) {
        Intent intent = new Intent(getApplicationContext(), Members.class);
        startActivity(intent);
    }

    public void loanSupply(View view) {
        Intent intent = new Intent(getApplicationContext(), LoanSupply.class);
        startActivity(intent);
    }

    public void collection(View view) {
        Intent intent = new Intent(getApplicationContext(), Collection.class);
        startActivity(intent);
    }

    public void savings(View view) {
        Intent intent = new Intent(getApplicationContext(), Savings.class);
        startActivity(intent);
    }

    public void staffManagement(View view) {
        Intent intent = new Intent(getApplicationContext(), StaffManagement.class);
        startActivity(intent);
    }

    public void serviceCharge(View view) {
        Intent intent = new Intent(getApplicationContext(), ServiceCharge.class);
        startActivity(intent);
    }
}