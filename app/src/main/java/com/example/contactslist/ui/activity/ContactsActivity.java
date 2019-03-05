package com.example.contactslist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.contactslist.R;
import com.example.contactslist.dao.StudentDao;

public class ContactsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle saveInstanceState) {
    super.onCreate(saveInstanceState);
    setContentView(R.layout.activity_contacts);


    setTitle("Contacts");

    FloatingActionButton addStudent = findViewById(R.id.activity_contacts_new_student);
    addStudent.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(ContactsActivity.this, FormStudentActivity.class));
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();

    StudentDao dao = new StudentDao();

    ListView studentsList = findViewById(R.id.activity_contacts_list);
    studentsList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.findAll()));
  }
}
