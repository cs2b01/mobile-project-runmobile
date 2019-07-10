package com.example.runandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;

public class CourseActivity extends AppCompatActivity {
    public JSONArray elements;
    private Context context;
    TextView first_line, second_line;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        //String username = getIntent().getExtras().get("username").toString();
        //setTitle("@"+username);
        first_line = findViewById(R.id.element_view_first_line);
        second_line = findViewById(R.id.element_view_second_line);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final String descripcion = getIntent().getExtras().get("descripcion").toString();
        final String horario = getIntent().getExtras().get("horario").toString();

        first_line.setText(descripcion);
        second_line.setText(horario);
    }
}
