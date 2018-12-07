package com.fraservalleykarate.sensei.comp125dojomanager;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.database.Cursor;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM students")
    List<Student> getAll();

    @Query("SELECT * FROM students WHERE student_id IN (:student_ids)")
    List<Student> loadAllByIds(int[] student_ids);

    @Query("SELECT * FROM students WHERE student_id LIKE :student_id LIMIT 1")
    Student findById(int student_id);

    @Query("SELECT * FROM students WHERE first_name LIKE :first AND last_name LIKE :last AND email_pref LIKE :email OR email_sec LIKE :email LIMIT 1")
    Student findByNameAndEmail(String first, String last, String email);

    @Query("SELECT COUNT(*) FROM students where first_name = :firstName AND last_name = :lastName AND (email_pref = :emailPref OR email_sec = :emailSec)")
    int studentCount(String firstName, String lastName, String emailPref, String emailSec);

    @Query("SELECT * FROM students")
    Cursor getCursorAll();

    @Insert
    void insertAll(Student... students);

    @Delete
    void delete(Student student);

}
