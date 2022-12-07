package com.example.swapno_samity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemberRegistration extends AppCompatActivity {

    private EditText etName, etEmail, etDob, etPhoneNumber, etAddress, etIdCard, etPenCard, etAdarCard, etAmountOfLoan, etInterest, etCurrentDate;
    private RadioGroup radioGroupGender;
    private RadioButton etGender;

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference rootReference;
    public DatabaseReference memberReference;
    String memberId;
    String currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_registration);

        getSupportActionBar().setTitle("Registration Form");
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
        radioGroupGender = findViewById(R.id.radio_group_register_gender);
        radioGroupGender.clearCheck();
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                etGender = radioGroupGender.findViewById(checkedId);
            }
        });

        Button registerMember = findViewById(R.id.button_register);
        registerMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                String textInterest = etInterest.getText().toString();
                String textGender = etGender.getText().toString();

                // validation Mobile number using Matcher and pattern(regular expression)
                String mobileRegex = "[6-9][0-9]{9}";
                Matcher mobileMatcher;
                Pattern mobilePattern = Pattern.compile(mobileRegex);
                mobileMatcher = mobilePattern.matcher(textPhoneNumber);

                //Current Date pick
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy ");
                currentDate = simpleDateFormat.format(calendar.getTime());

                if (TextUtils.isEmpty(textName)) {
                    Toast.makeText(MemberRegistration.this, "Please Enter Your Full Name", Toast.LENGTH_SHORT).show();
                    etName.setError("Full Name Required");
                    etName.requestFocus();
                }
                if (TextUtils.isEmpty(textDob)) {
                    Toast.makeText(MemberRegistration.this, "Please Enter Date Of Birthday", Toast.LENGTH_SHORT).show();
                    etDob.setError("Date Of Birthday Required");
                    etDob.requestFocus();
                }
                if (TextUtils.isEmpty(textAdress)) {
                    Toast.makeText(MemberRegistration.this, "Please Enter Right Address", Toast.LENGTH_SHORT).show();
                    etAddress.setError("Address Required");
                    etAddress.requestFocus();
                }
                if (radioGroupGender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(MemberRegistration.this, "Please Select The Gender", Toast.LENGTH_SHORT).show();
                    etGender.setError("Address Required");
                    etGender.requestFocus();
                }
                if (TextUtils.isEmpty(textPhoneNumber)) {
                    Toast.makeText(MemberRegistration.this, "Please Enter The Phone Number", Toast.LENGTH_SHORT).show();
                    etPhoneNumber.setError("Phone Number Required");
                    etPhoneNumber.requestFocus();
                } else if (!mobileMatcher.find()) {
                    Toast.makeText(MemberRegistration.this, "Please Enter The Phone Number", Toast.LENGTH_SHORT).show();
                    etPhoneNumber.setError("Phone Number is not valid");
                    etPhoneNumber.requestFocus();
                }
                if (textPhoneNumber.length() != 10) {
                    Toast.makeText(MemberRegistration.this, "Please Re-Enter The Phone Number", Toast.LENGTH_SHORT).show();
                    etPhoneNumber.setError("Phone Number Should be 10 Digits");
                    etPhoneNumber.requestFocus();
                }
                if (TextUtils.isEmpty(textAdarCard)) {
                    Toast.makeText(MemberRegistration.this, "Please Enter The Member Adar card Number", Toast.LENGTH_SHORT).show();
                    etAdarCard.setError("Member Adar card Number is Required");
                    etAdarCard.requestFocus();

                } else {
                    registerMemberUser(textName, textEmail, textDob, textGender, textAdress, textPhoneNumber, textIdCard, textPenCard, textAdarCard, textAmount, textInterest, currentDate);

                }

            }
        });
    }

    public void datePicker(View view) {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog pickerDialog = new DatePickerDialog(MemberRegistration.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                etDob.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        }, year, month, day);
        pickerDialog.show();
    }

    public void registerMemberUser(String textName, String textEmail, String textDob, String textGender, String textAdress, String textPhoneNumber, String textIdCard, String textPenCard, String textAdarCard, String textAmount, String textInterest, String currentDate) {

//      Data connection with realtime database
        firebaseDatabase = FirebaseDatabase.getInstance();
        rootReference = firebaseDatabase.getReference();
        memberReference = rootReference.child("Member Register Activity");
        memberId = memberReference.push().getKey();
        ReadWriteDetails readWriteDetails = new ReadWriteDetails(memberId, textName, textEmail, textDob, textGender, textAdress, textPhoneNumber, textIdCard, textPenCard, textAdarCard, textAmount, textInterest, currentDate);
        memberReference.child(memberId).setValue(readWriteDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(MemberRegistration.this, "Sucessfully Completed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}