package com.example.changingactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class AddStudentActivity extends AppCompatActivity {

    public static final String EXTRA_STUDENT = "student";
    private EditText firstName;
    private EditText lastName;
    private EditText surName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        surName = findViewById(R.id.sur_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_student, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_save:
                Student student = new Student();
                student.firstName = firstName.getText().toString();
                student.lastName = lastName.getText().toString();
                student.surName = surName.getText().toString();

                Intent data = new Intent();
                data.putExtra(EXTRA_STUDENT, student);
                setResult(RESULT_OK, data);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
