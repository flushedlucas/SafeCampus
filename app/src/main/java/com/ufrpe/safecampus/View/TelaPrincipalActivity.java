package com.ufrpe.safecampus.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.ufrpe.safecampus.R;

public class TelaPrincipalActivity extends AppCompatActivity {

    private RadioButton rbParaMim, rbParaOutro;
    private EditText etNome, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        rbParaMim = (RadioButton) findViewById(R.id.rbParaMim);
        rbParaOutro = (RadioButton) findViewById(R.id.rbParaOutro);
        etNome = (EditText) findViewById(R.id.etNome);
        etEmail = (EditText) findViewById(R.id.etEmail);
    }

    public void avancar(View view){}

    public void paraMim(View view){
        etNome.setVisibility(view.GONE);
        etEmail.setVisibility(view.GONE);
    }

    public void paraOutro(View view){
        etNome.setVisibility(view.VISIBLE);
        etEmail.setVisibility(view.VISIBLE);
    }

}
