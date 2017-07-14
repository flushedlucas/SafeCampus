package com.ufrpe.safecampus.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.ufrpe.safecampus.R;

public class SelecaoRegistroActivity extends AppCompatActivity {

    private RadioButton rbParaMim, rbParaOutro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_registro);

        rbParaMim = (RadioButton) findViewById(R.id.rbParaMim);
        rbParaOutro = (RadioButton) findViewById(R.id.rbParaOutro);
    }

    public void avancar(View view){}
}
