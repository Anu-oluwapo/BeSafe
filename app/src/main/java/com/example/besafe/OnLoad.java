package com.example.besafe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class OnLoad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_on_load);

        ImageView imageView = findViewById(R.id.imageView);
        Animation freedom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        imageView.startAnimation(freedom);

        TextView textView = findViewById(R.id.load_text);
        Animation text = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        textView.startAnimation(text);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(OnLoad.this,MainActivity.class);
                startActivity(intent);
            }
        },4000);

    }
}
