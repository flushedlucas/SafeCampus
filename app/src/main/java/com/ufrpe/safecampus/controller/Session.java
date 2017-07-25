package com.ufrpe.safecampus.controller;

import com.ufrpe.safecampus.model.Usuário;

/**
 * Created by lucas on 17/07/17.
 */

public class Session {

    private static Session instanciaSessao = new Session();
    private Usuário usuarioLogado;
    private boolean panico;

    public static Session getInstanciaSessao() {
        return instanciaSessao;
    }

    public Usuário getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuário usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public boolean getPanico() {
        return panico;
    }

    public void setPanico(boolean panico) {
        this.panico = panico;
    }
}
