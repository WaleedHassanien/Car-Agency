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
public class listview_AllCustomer extends AppCompatActivity {
    ListView listCustomer;
    DB_manager Database;
    SQLiteDatabase db;
    Cursor cur;
    ArrayList allcustomer;
    static  int customerId;
    static String nameCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_allcustomer);
        listCustomer=(ListView)findViewById(R.id.listViewCustomerdelete);
        Database=new DB_manager(listview_AllCustomer.this);


//        db=Database.getWritableDatabase();
        cur=Database.getAllCustomer();
        allcustomer=new ArrayList();
        cur.moveToFirst();
        do{
            allcustomer.add(cur.getString(0));

        }while (cur.moveToNext());
        final ArrayAdapter adapt=new ArrayAdapter(listview_AllCustomer.this,R.layout.support_simple_spinner_dropdown_item,allcustomer);
        listCustomer.setAdapter(adapt);
        listCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                customerId=position+1;
                nameCustomer= (String) allcustomer.get(position);
                Intent intent=new Intent(listview_AllCustomer.this,delete_customer.class);
                startActivity(intent);



            }
        });

    }
}
