package com.example.contactslist.dao;

import com.example.contactslist.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

  private final static List<Student> students = new ArrayList<>();

  public void save(Student student) {
    students.add(student);
  }

  public List<Student> findAll() {
    return new ArrayList<>(students);
  }
}
