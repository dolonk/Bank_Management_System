package com.example.swapno_samity;

import android.content.Context;
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
    private ArrayList<MemberListModel> memberList;

    MemberListViewAdapter(Context context, ArrayList<MemberListModel> memberList) {

        this.context = context;
        this.memberList = memberList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.memberlist_singel_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MemberListModel memberListModel = memberList.get(position);
        holder.txtName.setText(memberListModel.getName());
        holder.txtLoan.setText(memberListModel.getAmount());
        holder.txtInterest.setText(memberListModel.getInterest());
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtLoan,txtInterest;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.memberListName_ID);
            txtLoan = itemView.findViewById(R.id.memberListLoan_Id);
            txtInterest = itemView.findViewById(R.id.memberListInterest_Id);
        }
    }
}
