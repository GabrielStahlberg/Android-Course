package com.example.contactslist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.contactslist.R;
import com.example.contactslist.dao.StudentDao;
import com.example.contactslist.model.Student;

import java.io.Serializable;

public class FormStudentActivity extends AppCompatActivity {

  public static final String APP_BAR_TITLE = "Novo Aluno";
  private EditText fieldName;
  private EditText fieldPhone;
  private EditText fieldEmail;
  final StudentDao dao = new StudentDao();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_form_student);

    setTitle(APP_BAR_TITLE);

    init();

    configBtnSave();

    Intent datas = getIntent();
    Student student = (Student) datas.getSerializableExtra("student");

    fieldName.setText(student.getName());
    fieldPhone.setText(student.getPhone());
    fieldEmail.setText(student.getEmail());
  }

  private void configBtnSave() {
    Button buttonSave = findViewById(R.id.activity_form_student_button_save);
    buttonSave.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Student student = createStudent();
        save(student);
      }
    });
  }

  private void init() {
    fieldName = findViewById(R.id.activity_form_student_name);
    fieldPhone = findViewById(R.id.activity_form_student_phone);
    fieldEmail = findViewById(R.id.activity_form_student_email);
  }

  private void save(Student student) {
    dao.save(student);
    finish();
  }

  private Student createStudent() {
    String name = fieldName.getText().toString();
    String phone = fieldPhone.getText().toString();
    String email = fieldEmail.getText().toString();

    return new Student(name, phone, email);
  }
}
