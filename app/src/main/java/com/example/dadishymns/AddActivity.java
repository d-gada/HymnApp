package com.example.dadishymns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText number_input, title_input, favorite_input, content_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        number_input = findViewById(R.id.author_input);
        title_input = findViewById(R.id.title_input);
        favorite_input = findViewById(R.id.pages_input);
        content_input = findViewById(R.id.pages_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler myDB = new DBHandler(AddActivity.this);
                myDB.addBook(
                        Integer.valueOf(number_input.getText().toString().trim()),
                        title_input.getText().toString().trim(),
                        Integer.valueOf(favorite_input.getText().toString().trim()),
                        content_input.getText().toString().trim());
            }
        });
    }
}