package com.ufrpe.safecampus.controller;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.ufrpe.safecampus.model.Ocorrencia;

/**
 * Created by wellington on 29/07/17.
 */

public class BotaoPanicoController implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private Context context;
    private static final String URL = "http://safecampus.pe.hu/rest-api/ocorrencias";
    private GoogleApiClient mGoogleApiClient;
    private String lat;
    private String lng;

    public BotaoPanicoController(Context context) {
        this.context = context;
    }

    public void registrarOcorrencia(Context context) {

        callConnection();
        final Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setTipo_ocorrencia("para_mim");
        ocorrencia.setData_ocorrencia(Hora.getDate());
        ocorrencia.setDescricao("Ativação Botão do Pânico");
        ocorrencia.setLocal_ocorrencia(" NO CEGOE");
        ocorrencia.setNome_vitima("nome_vitima");
        ocorrencia.setEmail_vitima("comCoordenadas@vitima");

        ocorrencia.setHora(Hora.getTime());
        RegistroController registroController = new RegistroController(context);
        registroController.enviarRegistro(ocorrencia);

//        RequestQueue queue = Volley.newRequestQueue(this.context);
//        StringRequest postRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.d("Response", response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("Error.Response", "Error: " + error.getMessage());
//            }
//        }){
//            @Override
//            protected Map<String, String> getParams(){
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("nome", ocorrencia.getNome_vitima());
//                params.put("email", ocorrencia.getEmail_vitima());
//                params.put("local", ocorrencia.getLocal_ocorrencia());
//                params.put("descricao", ocorrencia.getDescricao());
//                params.put("data", ocorrencia.getData_ocorrencia());
//                params.put("hora", ocorrencia.getHora());
//                params.put("tipo_ocorrencia", "Teste das Coordenadas");
//                params.put("escolher_pessoa", ocorrencia.getTipo_ocorrencia());
//                params.put("latitude", lat);
//                params.put("longitude", lng);
//
//                return params;
//            }
//        };
//        queue.add(postRequest);
    }

    private synchronized void callConnection() {
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) throws
            SecurityException{
        Log.i("LOG", "onConnected(" + bundle + ")");
        Location l = LocationServices
                .FusedLocationApi
                .getLastLocation(mGoogleApiClient);

        if(l != null){
            Log.i("LOG", "latitude: "+l.getLatitude());
            Log.i("LOG", "longitude: "+l.getLongitude());
            lat = String.valueOf(l.getLatitude());
            lng = String.valueOf(l.getLongitude());
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i("LOG", "onConnectionSuspended(" + i + ")");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.i("LOG", "onConnectionFailed("+connectionResult+")");

    }


}

