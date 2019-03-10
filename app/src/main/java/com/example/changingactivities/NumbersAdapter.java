package com.example.changingactivities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class NumbersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int count;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NumberHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NumberHolder h = (NumberHolder) holder;
        h.number.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return count;
    }

    public void addItem() {
        count++;
        notifyItemInserted(count - 1);
    }
}
