package com.example.mortgagepaymentcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void calcButtonClick (View view){
    EditText mpaTxt = findViewById(R.id.mpaTxt);
    double mpaDouble = Double.parseDouble(mpaTxt.getText().toString());

        System.out.println(mpaDouble);
    EditText irTxt = findViewById(R.id.irTxt);
    double irDouble = Double.parseDouble(irTxt.getText().toString());
    irDouble= irDouble * 0.01;
    System.out.println(irDouble);

    EditText apTxt = findViewById(R.id.apTxt);
    double apDouble = Double.parseDouble(apTxt.getText().toString());

    double n = apDouble * 12;

    double exp = (double) Math.pow((1+irDouble),n);

    double total = (mpaDouble*(exp)*irDouble )/ (exp - 1 );
        DecimalFormat frmt = new DecimalFormat();
        frmt.setMaximumFractionDigits(2);
        frmt.format(total);

    Double d = new Double (frmt.format(total));
    System.out.println(total);
    //TextView totalTxt = findViewById(R.id.editTextName);
    //totalTxt.setText(d.toString());
    Intent myIntent = new Intent(MainActivity.this,myReceiver.class);
    myIntent.setData(Uri.parse(d.toString()));
    startActivity(myIntent);

    }

}



