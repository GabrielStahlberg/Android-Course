package com.example.contactslist.dao;

import android.support.annotation.Nullable;

import com.example.contactslist.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

  private final static List<Student> students = new ArrayList<>();
  private static int countIds = 1;

  public void save(Student student) {
    student.setId(countIds);
    students.add(student);
    countIds++;
  }

  public void edit(Student student) {
    Student studentFound = findStudentById(student);
    if(studentFound != null) {
      int studentPosition = students.indexOf(studentFound);
      students.set(studentPosition, student);
    }
  }

  @Nullable
  private Student findStudentById(Student student) {
    for(Student s : students) {
      if(s.getId() == student.getId()) {
        return s;
      }
    }
    return null;
  }

  public List<Student> findAll() {
    return new ArrayList<>(students);
  }

  public void remove(Student student) {
    Student studentFound = findStudentById(student);
    if(studentFound != null){
      students.remove(studentFound);
    }
  }
}
