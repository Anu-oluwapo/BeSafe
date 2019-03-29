package com.example.besafe;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class UserProfiles extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profiles);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager Pager = findViewById(R.id.viewpager);

        tabpagerAdapter Tabpageradapter = new tabpagerAdapter(getSupportFragmentManager());
        Pager.setAdapter(Tabpageradapter);
        tabLayout.setupWithViewPager(Pager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfiles.this, Sharepost.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_profiles, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.action_place){
            Intent place = new Intent(UserProfiles.this, Place.class);
            startActivity(place);
        }else if (id == R.id.action_phone) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:112"));

            if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                requestPermission();
            }else {
                startActivity(callIntent);
            }

        }

        return super.onOptionsItemSelected(item);
    }
    private void requestPermission(){
        ActivityCompat.requestPermissions(UserProfiles.this, new String[]{Manifest.permission.CALL_PHONE},1);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_help) {
            Intent help = new Intent(UserProfiles.this, Askhelp.class);
            startActivity(help);
        } else if (id == R.id.nav_campaign) {

        } else if (id == R.id.nav_volunteer) {
            Intent volunteer =new Intent(UserProfiles.this, volunteer.class);
            startActivity(volunteer);

        } else if (id == R.id.nav_contact) {
            Intent contact = new Intent(UserProfiles.this, Contact.class);
            startActivity(contact);

        } else if (id == R.id.nav_logout) {
            Intent logout = new Intent(UserProfiles.this, MainActivity.class);
            startActivity(logout);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
