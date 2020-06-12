package com.example.waleed.projectcar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    ListView list;
    static public int carId;
    String[] web = {
            "verna",
            "marcedce  ",
            "Bmw",
            "Hendae",
            "nessan",
            "scoda",
            "chevorelate"
    } ;
    Integer[] imageId = {
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
            R.drawable.car1

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomList adapter = new
                CustomList(MainActivity.this, web, imageId);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                carId=position+1;
                Intent intent=new Intent(MainActivity.this,car_Details.class);
                if(carId==1) intent.putExtra("resourseInt", R.drawable.a1);
              else  if(carId==2) intent.putExtra("resourseInt", R.drawable.a2);
                else if(carId==3) intent.putExtra("resourseInt", R.drawable.a3);
                else if(carId==4) intent.putExtra("resourseInt", R.drawable.a4);
                else if(carId==5) intent.putExtra("resourseInt", R.drawable.a5);
                else if(carId==6) intent.putExtra("resourseInt", R.drawable.a6);
                else if(carId==7) intent.putExtra("resourseInt", R.drawable.car1);

                startActivity(intent);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_menu, menu);//Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent=new Intent(MainActivity.this,loginadmin.class);
                 startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

