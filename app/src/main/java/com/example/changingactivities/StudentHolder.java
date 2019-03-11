package com.example.changingactivities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class StudentHolder extends RecyclerView.ViewHolder {

    public final TextView student;

    public StudentHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false));
        this.student = itemView.findViewById(R.id.student);
    }
}
