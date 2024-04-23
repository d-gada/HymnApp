package com.example.dadishymns;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText number_input, title_input, favorite_input, content_input;
    Button update_button, delete_button;

    String id, number, title, favorite, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        number_input = findViewById(R.id.number_input2);
        title_input = findViewById(R.id.title_input2);
        content_input = findViewById(R.id.content_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                DBHandler myDB = new DBHandler(UpdateActivity.this);

                number = number_input.getText().toString().trim();
                title = title_input.getText().toString().trim();
//                favorite = favorite_input.getText().toString().trim();
                content = content_input.getText().toString().trim();
                //myDB.updateData(id, number, title, favorite, content);
                myDB.updateData(id, number, title, content);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
                getIntent().hasExtra("author") && getIntent().hasExtra("pages")){
            //Getting Data from Intent
            number = getIntent().getStringExtra("number");
            title = getIntent().getStringExtra("title");
//            favorite = getIntent().getStringExtra("favorite");
            content = getIntent().getStringExtra("content");

            //Setting Intent Data
            number_input.setText(number);
            title_input.setText(title);
//            favorite_input.setText(favorite);
            content_input.setText(content);
            Log.d("stev", number + " " + title+" "+content);
//            Log.d("stev", number + " " + title+" "+favorite+" "+content);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + title + " ?");
        builder.setMessage("Are you sure you want to delete " + title + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBHandler myDB = new DBHandler(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}