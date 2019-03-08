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

import static com.example.contactslist.ui.activity.ActivitiesConst.KEY_STUDENT;

public class FormStudentActivity extends AppCompatActivity {

  public static final String APP_BAR_TITLE_NEW = "Novo Aluno";
  public static final String APP_BAR_TITLE_EDIT = "Edita Aluno";
  private EditText fieldName;
  private EditText fieldPhone;
  private EditText fieldEmail;
  final StudentDao dao = new StudentDao();
  private Student student;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_form_student);


    init();

    configBtnSave();

    loadStudent();
  }

  private void loadStudent() {
    Intent datas = getIntent();

    if(datas.hasExtra(KEY_STUDENT)) {
      setTitle(APP_BAR_TITLE_EDIT);

      this.student = (Student) datas.getSerializableExtra("student");

      fillsField();

    } else {
      setTitle(APP_BAR_TITLE_NEW);
      this.student = new Student();
    }
  }

  private void fillsField() {
    fieldName.setText(student.getName());
    fieldPhone.setText(student.getPhone());
    fieldEmail.setText(student.getEmail());
  }


  private void configBtnSave() {
    Button buttonSave = findViewById(R.id.activity_form_student_button_save);
    buttonSave.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finishForm();
      }
    });
  }

  private void finishForm() {
    fillsStudent();
    if(student.hasValidId()) {
      dao.edit(student);
    } else {
      dao.save(student);
    }
    finish();
  }

  private void init() {
    fieldName = findViewById(R.id.activity_form_student_name);
    fieldPhone = findViewById(R.id.activity_form_student_phone);
    fieldEmail = findViewById(R.id.activity_form_student_email);
  }

  private void fillsStudent() {
    String name = fieldName.getText().toString();
    String phone = fieldPhone.getText().toString();
    String email = fieldEmail.getText().toString();

    this.student.setName(name);
    this.student.setPhone(phone);
    this.student.setEmail(email);
  }
}
