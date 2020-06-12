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
 * Created by waleed on 5/8/2017.
 */
public class addCar extends AppCompatActivity {

    EditText nameCar,priceCar,kindCar,madeInCar,modelCar;
    Button add;
    DB_manager database;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcars);
        nameCar=(EditText)findViewById(R.id.Namecartoadd);
        priceCar =(EditText)findViewById(R.id.priceCarToAddcar);
        kindCar=(EditText)findViewById(R.id.kindCarToAddcar);
        madeInCar=(EditText) findViewById(R.id.madeINcarToAddCar);
        modelCar=(EditText)findViewById(R.id.modelcartoadd);
        add=(Button)findViewById(R.id.addcarbutton);
        database=new DB_manager(addCar.this);
        db=database.getWritableDatabase();

        add.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                String name=nameCar.getText().toString();
                String price =priceCar.getText().toString();
                String kind=kindCar.getText().toString();
                String mad=madeInCar.getText().toString();
                String model=modelCar.getText().toString();
                if(name.trim().equals("") || price.trim().equals("") || kind.trim().equals("") || mad.trim().equals("")||model.trim().equals("")) {

                    Toast.makeText(addCar.this, "Field is required ", Toast.LENGTH_SHORT).show();
                }
                else {
                    database.addcar(db, name, price, kind, mad,model);
                    Toast.makeText(addCar.this, "has been added successfuly", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(addCar.this, admincontrolpanel.class);
                    startActivity(intent);
                }

            }
        });

    }
}
