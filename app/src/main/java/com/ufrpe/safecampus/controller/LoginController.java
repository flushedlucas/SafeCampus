package com.ufrpe.safecampus.controller;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ufrpe.safecampus.model.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lucas on 26/07/17.
 */

public class LoginController {

    private Context context;
    private static final String URL = "http://safecampus.pe.hu/rest-api/usuarios/Login/";
    private static final String TAG = "LoginController";
    private Session session = Session.getInstanciaSessao();
    JSONObject teste;

    public LoginController(Context context) {
        this.context = context;
    }

    public Usuario buscar(final String login, final String senha) {
        getData(new VolleyCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                try {
                    teste = result;
                    if(login.equals(result.getString("login")) && senha.equals(result.getString("senha"))){
                        Usuario usuario = new Usuario();
                        usuario.setId(result.getInt("id"));
                        usuario.setLogin(login);
                        usuario.setSenha(senha);
                        session.setUsuarioLogado(usuario);
//                        System.out.println(usuario);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, login, senha);
        return session.getUsuarioLogado();
    }

    public void getData(final VolleyCallback callback, String login, String senha){

        RequestQueue queue = Volley.newRequestQueue(this.context); // this = context

        JsonObjectRequest getRequest = new JsonObjectRequest(URL + login + "/" + senha, null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                JSONObject result = response;
                callback.onSuccess(result);
            }
            }, new Response.ErrorListener(){
                @Override
                        public void onErrorResponse(VolleyError error){
//                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                }
            }
        );

        queue.add(getRequest);
    }

    public interface VolleyCallback{
        void onSuccess(JSONObject result);
    }
}