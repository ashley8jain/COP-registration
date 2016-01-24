package com.example.samplecop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class fillActivity extends AppCompatActivity {

    public final static String TEAM_NAME = "team_name";
    public final static String TEAM_NO = "team_no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);
        Intent intent = getIntent();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Individual Details");
        String team_name = intent.getStringExtra(TEAM_NAME);

        getSupportActionBar().setTitle(team_name);

        volleyApplication.TEAMNAME = team_name;


        String teamNo = intent.getStringExtra(TEAM_NO);
        int fragment_count = Integer.parseInt(teamNo);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        if(fragment_count == 2) {
            tabLayout.addTab(tabLayout.newTab().setText("Person 1"));
            tabLayout.addTab(tabLayout.newTab().setText("Person 2"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        }
        else {
            tabLayout.addTab(tabLayout.newTab().setText("Person 1"));
            tabLayout.addTab(tabLayout.newTab().setText("Person 2"));
            tabLayout.addTab(tabLayout.newTab().setText("Person 3"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
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
