package com.example.samplecop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class TabFragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_3, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if(view!=null){
            EditText editText = (EditText) view.findViewById(R.id.name3);
            EditText editText2 = (EditText) view.findViewById(R.id.entry3);

            editText.addTextChangedListener(new checkError(editText));
            editText2.addTextChangedListener(new checkError(editText2));
            //checkError nameError = new checkError(editText,editText2);
            //checkError entryNoError = new checkError(editText2);

            // nameError.nameListener();
            //entryNoError.entryNoListener();
        }

    }
}