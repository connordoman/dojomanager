package com.fraservalleykarate.sensei.comp125dojomanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter {

    public StudentAdapter(Context context, ArrayList<Student> students) {
        super(context, 0, students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student stu = (Student) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_listitem, parent, false);
        }

        TextView stuName = convertView.findViewById(R.id.student_name);
        TextView stuEmail = convertView.findViewById(R.id.student_email);
        TextView stuBelt = convertView.findViewById(R.id.student_belt);

        stuName.setText(StudentAdapter.capitalize(stu.firstName + " " + stu.lastName));
        stuEmail.setText(stu.emailPref);
        stuBelt.setText(StudentAdapter.capitalize(stu.beltColour));
        return convertView;
    }

    public static String capitalize(String str) {
        String[] strArray = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String s : strArray) {
            String cap = s.substring(0, 1).toUpperCase() + s.substring(1);
            builder.append(cap + " ");
        }
        return builder.toString();
    }

}