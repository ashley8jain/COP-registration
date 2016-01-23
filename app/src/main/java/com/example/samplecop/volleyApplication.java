package com.example.samplecop;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
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
    public static void posting(final Context context, final ProgressBar pb) {
        System.out.println(TEAMNAME+ENTRY1+NAME1+ENTRY2+NAME2);
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

                            Toast.makeText(context, message.toString(), Toast.LENGTH_LONG).show();
                            pb.setVisibility(View.INVISIBLE);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
                        pb.setVisibility(View.INVISIBLE);
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
                if(!ENTRY3.isEmpty()&&!NAME3.isEmpty()) {
                    params.put("entry3", ENTRY3);
                    params.put("name3", NAME3);
                }
                System.out.println(params);
                return params;
            }
        };
        // add it to the RequestQueue
        Volley.newRequestQueue(context).add(postRequest);


    }


}
