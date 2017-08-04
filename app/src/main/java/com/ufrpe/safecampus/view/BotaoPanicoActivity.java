package com.ufrpe.safecampus.view;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.android.volley.Response;
import com.google.android.gms.maps.SupportMapFragment;
import com.ufrpe.safecampus.R;
import com.ufrpe.safecampus.controller.BotaoPanicoController;
import com.ufrpe.safecampus.controller.MainActivity;
import com.ufrpe.safecampus.controller.MediaButtonReceiver;
import com.ufrpe.safecampus.controller.Session;

import me.drakeet.materialdialog.MaterialDialog;

public class BotaoPanicoActivity extends AppCompatActivity implements LocationListener {
    private Switch btnPanico;
    private Session session = Session.getInstanciaSessao();
    Dialog mNoGpsDialog;
    Context context = BotaoPanicoActivity.this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botao_panico);
        createNoGpsDialog();

        btnPanico = (Switch) findViewById(R.id.swPanico);
        btnPanico.setChecked(session.getPanico());
    }


    private void createNoGpsDialog(){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent callGPSSettingIntent = new Intent(
                                android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(callGPSSettingIntent);
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        mNoGpsDialog = builder.setMessage("Por favor ative seu GPS para usar esse aplicativo.")
                .setPositiveButton("Ativar", dialogClickListener)
                .setNegativeButton("Negativo", dialogClickListener)
                .create();
        mNoGpsDialog.show();

    }


    @Override
    public void onBackPressed(){
        Intent voltar = new Intent(BotaoPanicoActivity.this, TelaInicialActivity.class);
        startActivity(voltar);
        finish();
    }

    public void modoPanico(View view){
        session.setPanico(btnPanico.isChecked());
        session.setContext(context);
        onBackPressed();

    }

    @Override
    public void onLocationChanged(Location location) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

}
