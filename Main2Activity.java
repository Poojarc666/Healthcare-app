package com.example.sois.healthcareapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText name, emailid, doctorname , city , password;
    Button ok,back;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = (EditText) findViewById(R.id.name);
        emailid = (EditText) findViewById(R.id.emailid);
        doctorname = (EditText)findViewById(R.id.doctorname);
        city = (EditText)findViewById(R.id.city);
        password = (EditText)findViewById(R.id.password);
        ok = (Button) findViewById(R.id.ok);
        back = (Button)findViewById(R.id.back);

        db = new DbHelper(this);

        ok.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String s1 = name.getText().toString();
                String s2 = emailid.getText().toString();
                String s3 = doctorname.getText().toString();
                String s4 = city.getText().toString();
                String s5 = password.getText().toString();
                boolean isInserted = db.insertcontact(s1,s2,s3,s4,s5);
                if(isInserted ==true)
                {
                    Toast.makeText(getApplicationContext(),"data is inserted ",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"data is not inserted ",Toast.LENGTH_LONG).show();
                }


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}









