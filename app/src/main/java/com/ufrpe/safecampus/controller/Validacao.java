package com.ufrpe.safecampus.controller;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.ufrpe.safecampus.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacao {

    private static final int[] weightCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    private static String onlyNumbers(CharSequence s ){
        return s.toString().replaceAll("\\D+", "");
    }

    private static int computeDigit(String str, int[] weight){
        int sum = 0;
        for (int index = str.length() - 1, digit; index >= 0; index--){
            digit = Integer.parseInt(str.substring(index, index + 1));
            sum += digit * weight[weight.length - str.length() + index];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

    public static boolean isValidCPF(String cpf){
        cpf = onlyNumbers((CharSequence) cpf);
        if ((cpf == null) || (cpf.length() != 11)) { return false; }

        Integer digitA = computeDigit(cpf.substring(0, 9), weightCPF);
        Integer digitB = computeDigit(cpf.substring(0, 9) + digitA, weightCPF);
        return cpf.equals(cpf.substring(0, 9) + digitA.toString() + digitB.toString());
    }

    public static boolean validarEmail(String email, Context context, EditText etEmail) {
        boolean result;
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    //verifica vazios tela inicial
    public static boolean verificaVaziosInicial(String email, String nome, Context context, EditText etEmail, EditText etNome) {

        boolean result;

        if (TextUtils.isEmpty(email)) {
            etEmail.requestFocus();
            etEmail.setError(context.getString(R.string.email_vazio));
            result = true;
        } else if (TextUtils.isEmpty(nome)) {
            etNome.requestFocus();
            etNome.setError(context.getString(R.string.senha_vazio));
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    public static boolean semEspaco(String email, Context context, EditText etEmail) {
        boolean result;
        int idx = email.indexOf(" ");

        if (idx != -1) {
            etEmail.requestFocus();
            etEmail.setError(context.getString(R.string.email_senha_invalido));
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    public static boolean verificavaziosOcorrencia(String descricao, String hora, String data, Context context, EditText etdescricao, EditText ethora, EditText etdata){
        boolean result;

        if (TextUtils.isEmpty(descricao)) {
            etdescricao.requestFocus();
            etdescricao.setError(context.getString(R.string.campo_vazio));
            result = false;
        } else if (TextUtils.isEmpty(hora)) {
            ethora.requestFocus();
            ethora.setError(context.getString(R.string.campo_vazio));
            result = false;
        } else if (TextUtils.isEmpty(data)) {
            etdata.requestFocus();
            etdata.setError(context.getString(R.string.campo_vazio));
            result = false;
        } else {
            result = true;
        }


        return result;
    }

    public static boolean verificavaziosLogin(String email, String senha, Context context, EditText etEmail, EditText etsenha){
        boolean result;

        if (TextUtils.isEmpty(email)) {
            etEmail.requestFocus();
            etEmail.setError(context.getString(R.string.campo_vazio));
            result = false;
        } else if (TextUtils.isEmpty(senha)) {
            etsenha.requestFocus();
            etsenha.setError(context.getString(R.string.campo_vazio));
            result = false;
        } else {
            result = true;
        }
        return result;
    }


    public static boolean tamanhoInválido(String email, String senha, Context context, EditText etEmail, EditText etSenha) {
        boolean result;

        if (!(email.length() > 3)) {
            etEmail.requestFocus();
            etEmail.setError(context.getString(R.string.login_tamanho_invalido));
            result = false;
        } else if (!(senha.length() > 2)) {
            etSenha.requestFocus();
            etSenha.setError(context.getString(R.string.login_senha_tamanho_invalido));
            result = false;
        } else {
            result = true;
        }

        return result;
    }
    //Validações da tela de Login e Cadastro de Usuario
    public static boolean verificaVazios(String nome, String email,String login,  String senha, Context context,EditText edtNome, EditText etEmail,EditText edtLogin, EditText etSenha) {

        boolean result;
        if (TextUtils.isEmpty(nome)) {
            edtNome.requestFocus();
            edtNome.setError(context.getString(R.string.nome_invalido));
            result = true;
        }
        else if (TextUtils.isEmpty(email)) {
            etEmail.requestFocus();
            etEmail.setError(context.getString(R.string.email_vazio));
            result = true;
        }else if (TextUtils.isEmpty(login)) {
            edtLogin.requestFocus();
            edtLogin.setError(context.getString(R.string.login_invalido));
            result = true;
        }else if (TextUtils.isEmpty(senha)) {
            etSenha.requestFocus();
            etSenha.setError(context.getString(R.string.senha_vazio));
            result = true;
        } else {
            result = false;
        }

        return result;
    }
}
