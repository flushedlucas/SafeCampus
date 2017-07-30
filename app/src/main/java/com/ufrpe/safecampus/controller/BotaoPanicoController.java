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
import com.ufrpe.safecampus.model.Pessoa;
import com.ufrpe.safecampus.model.Usuario;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wellington on 29/07/17.
 */

public class BotaoPanicoController {

    private Context context;
    private static final String URL = "http://safecampus.pe.hu/rest-api/ocorrencias";

    public BotaoPanicoController(Context context) {this.context = context;}

    public void registrarOcorrencia(Context context){

        final Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setTipo_ocorrencia("para_mim");
        ocorrencia.setData_ocorrencia(Hora.getDate());
        ocorrencia.setDescricao("Ativação Botão do Pânico");
        ocorrencia.setLocal_ocorrencia("parada de zootecnia");
//        Usuario usuario = new Usuario();
//        Pessoa pessoa = new Pessoa();
//        ocorrencia.setNome_vitima(pessoa.getNome());
//        ocorrencia.setEmail_vitima(pessoa.getEmail());
        ocorrencia.setNome_vitima("nome_vitima");
        ocorrencia.setEmail_vitima("email@vitima");
//        ocorrencia.setUsuario(usuario);
        ocorrencia.setHora(Hora.getTime());
        RegistroController registroController = new RegistroController(context);
        registroController.enviarRegistro(ocorrencia);

        RequestQueue queue = Volley.newRequestQueue(this.context);
        StringRequest postRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error.Response", "Error: " + error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("nome", ocorrencia.getNome_vitima());
                params.put("email", ocorrencia.getEmail_vitima());
                params.put("local", ocorrencia.getLocal_ocorrencia());
                params.put("descricao", ocorrencia.getDescricao());
                params.put("data", ocorrencia.getData_ocorrencia());
                params.put("hora", ocorrencia.getHora());
                params.put("tipo_ocorrencia", "Urgência");
                params.put("escolher_pessoa", ocorrencia.getTipo_ocorrencia());

                return params;
            }
        };
        queue.add(postRequest);
    }
//    public  void voltar(View v){
//        Intent voltar = new Intent(v.getContext(), TelaInicialActivity.class);
//        context.startActivity(voltar);
//    }
}

