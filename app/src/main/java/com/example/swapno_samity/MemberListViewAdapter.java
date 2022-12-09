package com.example.swapno_samity;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemberListViewAdapter extends RecyclerView.Adapter<MemberListViewAdapter.MyViewHolder> {


    private Context context;
    private ArrayList<ReadWriteDetails> memberList;

    MemberListViewAdapter(Context context, ArrayList<ReadWriteDetails> memberList) {

        this.context = context;
        this.memberList = memberList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.memberlist_singel_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ReadWriteDetails memberListModel = memberList.get(position);
        holder.txtName.setText(memberListModel.getName());
        holder.txtLoan.setText(memberListModel.getAmount());
        holder.txtInterest.setText(memberListModel.getInterest());

        //Click Action Request.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MemberDetailsActivity.class);
                intent.putExtra("NAME", memberListModel.getName());
                intent.putExtra("EMAIL", memberListModel.getEmail());
                intent.putExtra("DOB", memberListModel.getDob());
                intent.putExtra("GENDER", memberListModel.getGender());
                intent.putExtra("ADDRESS", memberListModel.getAddress());
                intent.putExtra("PHONE_NUMBER", memberListModel.getPhoneNumber());
                intent.putExtra("ID_CARD", memberListModel.getIdCard());
                intent.putExtra("PEN_CARD", memberListModel.getPenCard());
                intent.putExtra("ADAR_CARD", memberListModel.getAdarCard());
                intent.putExtra("AMOUNT", memberListModel.getAmount());
                intent.putExtra("INTEREST", memberListModel.getInterest());
                intent.putExtra("LOAN_PICK_DATE", memberListModel.getCurrent_Date_Pick());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtLoan, txtInterest;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.memberListName_ID);
            txtLoan = itemView.findViewById(R.id.memberListLoan_Id);
            txtInterest = itemView.findViewById(R.id.memberListInterest_Id);
        }
    }
}
