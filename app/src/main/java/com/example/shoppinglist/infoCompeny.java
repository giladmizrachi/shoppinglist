package com.example.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class infoCompeny extends AppCompatActivity implements View.OnClickListener {

    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_compeny);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
    if(btnBack == v)
    {
        Intent intent = new Intent(infoCompeny.this, MainActivity.class);
        startActivity(intent);
    }
    }
}