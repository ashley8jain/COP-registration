package com.example.samplecop;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class TabFragment3 extends Fragment {

    EditText naMe2,enTry2;
    ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_3, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        final View view = getView();
        if(view!=null){
            naMe2 = (EditText) view.findViewById(R.id.name3);
            enTry2 = (EditText) view.findViewById(R.id.entry3);

            Button registerbutton = (Button) view.findViewById(R.id.btn_login);

            naMe2.addTextChangedListener(new checkError(naMe2));
            enTry2.addTextChangedListener(new checkError(enTry2));


            registerbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ProgressDialog dialog = ProgressDialog.show(getActivity(),"","Loading.Please wait...",true);
                    volleyApplication.NAME2 = naMe2.getText().toString();
                    volleyApplication.ENTRY2 = enTry2.getText().toString();
                    volleyApplication.posting(getActivity(),dialog);

                }
            });
        }

    }

}