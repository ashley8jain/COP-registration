package com.example.samplecop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import fr.ganfra.materialspinner.MaterialSpinner;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    MaterialSpinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent intent = new Intent(this,fillActivity.class);

        editText= (EditText)findViewById(R.id.input_email);
        spinner = (MaterialSpinner)findViewById(R.id.spinner1);
        Button next = (Button)findViewById(R.id.btn_login);

        if(editText.getText().toString().length()!=0 && spinner.getSelectedItem().toString().length()<2){

            intent.putExtra(fillActivity.TEAM_NAME, editText.getText().toString());
            intent.putExtra(fillActivity.TEAM_NO, String.valueOf(spinner.getSelectedItem()));
            startActivity(intent);
        }
        else {
            if(editText.getText().toString().length()==0){
                editText.setError("This field cannot be blank");
            }
            else{
                spinner.setError("Please select an option");
            }
        }

    }

}
