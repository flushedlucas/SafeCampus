package com.ufrpe.safecampus.View;

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

    public void enviar(View view){}
}
