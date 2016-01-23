package com.example.samplecop;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by magicalme on 22-01-2016.
 * Implements a common TextWatcher for all the name and entry no. fields.
 * This prompts the user with an error if any of the fields is left empty or if there is an invalid entry.
 * The class contains the function checkValid(String s) to check if a valid entry number is entered. This function uses inbuilt String.matches function with a regex.
 * To use this class, call a constructor with an edittext for which it is to be applied, as an argument.
 */

public class checkError implements TextWatcher {

    EditText editTextI;
    //EditText editTextII;

    private static boolean checkValid(String entry){
        return entry.matches("20\\d{2}[a-zA-Z]{2}\\d{5}");
    }

    public checkError(EditText nameEdText ){
        this.editTextI = nameEdText;
        //this.editTextII = entryEdText;
        if(editTextI.getText().toString().length()==0){editTextI.setError("field cannot be left blank");}
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //TODO Auto-generated method stub
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // TODO Auto-generated method stub
    }

    public void afterTextChanged(Editable s) {

        if(editTextI.getId()== R.id.entry1 | editTextI.getId()== R.id.entry2 | editTextI.getId()== R.id.entry3){
            if(!checkValid(editTextI.getText().toString())){
                editTextI.setError("Please enter a valid entry no.");
            }
        }
        else{
            if(editTextI.getText().toString().length()==0){
                editTextI.setError("Field cannot be left blank.");
            }
        }
    }

}
