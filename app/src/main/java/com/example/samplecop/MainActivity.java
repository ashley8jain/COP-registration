package com.example.samplecop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        spinner1 = (Spinner)findViewById(R.id.spinner1);

    }

    public void onClick(View view){
        Intent intent = new Intent(this,fillActivity.class);
        Toast.makeText(this, spinner1.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("fragments",  spinner1.getSelectedItem().toString());
        intent.putExtras(bundle);
         startActivity(intent);


    }


}
