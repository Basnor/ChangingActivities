package com.example.changingactivities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView list;
    private FloatingActionButton fab;

    private StudentsAdapter studentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(android.R.id.list);
        fab = findViewById(R.id.fab);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        list.setAdapter(studentsAdapter = new StudentsAdapter());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getBaseContext(), AddStudentActivity.class), 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Student student = data.getParcelableExtra(AddStudentActivity.EXTRA_STUDENT);
            studentsAdapter.addItem(student);
            list.scrollToPosition(studentsAdapter.getItemCount() - 1);
        }
    }
}
