package com.ufrpe.safecampus.view;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ufrpe.safecampus.R;
import com.ufrpe.safecampus.controller.CadastroController;
import com.ufrpe.safecampus.controller.Validacao;
import com.ufrpe.safecampus.model.Pessoa;
import com.ufrpe.safecampus.model.Usuario;


public class CadastroActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Nome, Email, Login, Senha;
    String nome, email, login, senha;
    Button cadastrar;
    AlertDialog.Builder builder;
    String cadURL = "#####################Falta Colocar###################";
    Context context = this;
    Usuario usuario;
    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Nome = (EditText) findViewById(R.id.edtNome);
        Email = (EditText) findViewById(R.id.edtEmail);
        Login = (EditText) findViewById(R.id.edtLogin);
        Senha = (EditText) findViewById(R.id.edtSenha);
        cadastrar = (Button) findViewById(R.id.btnCadastrar);
        cadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        nome = Nome.getText().toString();
        email = Email.getText().toString();
        login = Login.getText().toString();
        senha = Senha.getText().toString();
        pessoa = Montar();
        Boolean valida = Validacao.verificaVazios(nome,email,login,senha,this,Nome,Email,Login,Senha);
        if (valida){

            CadastroController cadastroController = new CadastroController(context);
            cadastroController.cadastro(pessoa);
        }
        else
        {

        }
    }

    private Pessoa Montar() {
        usuario = new Usuario();
        Pessoa pessoaMontada = new Pessoa();
        pessoaMontada.setNome(nome);
        pessoaMontada.setEmail(email);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        pessoaMontada.setUsuario(usuario);
        return pessoaMontada;
    }

}
