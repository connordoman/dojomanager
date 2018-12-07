package com.fraservalleykarate.sensei.comp125dojomanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int ADD_STUDENT = 1;  // The request code


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Dojo Manager");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    moveToAddStudent();
                }
            });

        ListView list = findViewById(R.id.student_list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student stu = (Student) parent.getItemAtPosition(position);
                //Toast.makeText(MainActivity.this, "Clicked on \"" + stu.emailPref + "\"", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, StudentProfileActivity.class);
                i.putExtra("Student", stu);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        openStudents(this);
    }


    private void moveToAddStudent() {
        Intent intent = new Intent(this, AddStudentActivity.class);
        startActivityForResult(intent, ADD_STUDENT);
    }

    private void openStudents(Activity acv) {
        StudentListAsyncTask updated = (StudentListAsyncTask) new StudentListAsyncTask(acv).execute();
        ((ListView) findViewById(R.id.student_list)).setAdapter(updated.studentLister);
    }

    public void addStudent(Student s) {
        new StudentAsyncTask(this, s).execute();
    }
}
