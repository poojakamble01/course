package com.example.coursewithdb;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CourseList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databasereference;
    myAdapter adapter;
    ArrayList<HelperClass> list;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(CourseList.this,MainActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        recyclerView =findViewById(R.id.courseList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databasereference = FirebaseDatabase.getInstance().getReference("Course");

        list = new ArrayList<>();

        adapter = new myAdapter(this,list);
        recyclerView.setAdapter(adapter);



        databasereference.addValueEventListener(new ValueEventListener() {



            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    HelperClass helperClass = dataSnapshot.getValue(HelperClass.class);
                    list.add(helperClass);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


}