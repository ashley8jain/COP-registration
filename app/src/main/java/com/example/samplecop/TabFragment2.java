package com.example.samplecop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class TabFragment2 extends Fragment {

    EditText naMe3,enTry3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_2, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if(view!=null){
             naMe3 = (EditText) view.findViewById(R.id.name2);
             enTry3 = (EditText) view.findViewById(R.id.entry2);

            naMe3.addTextChangedListener(new checkError(naMe3));    //calls error checking class on each edittext element
            enTry3.addTextChangedListener(new checkError(enTry3));  //calls error checking class on each edittext element
        }
        naMe3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus == false)
                    volleyApplication.NAME3 = naMe3.getText().toString();   //conveys values to volley class each time the focus shifts
            }

        });
        enTry3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus == false)
                    volleyApplication.ENTRY3 = enTry3.getText().toString();
            }
        });

    }
}
