package com.example.samplecop;

import android.content.Context;
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

public class volleyApplication {
    private String team_name,name_1,name_2,name_3,entry_1,entry_2,entry_3; 

    public void setEntry_1(String entry_1) {
        this.entry_1 = entry_1;
    }

    public void setEntry_2(String entry_2) {
        this.entry_2 = entry_2;
    }

    public void setEntry_3(String entry_3) {
        this.entry_3 = entry_3;
    }

    public void setName_1(String name_1) {
        this.name_1 = name_1;
    }

    public void setName_2(String name_2) {
        this.name_2 = name_2;
    }

    public void setName_3(String name_3) {
        this.name_3 = name_3;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    String url ="http://agni.iitd.ernet.in/cop290/assign0/register/" ; //POST url
    public void posting(final Context context) {
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


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Log.d("debug", "posting param");
                Map<String, String> params = new HashMap<String, String>();

                // the POST parameters:
                params.put("teamname", team_name);
                params.put("entry1", entry_1);
                params.put("name1", name_1);
                params.put("entry2", entry_2);
                params.put("name2", name_2);
                if (entry_3.isEmpty() || name_3.isEmpty()) {
                    params.put("entry3", entry_3);
                    params.put("name3", name_3);
                }
                System.out.println(params);
                return params;
            }
        };
        // add it to the RequestQueue
        Volley.newRequestQueue(context).add(postRequest);


    }


}
