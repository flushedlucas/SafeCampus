package com.ufrpe.safecampus.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ufrpe.safecampus.Mask;
import com.ufrpe.safecampus.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroActivity extends AppCompatActivity {

    SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-aaaa");
    SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
    private EditText etDescricao, etData, etHora;
    private Spinner spnTipoDeOcorrencia;
    private Button btnEnviar;
    private String[] tiposNome = {"Assalto", "Acidente de Carro", "Violencia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tiposNome);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        etDescricao = (EditText) findViewById(R.id.etDescricao);
        etData = (EditText) findViewById(R.id.etData);
        etHora = (EditText) findViewById(R.id.etHora);
        spnTipoDeOcorrencia = (Spinner) findViewById(R.id.spnTipoDeOcorrencia);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        spnTipoDeOcorrencia.setAdapter(adapter);
        spnTipoDeOcorrencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        etData.addTextChangedListener(Mask.insert("##/##/####", etData));
        etHora.addTextChangedListener(Mask.insert("##:##", etHora));
    }

    @Override
    public void onBackPressed(){
        Intent voltar = new Intent(RegistroActivity.this, TelaInicialActivity.class);
        startActivity(voltar);
        finish();
    }

    public void enviar(View view){
        Intent telaInicial = getIntent();
        Bundle dados = telaInicial.getExtras();

        String nome_vitima = dados.get("nome_vitima").toString();
        String email_vitima = dados.get("email_vitima").toString();
        String descricao = etDescricao.getText().toString();
        try {
            Date data = dataFormat.parse(etData.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Date hora = horaFormat.parse(etHora.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }





    }
}
