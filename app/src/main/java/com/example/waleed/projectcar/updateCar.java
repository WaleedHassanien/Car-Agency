package com.example.waleed.projectcar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by waleed on 5/9/2017.
 */
public class updateCar extends AppCompatActivity {
    EditText nameCar,priceCar,kindCar,madeInCar,modelCar;
    Button update;
    DB_manager database;
    SQLiteDatabase db;
    Cursor cur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_car);
        nameCar=(EditText)findViewById(R.id.NamecartoUpdateCar);
        priceCar =(EditText)findViewById(R.id.priceCarToUpdateCar);
        kindCar=(EditText)findViewById(R.id.kindCarToUpdateCar);
        madeInCar=(EditText) findViewById(R.id.madeINcarToUpdateCar);
        modelCar=(EditText)findViewById(R.id.modelcartoUpdateCar);
        update=(Button)findViewById(R.id.UpdateCarBButton);
        database=new DB_manager(updateCar.this);
        db=database.getWritableDatabase();
        cur=database.getcar(db,listview_update.carId);
        cur.moveToFirst();
        do{
            nameCar.setText( cur.getString(0));
            priceCar.setText(cur.getString(1));
            kindCar.setText(cur.getString(2));
            modelCar.setText(cur.getString(3));
            madeInCar.setText(cur.getString(4));

        }while (cur !=null && cur.moveToNext());

        update.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                String name=nameCar.getText().toString();
                String price =priceCar.getText().toString();
                String kind=kindCar.getText().toString();
                String mad=madeInCar.getText().toString();
                String model=modelCar.getText().toString();

                if(name.trim().equals("") || price.trim().equals("") || kind.trim().equals("") || mad.trim().equals("")||model.trim().equals("")) {

                    Toast.makeText(updateCar.this, "Field is required ", Toast.LENGTH_SHORT).show();
                }
                else {
                    database.updateCar(model,mad,kind,price,name,listview_update.carId);
                    Toast.makeText(updateCar.this, "has been updated successfuly", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(updateCar.this, admincontrolpanel.class);
                    startActivity(intent);
                }

            }
        });
    }
}
