package com.example.samplecop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.ganfra.materialspinner.MaterialSpinner;

public class MainActivity extends AppCompatActivity {

    public EditText editText;
    MaterialSpinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("");

        /*The following takes values of the spinner and the edittext from savedInstancestete
        during events like orientation change so that the data user entered isn't lost */
        if(savedInstanceState !=null){
            spinner = (MaterialSpinner)findViewById(R.id.spinner1);
            spinner.setSelection(savedInstanceState.getInt("spinner_value"));
            editText = (EditText)findViewById(R.id.team_name);
            editText.setText(savedInstanceState.getString("team_name"));
        }
    }

    public void onClick(View view){                     //Called on "Next" button click
        Intent intent = new Intent(this,fillActivity.class);

        editText= (EditText)findViewById(R.id.team_name);
        spinner = (MaterialSpinner)findViewById(R.id.spinner1);
        Button next = (Button)findViewById(R.id.btn_login);

        if(editText.getText().toString().length()!=0 && spinner.getSelectedItem().toString().length()<2){

            intent.putExtra(fillActivity.TEAM_NAME, editText.getText().toString());
            intent.putExtra(fillActivity.TEAM_NO, String.valueOf(spinner.getSelectedItem()));
            editText.setText("");               //Clears edittext before going to next activity. Needed for cases where another registration is made.
            startActivity(intent);
        }
        else {
            if(editText.getText().toString().length()==0){
                editText.setError("This field cannot be blank");  //prompts user to not leave this field blank
            }
            else{
                spinner.setError("Please select an option");    //prompts user to not leave this field blank
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){     //To save data user entered and use it again during events like orientation change.
        editText= (EditText)findViewById(R.id.team_name);
        spinner = (MaterialSpinner)findViewById(R.id.spinner1);
        savedInstanceState.putInt("spinner_value",spinner.getSelectedItemPosition());
        savedInstanceState.putString("team_name", editText.getText().toString());
    }

}
