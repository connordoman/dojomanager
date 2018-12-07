package com.fraservalleykarate.sensei.comp125dojomanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class StudentProfileActivity extends AppCompatActivity {

    private Student activeStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        setContentView(R.layout.activity_student_profile);
        getSupportActionBar().setTitle("Student Profile");

        Intent i = getIntent();
        activeStudent = (Student) i.getSerializableExtra("Student");

        TextView name = findViewById(R.id.profileName);
        name.setText(StudentAdapter.capitalize(activeStudent.firstName + " " + activeStudent.lastName));

        TextView belt = findViewById(R.id.profileBeltColour);
        belt.setText(StudentAdapter.capitalize(activeStudent.beltColour));

        TextView phonePref = findViewById(R.id.profilePhonePref);
        phonePref.setText(getResources().getString(R.string.phone_primary) + ":\n" + activeStudent.phonePref);

        TextView phoneSec = findViewById(R.id.profilePhoneSec);
        phoneSec.setText(getResources().getString(R.string.phone_secondary) + ":\n" + activeStudent.phoneSec);

        TextView emailPref = findViewById(R.id.profileEmailPref);
        emailPref.setText(getResources().getString(R.string.email_primary) + ":\n" + activeStudent.emailPref);

        TextView emailSec = findViewById(R.id.profileEmailSec);
        emailSec.setText(getResources().getString(R.string.email_secondary) + ":\n" + activeStudent.emailSec);

        TextView prefMethod = findViewById(R.id.profileContactMethod);
        prefMethod.setText(getResources().getString(R.string.preferred_contact) + ":\n" + StudentAdapter.capitalize(activeStudent.contactPref));

        TextView address = findViewById(R.id.profileAddress);
        address.setText(getResources().getString(R.string.address) + ":\n" + StudentAdapter.capitalize(activeStudent.address));

        TextView birthdate = findViewById(R.id.profileBirthdate);
        birthdate.setText(getResources().getString(R.string.birthdate) + ":\n" + activeStudent.birthdate);

        TextView parents = findViewById(R.id.profileParents);
        parents.setText(getResources().getString(R.string.parent_names) + ":\n" + StudentAdapter.capitalize(activeStudent.parents));


        FloatingActionButton del = findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new StudentAsyncTask(StudentProfileActivity.this, activeStudent, true).execute();
            }
        });
    }
}
