package com.example.waleed.projectcar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by waleed on 5/16/2017.
 */
public class delete_customer extends AppCompatActivity{


    Button Delete;
    EditText name;
    DB_manager database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_customer);
        name=(EditText) findViewById(R.id.NameCustomertodeleteCustomer);
        name.setText("Name : "+listview_AllCustomer.nameCustomer);
        Delete=(Button)findViewById(R.id.ButtonCustomertodeleteCustomer);
        database =new DB_manager(this);

        Delete.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {


                database.delete_Customer( listview_AllCustomer.customerId);

                Intent intent=new Intent(delete_customer.this,admincontrolpanel.class);

                Toast.makeText(delete_customer.this, " deleted  successfuly", Toast.LENGTH_SHORT).show();

                startActivity(intent);


            }
        });
    }
}
