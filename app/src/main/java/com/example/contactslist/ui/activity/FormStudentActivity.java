package com.example.contactslist.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.contactslist.R;
import com.example.contactslist.dao.StudentDao;
import com.example.contactslist.model.Student;

public class FormStudentActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_form_student);

    final StudentDao dao = new StudentDao();

    final EditText fieldName = findViewById(R.id.activity_form_student_name);
    final EditText fieldPhone = findViewById(R.id.activity_form_student_phone);
    final EditText fieldEmail = findViewById(R.id.activity_form_student_email);

    Button buttonSave = findViewById(R.id.activity_form_student_button_save);
    buttonSave.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String name = fieldName.getText().toString();
        String phone = fieldPhone.getText().toString();
        String email = fieldEmail.getText().toString();

        Student student = new Student(name, phone, email);
        dao.save(student);

        finish();
      }
    });
  }
}
