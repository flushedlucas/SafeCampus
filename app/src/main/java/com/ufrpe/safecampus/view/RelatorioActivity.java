package com.ufrpe.safecampus.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ufrpe.safecampus.R;
import com.ufrpe.safecampus.controller.Mask;
import com.ufrpe.safecampus.controller.RelatorioController;

public class RelatorioActivity extends AppCompatActivity {

    private Spinner spnTipoDeBusca, spnTipoDeOcorrencia;
    private Button btnBuscar;
    private EditText etDataInicio, etDataFim, etNome;
    private String[] tiposNome = {"Assalto", "Acidente de Carro", "Violencia"};
    private String[] tiposBusca = {"Por Data", "Por Nome", "Por Tipo de Ocorrencia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        ArrayAdapter<String> adapterOcorrencia = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tiposNome);
        adapterOcorrencia.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterBusca = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tiposBusca);
        adapterOcorrencia.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spnTipoDeBusca = (Spinner) findViewById(R.id.spnTipoDeBusca);
        spnTipoDeOcorrencia = (Spinner) findViewById(R.id.spnTipoDeOcorrencia);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        etDataFim = (EditText) findViewById(R.id.etDataFim);
        etDataInicio = (EditText) findViewById(R.id.etDataInicio);
        etNome = (EditText) findViewById(R.id.etNome);

        spnTipoDeBusca.setAdapter(adapterBusca);
        spnTipoDeBusca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).toString().equals("Por Data")){
                    etNome.setVisibility(View.INVISIBLE);
                    spnTipoDeOcorrencia.setVisibility(View.INVISIBLE);
                    etDataFim.setVisibility(View.VISIBLE);
                    etDataInicio.setVisibility(View.VISIBLE);

                }else if (parent.getItemAtPosition(position).toString().equals("Por Nome")){
                    etNome.setVisibility(View.VISIBLE);
                    spnTipoDeOcorrencia.setVisibility(View.INVISIBLE);
                    etDataFim.setVisibility(View.INVISIBLE);
                    etDataInicio.setVisibility(View.INVISIBLE);
                } else if (parent.getItemAtPosition(position).toString().equals("Por Tipo de Ocorrencia")){
                    etNome.setVisibility(View.INVISIBLE);
                    spnTipoDeOcorrencia.setVisibility(View.VISIBLE);
                    etDataFim.setVisibility(View.INVISIBLE);
                    etDataInicio.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spnTipoDeOcorrencia.setAdapter(adapterOcorrencia);
        spnTipoDeOcorrencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        etDataFim.addTextChangedListener(Mask.insert("##/##/####", etDataFim));
        etDataInicio.addTextChangedListener(Mask.insert("##/##/####", etDataInicio));

    }

    @Override
    public void onBackPressed(){
        Intent voltar = new Intent(RelatorioActivity.this, TelaInicialActivity.class);
        startActivity(voltar);
        finish();
    }

    public void buscar (View view) {

        RelatorioController relatorioController = new RelatorioController();
        relatorioController.buscar();

    }
}
