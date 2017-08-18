package com.ufrpe.safecampus.controller;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.lang.reflect.Array;

/**
 * Created by lucas on 17/07/17.
 */

public class RelatorioController {

    private Context context;
    private static final String URL = "http://safecampus.pe.hu/rest-api/ocorrencias";

    public RelatorioController(Context context){
        this.context = context;
    }

    public void buscar(){
        RequestQueue queue = Volley.newRequestQueue(this.context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Relatorio", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Relatorio", "Error: " + error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }

    public void buscar(String nome){
        RequestQueue queue = Volley.newRequestQueue(this.context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Relatorio", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Relatorio", "Error: " + error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }

    public void buscar(String nome, boolean input){
        RequestQueue queue = Volley.newRequestQueue(this.context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL + "/" + "TipoOcorrencia" + "/" + nome, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Relatorio", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Relatorio", "Error: " + error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }

    public void buscar(String dataInicio, String dataFim){
        RequestQueue queue = Volley.newRequestQueue(this.context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL + "/" + "Data" + "/" + dataInicio + "/" + dataFim, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Relatorio", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Relatorio", "Error: " + error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }

}
