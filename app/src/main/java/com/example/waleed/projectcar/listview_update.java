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
public class listview_update extends AppCompatActivity {
    ListView listcar;
    DB_manager Database;
    SQLiteDatabase db;
    Cursor cur;
    ArrayList cars;
    static  int carId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_updatecar);
        listcar =(ListView)findViewById(R.id.listViewCarupdate);
        Database=new DB_manager(listview_update.this);


        //db=Database.getWritableDatabase();
        cur=Database.getCars();
        cars=new ArrayList();
        cur.moveToFirst();
        do{
            cars.add(cur.getString(0));

        }while (cur.moveToNext());
        final ArrayAdapter adapt=new ArrayAdapter(listview_update.this,R.layout.support_simple_spinner_dropdown_item,cars);
        listcar.setAdapter(adapt);

        listcar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                carId=position+1;
                Intent intent=new Intent(listview_update.this,updateCar.class);
                startActivity(intent);



            }
        });

    }
}
