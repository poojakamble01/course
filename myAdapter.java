package com.example.coursewithdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

Context context;
ArrayList<HelperClass> list;

    public myAdapter(Context context, ArrayList<HelperClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        HelperClass helperClass = list.get(position);
        holder.txtCourse.setText(helperClass.getEditName());

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        TextView txtCourse;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCourse = itemView.findViewById(R.id.txtCourse);
        }
    }
}
