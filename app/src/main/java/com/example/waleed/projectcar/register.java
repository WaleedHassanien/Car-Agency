package com.example.waleed.projectcar;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by waleed on 5/6/2017.
 */
public class register extends AppCompatActivity {
    EditText Email,Password,Name,password,Visa;
    DB_manager database;
    SQLiteDatabase db;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Email=(EditText)findViewById(R.id.EditEmialCustomer);
        Name=(EditText)findViewById(R.id.EditNameCustomer);
        password=(EditText)findViewById(R.id.EditpasswordCustomer);
        Visa=(EditText)findViewById(R.id.EditVisaCustomer);
        register=(Button)findViewById(R.id.register);
        database=new DB_manager(register.this);
        db=database.getWritableDatabase();

        register.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                String name=Name.getText().toString();
                String pass=password.getText().toString();
                String email=Email.getText().toString();
                String visa=Visa.getText().toString();
                if(name.trim().equals("") || pass.trim().equals("") || email.trim().equals("") || visa.trim().equals("")) {

                    Toast.makeText(register.this, "Name  field is required ", Toast.LENGTH_SHORT).show();
                }
                else {
                    database.addcustomer(db, name, pass, email, visa);
                    Toast.makeText(register.this, "has been added successfuly", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(register.this, buycar.class);
                    startActivity(intent);
                }

            }
        });


    }
}
