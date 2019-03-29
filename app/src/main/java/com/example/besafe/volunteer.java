package com.example.besafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class volunteer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);

        CardView cardView =  findViewById(R.id.blogger);
        CardView dataanalyst = findViewById(R.id.data_analyst);
        CardView graphic = findViewById(R.id.graphic);
        CardView social = findViewById(R.id.socialmedia);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(volunteer.this, VolunteerForm.class);
                startActivity(intent);
            }
        });

        dataanalyst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(volunteer.this, VolunteerForm.class);
                startActivity(intent);
            }
        });

        graphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(volunteer.this, VolunteerForm.class);
                startActivity(intent);
            }
        });

        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(volunteer.this, VolunteerForm.class);
                startActivity(intent);
            }
        });
    }
}
