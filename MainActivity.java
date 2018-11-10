package com.example.sois.healthcareapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     final  EditText  name = (EditText) findViewById(R.id.name);
      final  EditText password = (EditText) findViewById(R.id.password);
      Button login = (Button) findViewById(R.id.login);
        Button register = (Button) findViewById(R.id.register);

        db = new DbHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1= name.getText().toString();
                String s2 = password.getText().toString();
                boolean validate=db.validate(s1,s2);
                if(validate==true) {
                    Toast.makeText(MainActivity.this,"login successful",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), Main3Activity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"not successful",Toast.LENGTH_LONG).show();
                }
            }
        });



        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i= new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });

    }
}





























//String s1 = name.getText().toString();
                //String s2 = password.getText().toString();

                //if (db.insertRegistration(s1, s2) != -1) {
                    //Toast.makeText(getApplicationContext(), "Data inserted ", Toast.LENGTH_LONG).show();
                    //Toast.makeText(getApplicationContext(), "HEALTH IS WEALTH ", Toast.LENGTH_LONG).show();
                    //Toast.makeText(getApplicationContext(), "WELCOME ", Toast.LENGTH_LONG).show();
                    //EditText a = (EditText)findViewById(R.id.name);
                   // String str = a.getText().toString();
                    //Intent i = new Intent(MainActivity.this , Display.class);
                   // i.putExtra("name",str);
                    //startActivity(i);
                    //Log.i(TAG, "INSERTED");
                    //} else {
                    //     Log.i(TAG, "Failed");
                    // }
                //}













