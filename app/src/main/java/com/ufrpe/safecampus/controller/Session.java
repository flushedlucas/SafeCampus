package com.ufrpe.safecampus.controller;

import android.util.Log;

import com.ufrpe.safecampus.model.Usuario;

/**
 * Created by lucas on 17/07/17.
 */

public class Session {

    private static Session instanciaSessao = new Session();
    private Usuario usuarioLogado;
    private boolean panico;
    private int contador;




    public static Session getInstanciaSessao() {
        return instanciaSessao;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public boolean getPanico() {
        return panico;
    }

    public void setPanico(boolean panico) {
        this.panico = panico;
    }

    public void setCont(int cont){
        contador = cont+contador;
        //para ver o log tem que abrir Android Monitor
        Log.i("Contador :", ""+contador);
        while( contador >= 15 ) {
            //chamar o serviço de registra ocorrência
            Log.i(" Mensagem Enviada", "Registrando ocorrência...");
            contador = 0;
//            if (horaatual maior que a do else ) {
//                //limpar contador
//            } else {
//                //pegar hora para depois checar
//            }
        }
    }


}
