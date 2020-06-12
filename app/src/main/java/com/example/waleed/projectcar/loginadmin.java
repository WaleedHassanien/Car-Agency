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
public class loginadmin extends AppCompatActivity {
    Button login;
    EditText Email;
    EditText password;
    DB_manager database;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginadmin);
        login=(Button)findViewById(R.id.loginadmin);
        Email=(EditText)findViewById(R.id.EditEmail);
        password=(EditText)findViewById(R.id.Editpassword);
        database =new DB_manager(loginadmin.this);

        login.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {

                String name= Email.getText().toString();
                String Pass=password.getText().toString();
                db=database.getWritableDatabase();
                database.checkAdmin(db,name,Pass);
                if ( database.checkAdmin(db,name,Pass) == true)
                {
                    Intent intent=new Intent(loginadmin.this,admincontrolpanel.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(loginadmin.this," password or userName  is invalade ",Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}
