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
public class loginCustomer extends AppCompatActivity {
    Button login;
    Button register;
    EditText Email;
    EditText password;
    DB_manager database;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logincustomer);
        login=(Button)findViewById(R.id.logincustomer);
        register=(Button)findViewById(R.id.registerCustomer);
        Email=(EditText)findViewById(R.id.EditEmailCustomertologin);
        password=(EditText)findViewById(R.id.EditPasswordCustomerToLogin);
        database=new DB_manager(this);

        login.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {

                String name= Email.getText().toString();
                String Pass=password.getText().toString();
                db=database.getWritableDatabase();
                database.checkCustomer(db,name,Pass);
                if ( database.checkCustomer(db,name,Pass) == true)
                {
                    Intent intent=new Intent(loginCustomer.this,buycar.class);
                    startActivity(intent);
                }
                else {

                    Toast.makeText(loginCustomer.this," password or userName  is invalade ",Toast.LENGTH_SHORT).show();


                }


            }
        });
        register.setOnClickListener(new View.OnClickListener (){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginCustomer.this,register.class);
                startActivity(intent);


            }
        });

    }
}
