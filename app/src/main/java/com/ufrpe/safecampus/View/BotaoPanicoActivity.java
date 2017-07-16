package com.ufrpe.safecampus.View;

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

    public void ligarModoPanico(View view){

    }
}
