package com.ufrpe.safecampus.controller;

import android.content.Context;

import com.ufrpe.safecampus.model.Usuario;

/**
 * Created by lucas on 26/07/17.
 */

public class LoginController {

    private Context context;
    private static final String URL = "http://safecampus.pe.hu/rest-api/ocorrencias";

    public LoginController(Context context) { this.context = context; }

    public Usuario buscar(String email, String senha){
        Usuario usuario = new Usuario();
        return usuario;
    }
}
