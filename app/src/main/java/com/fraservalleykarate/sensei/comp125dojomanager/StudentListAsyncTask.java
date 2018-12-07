package com.fraservalleykarate.sensei.comp125dojomanager;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class StudentListAsyncTask extends AsyncTask<Void, Void, Integer> {

    public static AppDatabase studentDatabase;
    public WeakReference<Activity> activity;
    public ArrayList<Student> students;
    public StudentAdapter studentLister;

    public StudentListAsyncTask(Activity activity) {
        StudentListAsyncTask.studentDatabase = Room.databaseBuilder(activity.getApplicationContext(), AppDatabase.class, "student-list").build();
        this.activity = new WeakReference<>(activity);
        this.students = new ArrayList<>();
        studentLister = new StudentAdapter(this.activity.get(), this.students);
    }

    @Override
    public Integer doInBackground(Void... params) {
        this.students = new ArrayList<>(StudentListAsyncTask.studentDatabase.stuDao().getAll());
        return students.size();
    }

    @Override
    protected void onPostExecute(Integer numStudents) {
        if(activity == null) {
            return;
        }

        if (numStudents > 0) {
            //Toast.makeText(activity.get().getApplicationContext(), "Student list found", Toast.LENGTH_SHORT).show();
            studentLister.clear();
            studentLister.addAll(students);
            ListView list = activity.get().findViewById(R.id.student_list);
        } else {
            Toast.makeText(activity.get().getApplicationContext(), "No students found", Toast.LENGTH_SHORT).show();
        }
    }


}
