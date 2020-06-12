package com.example.waleed.projectcar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by waleed on 5/9/2017.
 */
public class listView_DeleteCar extends AppCompatActivity {
    ListView listcar;
    DB_manager Database;
    SQLiteDatabase db;
    Cursor cur;
    ArrayList cars;
    static  int carId;
    static String nameCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_deletecar);
        listcar=(ListView)findViewById(R.id.listViewCardelete);
        Database=new DB_manager(listView_DeleteCar.this);


        //db=Database.getWritableDatabase();
        cur=Database.getCars();
        cars=new ArrayList();
        cur.moveToFirst();
        do{
            cars.add(cur.getString(0));

        }while (cur.moveToNext());
        final ArrayAdapter adapt=new ArrayAdapter(listView_DeleteCar.this,R.layout.support_simple_spinner_dropdown_item,cars);
        listcar.setAdapter(adapt);
        listcar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                carId=position+1;
                nameCar= (String) cars.get(position);

                Intent intent=new Intent(listView_DeleteCar.this,delete_Car.class);
                startActivity(intent);



            }
        });
    }
}
