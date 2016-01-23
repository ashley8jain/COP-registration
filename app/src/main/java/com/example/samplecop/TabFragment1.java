package com.example.samplecop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class TabFragment1 extends Fragment {

    EditText naMe1,enTry1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_1, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if(view!=null){
             naMe1 = (EditText) view.findViewById(R.id.name1);
             enTry1 = (EditText) view.findViewById(R.id.entry1);

            naMe1.addTextChangedListener(new checkError(naMe1));
            enTry1.addTextChangedListener(new checkError(enTry1));
        }
        naMe1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus == false)
                    volleyApplication.NAME1 = naMe1.getText().toString();
            }

        });
        enTry1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus == false)
                    volleyApplication.ENTRY1 = enTry1.getText().toString();
            }
        });


    }
}