package com.example.waleed.projectcar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by waleed on 5/6/2017.
 */
public class buycar extends AppCompatActivity {
    Button buy;
    EditText visa,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buycar);
        buy=(Button)findViewById(R.id.buttonbuyCar);
        visa=(EditText)findViewById(R.id.visaNumberbuy);
        price=(EditText)findViewById(R.id.pricebuyCar);
        price.setText( " Price  :"+car_Details.price);
        price.setEnabled(false);
        buy.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                Toast.makeText(buycar.this,"successfuly procced ",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(buycar.this,MainActivity.class);
                startActivity(intent);




            }
        });
    }
}
