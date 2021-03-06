package com.ufrpe.safecampus.controller;


import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ufrpe.safecampus.model.Ocorrencia;

import java.util.HashMap;
import java.util.Map;

public class RegistroController {

    private Context context;
    private static final String URL = "http://safecampus.pe.hu/rest-api/ocorrencias";

    public RegistroController(Context context) { this.context = context; }



    public void enviarRegistro(final Ocorrencia ocorrencia){
        RequestQueue queue = Volley.newRequestQueue(this.context);  // this = context
        StringRequest postRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", "Error: " + error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("nome", ocorrencia.getNome_vitima());
                params.put("email", ocorrencia.getEmail_vitima());
                params.put("local", ocorrencia.getLocal_ocorrencia());
                params.put("descricao", ocorrencia.getDescricao());
                params.put("data", ocorrencia.getData_ocorrencia());
                params.put("hora", ocorrencia.getHora());
                params.put("tipo_ocorrencia", "Teste na sala");
                params.put("escolher_pessoa", ocorrencia.getTipo_ocorrencia());

                return params;
            }
        };
        queue.add(postRequest);
    }
}
