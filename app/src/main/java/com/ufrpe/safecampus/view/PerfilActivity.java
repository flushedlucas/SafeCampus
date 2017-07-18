package com.ufrpe.safecampus.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ufrpe.safecampus.R;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    @Override
    public void onBackPressed(){
        Intent voltar = new Intent(PerfilActivity.this, TelaInicialActivity.class);
        startActivity(voltar);
        finish();
    }
}
