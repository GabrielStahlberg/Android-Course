package com.example.contactslist;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(@Nullable Bundle saveInstanceState) {
    super.onCreate(saveInstanceState);
    setContentView(R.layout.activity_main);

    List<String> students = new ArrayList<>(Arrays.asList("Alex", "Smith", "John"));

    TextView first = findViewById(R.id.textView);
    TextView second = findViewById(R.id.textView2);
    TextView third = findViewById(R.id.textView3);

    first.setText(students.get(0));
    second.setText(students.get(1));
    third.setText(students.get(2));

  }

}
