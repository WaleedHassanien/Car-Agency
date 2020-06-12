package com.example.waleed.projectcar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by waleed on 5/9/2017.
 */
public class delete_Car extends AppCompatActivity {
Button Delete;
    EditText name;
    DB_manager database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_car);
        name=(EditText) findViewById(R.id.NamecartodeleteCar);
        name.setText("Name :"+listView_DeleteCar.nameCar);
        Delete=(Button)findViewById(R.id.deletecarbutton);
        database =new DB_manager(this);

        Delete.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {


                database.delete_car( listView_DeleteCar.carId);

                Intent intent=new Intent(delete_Car.this,admincontrolpanel.class);

                Toast.makeText(delete_Car.this, " deleted  successfuly", Toast.LENGTH_SHORT).show();

                startActivity(intent);


            }
        });
    }
}
