package com.ufrpe.safecampus.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;

import com.ufrpe.safecampus.R;

public class TelaInicialActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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

        if (id == R.id.nav_camera) {
            Intent changeToPerfil = new Intent(TelaInicialActivity.this, PerfilActivity.class);
            startActivity(changeToPerfil);
            finish();

        } else if (id == R.id.nav_gallery) {
            Intent changeToPanico = new Intent(TelaInicialActivity.this, BotaoPanicoActivity.class);
            startActivity(changeToPanico);
            finish();

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void avancar(View view){
        Intent changeToRegistro = new Intent(TelaInicialActivity.this, RegistroActivity.class);
        TelaInicialActivity.this.startActivity(changeToRegistro);
        finish();
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
//                Intent sair = new Intent(TelaInicialActivity.this, LoginActivity.class);
//                TelaInicialActivity.this.startActivity(sair);
                finish();
            }
        });
        builder.setNegativeButton("Não", null);
        AlertDialog alerta = builder.create();
        alerta.show();

    }

    public boolean validarCampos(){
        return true;
    }
}
