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

            naMe3.addTextChangedListener(new checkError(naMe3));
            enTry3.addTextChangedListener(new checkError(enTry3));
        }
        naMe3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus == false)
                    volleyApplication.NAME3 = naMe3.getText().toString();
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



    /*@Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        EditText editText = (EditText)view.findViewById(R.id.name2);
        EditText editText2 = (EditText)view.findViewById(R.id.entry2);

        editText.addTextChangedListener(new checkError(editText,editText2));
        editText2.addTextChangedListener(new checkError(editText,editText2));

        //checkError nameError = new checkError(editText, editText2);
        //checkError entryNoError = new checkError(editText2);

    }*/
}
