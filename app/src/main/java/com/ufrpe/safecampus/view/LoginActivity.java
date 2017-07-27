package com.ufrpe.safecampus.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ufrpe.safecampus.R;
import com.ufrpe.safecampus.controller.LoginController;
import com.ufrpe.safecampus.controller.Session;
import com.ufrpe.safecampus.controller.Validacao;
import com.ufrpe.safecampus.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private Session session = Session.getInstanciaSessao();
    private EditText etEmail;
    private EditText etSenha;
    private Context context = LoginActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etSenha = (EditText) findViewById(R.id.etSenha);
        etEmail.requestFocus();

//        TextView recuperaSenha = (TextView) findViewById(R.id.tvRecuperarSenha);
//        recuperaSenha.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, RecuperarSenha.class);
//                LoginActivity.this.startActivity(intent);
//                finish();
//            }
//        });

    }

    public void loginUsuario(View view){

        if (validarCampos()) {
            String email = etEmail.getText().toString().trim();
            String senha = etSenha.getText().toString().trim();

            LoginController loginController = new LoginController(context);
            Usuario usuario = getUsuario(email, senha);
            Usuario logarTest = loginController.buscar(usuario);

            if (logarTest != null) {
                session.setUsuarioLogado(logarTest);
                Intent changeToTelaPrincipal = new Intent(LoginActivity.this, TelaInicialActivity.class);
                LoginActivity.this.startActivity(changeToTelaPrincipal);
                Toast.makeText(this, "Bem-Vindo - " + session.getUsuarioLogado().getLogin(), Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, R.string.email_senha_invalido, Toast.LENGTH_SHORT).show();                }
        }
    }

    @NonNull
    private Usuario getUsuario(String email, String senha) {
        Usuario usuario = new Usuario();
        usuario.setLogin(email);
        usuario.setSenha(senha);
        return usuario;
    }


//    public void cadastrarUsuario (View view){
//        Intent cadastro = new Intent(LoginActivity.this, Cadastro.class);
//        startActivity(cadastro);
//        finish();
//    }

    private boolean validarCampos(){
        String email = etEmail.getText().toString().trim();
        String senha = etSenha.getText().toString().trim();
        return (!Validacao.verificavaziosLogin(email, senha,this, etEmail, etSenha)
                && !Validacao.semEspaco(email, this, etEmail)
                && Validacao.tamanhoInválido(email, senha, this, etEmail,etSenha)
                && Validacao.validarEmail(email,this, etEmail));
    }
}
