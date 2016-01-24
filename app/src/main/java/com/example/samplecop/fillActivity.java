package com.example.samplecop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class fillActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Individual Details");
        getSupportActionBar().setTitle("");
        Bundle bundle = getIntent().getExtras();
        String fragments = bundle.getString("fragments");
        int fragment_count = Integer.parseInt(fragments);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        if(fragment_count == 2) {
            tabLayout.addTab(tabLayout.newTab().setText("Person 1"));
            tabLayout.addTab(tabLayout.newTab().setText("Person 2"));
        }
        else {
            tabLayout.addTab(tabLayout.newTab().setText("Person 1"));
            tabLayout.addTab(tabLayout.newTab().setText("Person 2"));
            tabLayout.addTab(tabLayout.newTab().setText("Person 3"));
        }
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }



}
