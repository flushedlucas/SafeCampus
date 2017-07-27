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
        return usuario;
    }
}
