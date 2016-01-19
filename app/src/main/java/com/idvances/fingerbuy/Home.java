package com.idvances.fingerbuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nicole on 2015/12/26.
 */
public class Home extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        Button hFoodBtn = (Button)findViewById(R.id.foodBtn);
        hFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(Home.this,Food.class);
                startActivity(it1);
            }
        });
        Button hClothBtn = (Button)findViewById(R.id.clothBtn);
        hClothBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2 = new Intent(Home.this,Cloth.class);
                startActivity(it2);
            }
        });
        Button hLiveBtn = (Button)findViewById(R.id.liveBtn);
        hLiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(Home.this,Live.class);
                startActivity(it1);
            }
        });
        Button hTransmitBtn = (Button)findViewById(R.id.transmitBtn);
        hTransmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(Home.this,Transmit.class);
                startActivity(it1);
            }
        });
        Button hEducationBtn = (Button)findViewById(R.id.educationBtn);
        hEducationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(Home.this,Education.class);
                startActivity(it1);
            }
        });
        Button hEntertainmentBtn = (Button)findViewById(R.id.entertainmentBtn);
        hEntertainmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(Home.this,Entertainment.class);
                startActivity(it1);
            }
        });
    }
}
