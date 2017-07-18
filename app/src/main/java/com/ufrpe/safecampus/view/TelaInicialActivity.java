package com.ufrpe.safecampus.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;

import com.ufrpe.safecampus.R;
import com.ufrpe.safecampus.Session;
import com.ufrpe.safecampus.controller.Validacao;

public class TelaInicialActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Session session;
    private RadioButton rbParaMim, rbParaOutro;
    private EditText etNome, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        rbParaMim = (RadioButton) findViewById(R.id.rbParaMim);
        rbParaOutro = (RadioButton) findViewById(R.id.rbParaOutro);
        etNome = (EditText) findViewById(R.id.etNome);
        etEmail = (EditText) findViewById(R.id.etEmail);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            confirmarSaida();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.perfil) {
            Intent changeToPerfil = new Intent(TelaInicialActivity.this, PerfilActivity.class);
            startActivity(changeToPerfil);
            finish();

        } else if (id == R.id.panico) {
            Intent changeToPanico = new Intent(TelaInicialActivity.this, BotaoPanicoActivity.class);
            startActivity(changeToPanico);
            finish();

        } else if (id == R.id.logout) {
            //    Intent sair = new Intent(TelaInicialActivity.this, LoginActivity.class);
//                TelaInicialActivity.this.startActivity(sair);

        } else if (id == R.id.relatorio) {
            Intent changeToRelatorio = new Intent(TelaInicialActivity.this, RelatorioActivity.class);
            startActivity(changeToRelatorio);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void avancar(View view){
        if (rbParaOutro.isChecked() && !(etEmail.getText().toString().matches("")) ) {
            validarEmail();
        } else {
//            Bundle bundle = new Bundle();
//            bundle.putString("nome_vitima", session.getCliente().getNome());
//            bundle.putString("email_vitima", session.getCliente().getEmail());
            Intent changeToRegistro = new Intent(TelaInicialActivity.this, RegistroActivity.class);
            TelaInicialActivity.this.startActivity(changeToRegistro);
//            changeToRegistro.putExtras(bundle);
            finish();
        }
    }

    public void paraMim(View view){
        etNome.setVisibility(view.GONE);
        etEmail.setVisibility(view.GONE);
    }

    public void paraOutro(View view){
        etNome.setVisibility(view.VISIBLE);
        etEmail.setVisibility(view.VISIBLE);
    }

    private void confirmarSaida(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sair");
        builder.setMessage("Deseja Realmente Sair?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Não", null);
        AlertDialog alerta = builder.create();
        alerta.show();

    }

    private void validarEmail(){
        String email_vitima = etEmail.getText().toString().trim();
        if (!Validacao.validarEmail(email_vitima, this, etEmail)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Aviso");
            builder.setMessage("Este não é um email válido. Deseja Continuar?");
            builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    avancarTela();
                }
            });
            builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    etEmail.requestFocus();
                }
            });
            AlertDialog alerta = builder.create();
            alerta.show();
        } else {
            avancarTela();
        }
    }

    private void avancarTela() {
        Bundle bundle = new Bundle();
        bundle.putString("nome_vitima", etNome.getText().toString().trim());
        bundle.putString("email_vitima", etEmail.getText().toString().trim());
        Intent changeToRegistro = new Intent(TelaInicialActivity.this, RegistroActivity.class);
        TelaInicialActivity.this.startActivity(changeToRegistro);
        changeToRegistro.putExtras(bundle);
        finish();
    }
}
