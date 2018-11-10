package com.example.sois.healthcareapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    DbHelper db;
    Button search;
    EditText name;
    ListView myList;
    List item;
    String name1;
    int i;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final ListView myList = (ListView) findViewById(R.id.myList);


        final EditText name = (EditText) findViewById(R.id.name);
        final EditText emailid = (EditText) findViewById(R.id.emailid);
        final EditText doctorname = (EditText) findViewById(R.id.doctorname);
        final EditText city = (EditText) findViewById(R.id.city);
        final EditText password = (EditText) findViewById(R.id.password);
        String s1;


        Button search = (Button) findViewById(R.id.search);
        // Button next=(Button)findViewById(R.id.button6);

        SQLiteDatabase.CursorFactory context;
        db = new DbHelper(this);

        item = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
        myList.setAdapter(adapter);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DbHelper(getApplicationContext());
                String s1;
              // Button search  = search.getText().toString();
                s1=name.getText().toString();
                name1 = db.fetch(s1);
                if (name1 != null) {
                    Toast.makeText(getApplicationContext(), "Search successful ", Toast.LENGTH_LONG).show();

                    adapter.add(name1);
                } else
                    Toast.makeText(getApplicationContext(), "not successful  ", Toast.LENGTH_LONG).show();

            }
        });
    }
}




















