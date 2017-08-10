package com.ufrpe.safecampus.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ufrpe.safecampus.R;
import com.ufrpe.safecampus.controller.Mask;
import com.ufrpe.safecampus.controller.RegistroController;
import com.ufrpe.safecampus.controller.Validacao;
import com.ufrpe.safecampus.model.Ocorrencia;

import java.text.SimpleDateFormat;

public class RegistroActivity extends AppCompatActivity {

    SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-aaaa");
    SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
    private EditText etDescricao, etData, etHora;
    private Spinner spnTipoDeOcorrencia;
    private Button btnEnviar;
    private String[] tiposNome = {"Assalto", "Acidente de Carro", "Violencia"};
    private Context context = RegistroActivity.this;
//    LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

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
        voltar();
    }

    public void enviar(View view) {

        Ocorrencia ocorrencia = new Ocorrencia();
        String descricao = etDescricao.getText().toString();

        if (Validacao.verificavaziosOcorrencia(descricao, etHora.getText().toString(),
                etData.getText().toString(), this, etDescricao, etHora, etData)) {

            try {
                Intent telaInicial = getIntent();
                Bundle dados = telaInicial.getExtras();

                String nome_vitima = dados.get("nome_vitima").toString();
                String email_vitima = dados.get("email_vitima").toString();

                ocorrencia.setNome_vitima(nome_vitima);
                ocorrencia.setEmail_vitima(email_vitima);
            } catch (Exception e) {
            } finally {
                ocorrencia.setNome_vitima("usuario");
                ocorrencia.setEmail_vitima("email@usuario");
            }
//        try {
//            Date data = dataFormat.parse(etData.getText().toString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        try {
//            Date hora = horaFormat.parse(etHora.getText().toString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

            ocorrencia.setTipo_ocorrencia("para_outro");
            ocorrencia.setData_ocorrencia(etData.getText().toString());
            ocorrencia.setDescricao(descricao);
            ocorrencia.setLocal_ocorrencia("parada de zootecnia");
            ocorrencia.setHora(etHora.getText().toString());


            RegistroController registroController = new RegistroController(this.getApplicationContext());
            registroController.enviarRegistro(ocorrencia);
            voltar();
        }
    }

    private void voltar() {
        Intent voltar = new Intent(RegistroActivity.this, TelaInicialActivity.class);
        startActivity(voltar);
        finish();
    }
}
