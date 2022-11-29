package com.example.swapno_samity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MemberRegistration extends AppCompatActivity {

    private EditText etName, etEmail, etDob, etPhoneNumber, etAddress, etIdCard, etPenCard, etAdarCard, etAmountOfLoan, etInterest;
//    private RadioGroup radioGroupGender; //radioGroupInterest;
//    private RadioButton radioButtonGender; //radioButtonInterestOfLoan;

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference rootReference;
    public DatabaseReference memberReference;
    String memberId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_registration);
        getSupportActionBar().setTitle("Registration Form");

        firebaseDatabase = FirebaseDatabase.getInstance();
        rootReference = firebaseDatabase.getReference();
        memberReference = rootReference.child("Member Register Activity");

        //Toast.makeText(this, "You Can Member Registration Now ", Toast.LENGTH_SHORT).show();
        etName = findViewById(R.id.editText_register_full_name);
        etEmail = findViewById(R.id.editText_register_email);
        etDob = findViewById(R.id.editText_register_dob);
        etPhoneNumber = findViewById(R.id.editText_register_mobile);
        etAddress = findViewById(R.id.editText_register_adress);
        etIdCard = findViewById(R.id.editText_register_IdCard);
        etPenCard = findViewById(R.id.editText_register_PenCard);
        etAdarCard = findViewById(R.id.editText_register_AdarCard);
        etAmountOfLoan = findViewById(R.id.editText_register_AmountOfLoan);
        etInterest = findViewById(R.id.editText_register_interestOfLoan);
//        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
//        radioButtonGender = findViewById(selectedGenderId);

    }

    public void registerMember(View view) {




        // obtain the entered data
        String textName = etName.getText().toString();
        String textEmail = etEmail.getText().toString();
        String textDob = etDob.getText().toString();
        String textAdress = etAddress.getText().toString();
        String textPhoneNumber = etPhoneNumber.getText().toString();
        String textIdCard = etIdCard.getText().toString();
        String textPenCard = etPenCard.getText().toString();
        String textAdarCard = etAdarCard.getText().toString();
        String textAmount = etAmountOfLoan.getText().toString();
        String textInterest = etAdarCard.getText().toString();

       // String texGender = radioButtonGender.getText().toString();


        memberId = memberReference.push().getKey();
        ReadWriteDetails readWriteDetails = new ReadWriteDetails(memberId, textName, textEmail, textDob, textAdress, textPhoneNumber, textIdCard, textPenCard, textAdarCard, textAmount, textInterest);
        memberReference.child(memberId).setValue(readWriteDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(MemberRegistration.this, "Sucessfully Completed", Toast.LENGTH_SHORT).show();
            }
        });

    }

}