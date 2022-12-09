package com.example.swapno_samity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Members extends AppCompatActivity {

    private RecyclerView memberRecyclerView;
    MemberListViewAdapter memberListViewAdapter;
    ArrayList<ReadWriteDetails> memberList;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);
        memberRecyclerView = findViewById(R.id.memberRecyclerView_Id);


        memberList = new ArrayList<>();
        memberListViewAdapter = new MemberListViewAdapter(Members.this, memberList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        memberRecyclerView.setLayoutManager(linearLayoutManager);
        memberRecyclerView.setAdapter(memberListViewAdapter);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Member Register Activity");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ReadWriteDetails memberListModel = dataSnapshot.getValue(ReadWriteDetails.class);
                    memberList.add(memberListModel);
                    Toast.makeText(Members.this, "Successfully", Toast.LENGTH_SHORT).show();
                }
                memberListViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Members.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
