package com.ufrpe.safecampus.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ufrpe.safecampus.R;

public class RegistroActivity extends AppCompatActivity {

    private EditText etDescricao;
    private Spinner spnTipoDeOcorrencia;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etDescricao = (EditText) findViewById(R.id.etDescricao);
        spnTipoDeOcorrencia = (Spinner) findViewById(R.id.spnTipoDeOcorrencia);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
    }

    @Override
    public void onBackPressed(){
        Intent voltar = new Intent(RegistroActivity.this, TelaInicialActivity.class);
        startActivity(voltar);
        finish();
    }

    public void enviar(View view){}
}
