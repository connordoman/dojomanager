package com.fraservalleykarate.sensei.comp125dojomanager;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public final class StudentAsyncTask extends AsyncTask<Void, Void, Integer> {

    //Prevent leak
    private WeakReference<Activity> weakActivity;
    private Student limboStudent;
    private int previousCount;
    private boolean delete;

    public StudentAsyncTask(Activity activity, Student student) {
        weakActivity = new WeakReference<>(activity);
        this.limboStudent = student;
        this.delete = false;
    }

    public StudentAsyncTask(Activity activity, Student student, boolean delete) {
        this(activity, student);
        this.delete = delete;
    }

    @Override
    protected Integer doInBackground(Void... params) {
        StudentDao stuDao = StudentListAsyncTask.studentDatabase.stuDao();
        int alreadyExists = stuDao.studentCount(limboStudent.firstName, limboStudent.lastName, limboStudent.emailPref, limboStudent.emailSec);

        previousCount = alreadyExists;
        if (delete) {
            StudentListAsyncTask.studentDatabase.stuDao().delete(limboStudent);
            return -1;
        } else {
            StudentListAsyncTask.studentDatabase.stuDao().insertAll(limboStudent);
            return alreadyExists;
        }
    }

    @Override
    protected void onPostExecute(Integer agentsCount) {
        Activity activity = weakActivity.get();
        if(activity == null) {
            return;
        }

        System.out.println("agentsCount: " + agentsCount);

        if (agentsCount > 0) {
            Toast.makeText(activity, "Student already exists", Toast.LENGTH_SHORT).show();
        } else if (agentsCount == -1) {
            Toast.makeText(activity, "Student deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(activity, "Adding student...", Toast.LENGTH_SHORT).show();
        }
        activity.onBackPressed();
    }
}