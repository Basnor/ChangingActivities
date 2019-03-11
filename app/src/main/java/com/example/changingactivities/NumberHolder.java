package com.example.changingactivities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class NumberHolder extends RecyclerView.ViewHolder {

    public final TextView number;

    public NumberHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_number, parent, false));
        this.number = itemView.findViewById(R.id.number);
    }
}