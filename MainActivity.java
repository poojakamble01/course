package com.example.coursewithdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.coursewithdb.HelperClass;
import com.example.coursewithdb.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {



    Button btnInsert,btnView;
    EditText name;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        btnInsert = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
        name = findViewById(R.id.editname);

        db = FirebaseDatabase.getInstance().getReference();


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertData();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CourseList.class));
                finish();
            }
        });
    }

    private void InsertData() {
        String courseName =name.getText().toString();
        String id = db.push().getKey();

        HelperClass helperClass = new HelperClass(courseName);
         db.child("Course").child(courseName).setValue(courseName)
                 .addOnCompleteListener(new OnCompleteListener<Void>() {
                     @Override
                     public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Data Inserted Successfully!!",Toast.LENGTH_SHORT).show();
                        }
                     }
                 });



    }

}