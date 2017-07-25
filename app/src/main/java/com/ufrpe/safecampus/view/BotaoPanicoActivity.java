package com.ufrpe.safecampus.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.ufrpe.safecampus.R;
import com.ufrpe.safecampus.controller.Session;

public class BotaoPanicoActivity extends AppCompatActivity {

    private Switch btnPanico;
    private Session session = Session.getInstanciaSessao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botao_panico);

        btnPanico = (Switch) findViewById(R.id.swPanico);

        btnPanico.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( keyCode == KeyEvent.KEYCODE_VOLUME_UP ) {
                    Toast.makeText(getApplicationContext(), "Panico", Toast.LENGTH_LONG).show();
                    return true;
                }
                return false;
            }

        });

    }

    @Override
    public void onBackPressed(){
        Intent voltar = new Intent(BotaoPanicoActivity.this, TelaInicialActivity.class);
        startActivity(voltar);
        finish();
    }

    public void modoPanico(View view){

        session.setPanico(btnPanico.isChecked());

    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_POWER) {
            Toast.makeText(getApplicationContext(), "Volume down!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int keyPressed = event.getKeyCode();
        if(keyPressed == KeyEvent.KEYCODE_POWER){
            Toast.makeText(getApplicationContext(), "Panico", Toast.LENGTH_LONG).show();
            event.startTracking();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
