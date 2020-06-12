package com.example.waleed.projectcar;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by waleed on 5/7/2017.
 */
public class car_Details extends AppCompatActivity {
    ListView listcar;
    Button Buy;
    DB_manager Database;
    SQLiteDatabase db;
    ArrayList list;
    Cursor cur;
car car;
    static String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_details);
        listcar =(ListView)findViewById(R.id.listViewCar);
        Buy=(Button)findViewById(R.id.buttonbuyCar);
        Bundle extras = getIntent().getExtras();
        if (extras == null)
        {
            return;
        }
        int res = extras.getInt("resourseInt");
        ImageView cars =(ImageView)findViewById(R.id.imageViewcar);
        cars.setImageResource(res);


        Buy.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(car_Details.this,loginCustomer.class);
                startActivity(intent);
            }
        });
        Database=new DB_manager(car_Details.this);
        db=Database.getWritableDatabase();
        cur=Database.getcar(db,MainActivity.carId);
        list=new ArrayList();
        cur.moveToFirst();
        do{
            list.add(cur.getString(0));
            list.add(cur.getString(1));
            list.add(cur.getString(2));
            list.add(cur.getString(3));
            list.add(cur.getString(4));
            price=cur.getString(2);


        }while ( cur != null &&cur.moveToNext());
        final ArrayAdapter adapt=new ArrayAdapter(car_Details.this,R.layout.support_simple_spinner_dropdown_item,list);
        listcar.setAdapter(adapt);

    }
}
