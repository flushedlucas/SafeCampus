package com.ufrpe.safecampus.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

import com.ufrpe.safecampus.R;
import com.ufrpe.safecampus.controller.BotaoPanicoController;
import com.ufrpe.safecampus.controller.MediaButtonReceiver;
import com.ufrpe.safecampus.controller.Session;

public class BotaoPanicoActivity extends AppCompatActivity {
    private Switch btnPanico;
    private Session session = Session.getInstanciaSessao();

    Context context = BotaoPanicoActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botao_panico);

        btnPanico = (Switch) findViewById(R.id.swPanico);
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
//        BotaoPanicoController botaoPanicoController = new BotaoPanicoController(this.getApplicationContext());
        onBackPressed();


    }

}
