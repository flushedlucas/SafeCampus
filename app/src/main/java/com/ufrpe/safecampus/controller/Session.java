package com.ufrpe.safecampus.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.util.Log;

import com.google.android.gms.internal.b;
import com.ufrpe.safecampus.model.Usuario;
import com.ufrpe.safecampus.view.BotaoPanicoActivity;
import com.ufrpe.safecampus.view.RegistroActivity;

/**
 * Created by lucas on 17/07/17.
 */

public class Session {

    private static Session instanciaSessao = new Session();
    private Usuario usuarioLogado;
    private boolean panico;
    private int contador;
    private Context context;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }


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

    public void setContext(Context context) {
        this.context = context;
    }
    public Context getContext() {
        return context;
    }

    public void setCont(int cont){
        contador = cont+contador;
        //para ver o log tem que abrir Android Monitor
        Log.i("Contador :", ""+contador);
        while( contador >= 15 && contador <= 40) {
            //chamar o serviço de registra ocorrência
            Log.i(" Mensagem Enviada", "Registrando ocorrência...");
            BotaoPanicoController botaoPanicoController = new BotaoPanicoController(getContext());
//            botaoPanicoController.registrarOcorrencia(getContext());
            botaoPanicoController.registrarOcorrencia();
            Log.i(" Mensagem Enviada", "Ocorrência  Registrada.");
            contador = 0;
//            setPanico(false);
//            new MediaButtonReceiver();
            break;

        }
    }



}
