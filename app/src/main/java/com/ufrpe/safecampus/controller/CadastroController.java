package com.ufrpe.safecampus.controller;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ufrpe.safecampus.model.Pessoa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wellington on 27/07/17.
 */

public class CadastroController {

    private Context context;
    private static final String URL = "http://safecampus.pe.hu/rest-api/ocorrencias";

    public CadastroController(Context context) {
        this.context = context;
    }

    public void cadastro(final Pessoa pessoa){
        RequestQueue queue = Volley.newRequestQueue(this.context);  // this = context
        StringRequest stringRequest = new StringRequest(Request.Method.POST,URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            Log.d("Response", response);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("nome",pessoa.getNome());
                params.put("email",pessoa.getEmail());
                params.put("login",pessoa.getUsuario().getLogin());
                params.put("senha",pessoa.getUsuario().getSenha());
                return params;
            }
        };
        queue.add(stringRequest);
}
}
