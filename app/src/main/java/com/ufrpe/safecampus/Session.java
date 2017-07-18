package com.ufrpe.safecampus;

import com.ufrpe.safecampus.model.Usuário;

/**
 * Created by lucas on 17/07/17.
 */

public class Session {

    private static Session instanciaSessao = new Session();
    private Usuário usuarioLogado;

    public Usuário getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuário usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}
