package com.ufrpe.safecampus.controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ufrpe.safecampus.model.Usuario;
import com.ufrpe.safecampus.view.LoginActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucas on 26/07/17.
 */

public class LoginController {

    private Context context;
    private static final String URL = "http://safecampus.pe.hu/rest-api/ocorrencias";

    public LoginController(Context context) { this.context = context; }

    public Usuario buscar(final Usuario usuario){
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
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<String, String>();
//                params.put("id", "1");
//                params.put("nome","jose");
                params.put("email", usuario.getSenha());
                params.put("senha", usuario.getSenha()  );
                return params;
            }
        };
        NetworkConnection.getInstance(context).addRequestQueue(postRequest);
        return usuario;
    }
}
