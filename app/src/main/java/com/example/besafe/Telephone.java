package com.example.besafe;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Telephone extends AppCompatActivity {
    EditText edtphncall;
    String telNum;
    Button btnphncall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone);
        edtphncall = findViewById(R.id.edtphncall);
        btnphncall = findViewById(R.id.btnphncall);
        btnphncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCall = new Intent(Intent.ACTION_CALL);
                telNum = edtphncall.getText().toString();
                if(telNum.trim().isEmpty()){
                    intentCall.setData(Uri.parse("tel:08119195235"));
                    //Toast.makeText(getApplicationContext(), "Please enter a number", Toast.LENGTH.SHORT).show();
                } else {
                    intentCall.setData(Uri.parse("tel:"+telNum));
                }
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getApplicationContext(),"Please grant permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                } else {
                    startActivity(intentCall);
                }
            }
        });
    }
    private void requestPermission(){
        ActivityCompat.requestPermissions(Telephone.this, new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
