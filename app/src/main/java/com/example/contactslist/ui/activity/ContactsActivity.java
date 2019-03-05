package com.example.contactslist.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.contactslist.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle saveInstanceState) {
    super.onCreate(saveInstanceState);
    setContentView(R.layout.activity_contacts);
    setTitle("Contacts");
    List<String> students = new ArrayList<>(Arrays.asList("Alex", "Smith", "John", "Eric", "Maxell"));

    ListView studentsList = findViewById(R.id.activity_contacts_list);
    studentsList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students));
  }

}