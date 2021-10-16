package com.example.mortgagepaymentcalculator;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class myReceiver extends AppCompatActivity {
    TextView text; // save the text with a text view
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting content view of the new page /activity
        setContentView(R.layout.my_receiver);

        // set the text into the text view id
        text = findViewById(R.id.Welcome);

        //receive the Intent
        Intent myIntent = getIntent();

        //save incoming result
        String receiveMessage = myIntent.getDataString();

        //format the final result text
        text.setText("$ "+receiveMessage);

    }
}
