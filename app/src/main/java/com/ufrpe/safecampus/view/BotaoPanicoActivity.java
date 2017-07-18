package com.ufrpe.safecampus.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ufrpe.safecampus.R;

public class BotaoPanicoActivity extends AppCompatActivity {

    private Button btnPanico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botao_panico);

        btnPanico = (Button) findViewById(R.id.swPanico);
    }

    @Override
    public void onBackPressed(){
        Intent voltar = new Intent(BotaoPanicoActivity.this, TelaInicialActivity.class);
        startActivity(voltar);
        finish();
    }

    public void ligarModoPanico(View view){

    }
}
