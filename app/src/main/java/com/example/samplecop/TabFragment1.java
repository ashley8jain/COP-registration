package com.example.samplecop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class TabFragment1 extends Fragment {
    EditText editText, editText2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_1, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        editText = (EditText)view.findViewById(R.id.name);
        editText2 = (EditText)view.findViewById(R.id.entry);

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText.getText().toString().equalsIgnoreCase(""))
                editText.setError("Field cannot be left blank.");

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editText.getText().toString().equalsIgnoreCase(""))
                editText.setError("Field cannot be left blank.");

            }
        });
    }
}