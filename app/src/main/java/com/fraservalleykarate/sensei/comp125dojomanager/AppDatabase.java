package com.fraservalleykarate.sensei.comp125dojomanager;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.fraservalleykarate.sensei.comp125dojomanager.StudentDao;
import com.fraservalleykarate.sensei.comp125dojomanager.Student;

@Database(entities = {Student.class}, version = 1)
@TypeConverters({})
public abstract class AppDatabase extends RoomDatabase {
    public abstract StudentDao stuDao();
}
