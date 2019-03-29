package com.example.besafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Sharepost extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    String[] postname = {"Sexual Harrasment", "Domestic violence", "Eve-teasing", "Stalking"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharepost);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter adapterspinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, postname);
        adapterspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterspinner);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), postname[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_post, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
