package com.example.contactslist;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(@Nullable Bundle saveInstanceState) {
    super.onCreate(saveInstanceState);
    setContentView(R.layout.activity_main);

    List<String> students = new ArrayList<>(Arrays.asList("Alex", "Smith", "John", "Eric", "Maxell"));

    ListView studentsList = findViewById(R.id.activity_main_students_list);
    studentsList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students));
  }

}
