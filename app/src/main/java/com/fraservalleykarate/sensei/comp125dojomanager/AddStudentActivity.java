package com.fraservalleykarate.sensei.comp125dojomanager;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class AddStudentActivity extends AppCompatActivity {

    private Student curStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        getSupportActionBar().setTitle("New Student");
        curStudent = new Student();
    }

    public void addStudent(View view) {
        EditText first_name = findViewById(R.id.firstName);
        EditText last_name = findViewById(R.id.lastName);
        EditText phone_pref = findViewById(R.id.phonePrimary);
        EditText phone_sec = findViewById(R.id.phoneSecondary);
        EditText email_pref = findViewById(R.id.emailPrimary);
        EditText email_sec = findViewById(R.id.emailSecondary);
        EditText address = findViewById(R.id.address);
        EditText birthdate = findViewById(R.id.birthdate);
        EditText parent_names = findViewById(R.id.parentNames);
        EditText belt_colour = findViewById(R.id.beltColour);

        RadioGroup pref_methods = findViewById(R.id.preferredMethodGroup);
        int selectedId = pref_methods.getCheckedRadioButtonId();
        RadioButton preferredMethod = findViewById(selectedId);

        curStudent.firstName = first_name.getText().toString();
        curStudent.lastName = last_name.getText().toString();
        curStudent.phonePref = phone_pref.getText().toString();
        curStudent.phoneSec = phone_sec.getText().toString();
        curStudent.emailPref = email_pref.getText().toString();
        curStudent.emailSec = email_sec.getText().toString();
        curStudent.address = address.getText().toString();
        curStudent.birthdate = birthdate.getText().toString();
        curStudent.parents = parent_names.getText().toString();
        curStudent.beltColour = belt_colour.getText().toString();
        curStudent.contactPref = preferredMethod.getText().toString();

        new StudentAsyncTask(this, curStudent).execute();
    }


}
