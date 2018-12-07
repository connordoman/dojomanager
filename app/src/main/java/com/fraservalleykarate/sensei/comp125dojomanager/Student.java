package com.fraservalleykarate.sensei.comp125dojomanager;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "students")
public class Student implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "student_id")
    public int student_id;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "birthdate")
    public String birthdate;

    @ColumnInfo(name = "email_pref")
    public String emailPref;

    @ColumnInfo(name = "email_sec")
    public String emailSec;

    @ColumnInfo(name = "phone_pref")
    public String phonePref;

    @ColumnInfo(name = "phone_sec")
    public String phoneSec;

    @ColumnInfo(name = "parents")
    public String parents;

    @ColumnInfo(name = "preferred_contact")
    public String contactPref;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "belt_colour")
    public String beltColour;
}
