package com.example.mortgagepaymentcalculator;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class myReceiver extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_receiver);
        text = findViewById(R.id.Welcome);
        Intent myIntent = getIntent();
        String receiveMessage = myIntent.getDataString();
        text.setText("$ "+receiveMessage);

    }
}
