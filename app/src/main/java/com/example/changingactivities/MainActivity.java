package com.example.changingactivities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView list;
    private FloatingActionButton fab;

    private NumbersAdapter numbersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(android.R.id.list);
        fab = findViewById(R.id.fab);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        list.setAdapter(numbersAdapter = new NumbersAdapter());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersAdapter.addItem();
                list.scrollToPosition(numbersAdapter.getItemCount() - 1);
            }
        });

    }
}
