package com.example.waleed.projectcar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by waleed on 5/6/2017.
 */
public class admincontrolpanel extends AppCompatActivity {

    Button addCar,deleteCar, updateCar,deleteCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controlpanal);
        addCar=(Button)findViewById(R.id.AddCar);
        deleteCar=(Button)findViewById(R.id.deleteCar);
        updateCar=(Button)findViewById(R.id.UpdateCar);
        deleteCustomer=(Button)findViewById(R.id.deletecustomer);
        addCar.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(admincontrolpanel.this,addCar.class);
                startActivity(intent);
            }
        });
        deleteCar.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(admincontrolpanel.this,listView_DeleteCar.class);
                startActivity(intent);
            }
        });
        updateCar.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(admincontrolpanel.this,listview_update.class);
                startActivity(intent);
            }
        });
        deleteCustomer.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(admincontrolpanel.this,listview_AllCustomer.class);
                startActivity(intent);
            }
        });

    }
}
