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

    public void registrarOcorrencia() {

        callConnection();

    }

    private synchronized void callConnection( ) {
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

            final Ocorrencia ocorrencia = new Ocorrencia();
            ocorrencia.setLat(String.valueOf(l.getLatitude()));
            ocorrencia.setLng(String.valueOf(l.getLongitude()));
            ocorrencia.setTipo_ocorrencia("para_mim");
            ocorrencia.setData_ocorrencia(Hora.getDate());
            ocorrencia.setDescricao("Ativação Botão do Pânico");
            ocorrencia.setLocal_ocorrencia(lat+ " | "+lng);
            ocorrencia.setNome_vitima("nome_vitima");
            ocorrencia.setEmail_vitima("comCoordenadas@vitima");
            ocorrencia.setLat(lat);
            ocorrencia.setLng(lng);
            ocorrencia.setHora(Hora.getTime());
            RegistroController registroController = new RegistroController(context);
            registroController.enviarRegistro(ocorrencia);
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

