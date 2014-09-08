package com.jhony.panataxi.panataxi;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

import java.util.Date;

import java.util.Date;

public class MainActivity extends FragmentActivity {

    public SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    private BackendControl controlObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), getApplicationContext());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_calculate:
                Intent dateHourIntent = new Intent(MainActivity.this, DateHourFragment.class);
                startActivity(dateHourIntent);

                Date travelHour;
                travelHour = (Date) getIntent().getExtras().get("hour");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}