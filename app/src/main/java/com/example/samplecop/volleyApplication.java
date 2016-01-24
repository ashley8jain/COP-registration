package com.example.samplecop;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.util.Log;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by ashleyjain on 23/01/16.
 */
public class volleyApplication {

    public static String TEAMNAME;
    public static String ENTRY1;
    public static String ENTRY2;
    public static String ENTRY3;
    public static String NAME1;
    public static String NAME2;
    public static String NAME3;


    static String url ="http://agni.iitd.ernet.in/cop290/assign0/register/" ; //POST url
    public static void posting(final Context context, final ProgressDialog pdialog) {

        if(isEmpty(ENTRY1)||isEmpty(ENTRY2)||isEmpty(NAME1)||isEmpty(NAME2)) {

            if(isEmpty(ENTRY1))
                AlertDialog("Entry no 1 is empty", context);
            else if(isEmpty(ENTRY2))
                AlertDialog("Entry no 3 is empty", context);
            else if(isEmpty(NAME1))
                AlertDialog("Name 1 is empty", context);
            else if(isEmpty(NAME2))
                AlertDialog("Name 3 is empty", context);

            pdialog.dismiss();

        }
        else if(!isNetworkConnected(context)){
            AlertDialog.Builder alertbuilder = new AlertDialog.Builder(context);
            alertbuilder.setTitle("No Network Connection");
            alertbuilder.setCancelable(true);
            alertbuilder.setPositiveButton("Go to wifi settings",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,int id) {
                    Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
            AlertDialog alertDialog = alertbuilder.create();
            alertDialog.show();
        }
        else{

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("Response", response);
                            try {
                                //response JSON from url
                                JSONObject jsonResponse = new JSONObject(response);
                                String message = jsonResponse.getString("RESPONSE_MESSAGE");
                                System.out.println("Message: " + message);

                                //Toast.makeText(context, message.toString(), Toast.LENGTH_LONG).show();
                                AlertDialog.Builder build2 = new AlertDialog.Builder(context)
                                        .setTitle("Result")
                                        .setMessage(message)
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                System.exit(0);
                                            }
                                        });
                                AlertDialog dialog = build2.create();
                                dialog.show();
                                pdialog.dismiss();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
                            pdialog.dismiss();
                        }
                    }
            ) {

                @Override
                protected Map<String, String> getParams() {
                    Log.d("debug", "posting param");
                    Map<String, String> params = new HashMap<String, String>();

                    // the POST parameters:
                    params.put("teamname", TEAMNAME);
                    params.put("entry1", ENTRY1);
                    params.put("name1", NAME1);
                    params.put("entry2", ENTRY2);
                    params.put("name2", NAME2);
                    if (isEmpty(ENTRY3) || isEmpty(NAME3)) {
                        ENTRY3="";
                        NAME3="";
                    }
                    params.put("entry3", ENTRY3);
                    params.put("name3", NAME3);
                    System.out.println(params);
                    return params;
                }
            };
            // add it to the RequestQueue
            Volley.newRequestQueue(context).add(postRequest);
        }
    }

    private static void AlertDialog(String message, Context contex) {
        AlertDialog.Builder build = new AlertDialog.Builder(contex)
                .setTitle("Oops!!")
                .setMessage(message)
                .setPositiveButton("OK", null);

        AlertDialog dialog = build.create();
        dialog.show();

    }
    private static boolean isEmpty(String st){
        if(st==null)
            return true;
        else if(st.isEmpty())
            return true;
        else
            return false;

    }
    //Check if there is network connection or not
    public static boolean isNetworkConnected(Context con) {
        ConnectivityManager connMgr = (ConnectivityManager) con.getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

}




