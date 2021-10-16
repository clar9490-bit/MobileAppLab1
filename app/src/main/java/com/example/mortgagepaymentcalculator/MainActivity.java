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

    //on the calculate click
    public void calcButtonClick (View view){

    //for each input use edit text to get the input from user and save it to a double variable
    EditText mpaTxt = findViewById(R.id.mpaTxt);
    double mpaDouble = Double.parseDouble(mpaTxt.getText().toString());

    //System.out.println(mpaDouble); system.out.println were used for the testing process of the app

    EditText irTxt = findViewById(R.id.irTxt);
    double irDouble = Double.parseDouble(irTxt.getText().toString());
    irDouble= irDouble * 0.01; //convert intrest rate to a percentage value
    //System.out.println(irDouble);

    EditText apTxt = findViewById(R.id.apTxt);
    double apDouble = Double.parseDouble(apTxt.getText().toString());

    //for to get the yearly ap multiply monthly by 12
    double n = apDouble * 12;

    //preform exponetial math for easier calculation
    double exp = (double) Math.pow((1+irDouble),n);

    //main math calculation
    double total = (mpaDouble*(exp)*irDouble )/ (exp - 1 );

    //format the answer
        DecimalFormat frmt = new DecimalFormat();
        frmt.setMaximumFractionDigits(2);
        frmt.format(total);

    //save total as a new double
    Double d = new Double (frmt.format(total));
    System.out.println(total);

    //test of output //original output before intent
    //TextView totalTxt = findViewById(R.id.editTextName);
    //totalTxt.setText(d.toString());

    //create intent
    Intent myIntent = new Intent(MainActivity.this,myReceiver.class);
    //set resulting total to the data for intent
    myIntent.setData(Uri.parse(d.toString()));
    //begin the activity for the received page
    startActivity(myIntent);

    }

}



