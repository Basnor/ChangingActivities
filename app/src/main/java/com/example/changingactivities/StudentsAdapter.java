package com.example.changingactivities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_NUMBER = 0;
    public static final int TYPE_STUDENT = 1;

    private List<Student> students = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_NUMBER:
                return new NumberHolder(parent);
            case TYPE_STUDENT:
                return new StudentHolder(parent);
        }
        throw new IllegalArgumentException("unknown viewType = " + viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_NUMBER:
                NumberHolder numberHolder = (NumberHolder) holder;
                numberHolder.number.setText(String.valueOf((position + 1) / 2 + 1));
                break;
            case TYPE_STUDENT:
                StudentHolder studentHolder = (StudentHolder) holder;
                Student student = students.get(position / 2);
                studentHolder.student.setText(student.lastName + " " + student.firstName + " " + student.surName);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? TYPE_NUMBER : TYPE_STUDENT;
    }

    @Override
    public int getItemCount() {
        return students.size() * 2;
    }

    public void addItem(Student student) {
        students.add(student);
        notifyItemRangeInserted(students.size() * 2 - 2, 2);
    }
}
