package com.ufrpe.safecampus.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

/**
 * Created by lucas on 17/07/17.
 */

public class Ocorrencia {

    private int id;
    private String informacao;
    private String tipo_ocorrencia;
    private String descricao;
    private Date data_ocorrencia;
    private LatLng local_ocorrencia;
    private String nome_vitima;
    private String email_vitima;
    private Usuário usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public String getTipo_ocorrencia() {
        return tipo_ocorrencia;
    }

    public void setTipo_ocorrencia(String tipo_ocorrencia) {
        this.tipo_ocorrencia = tipo_ocorrencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_ocorrencia() {
        return data_ocorrencia;
    }

    public void setData_ocorrencia(Date data_ocorrencia) {
        this.data_ocorrencia = data_ocorrencia;
    }

    public LatLng getLocal_ocorrencia() {
        return local_ocorrencia;
    }

    public void setLocal_ocorrencia(LatLng local_ocorrencia) {
        this.local_ocorrencia = local_ocorrencia;
    }

    public String getNome_vitima() {
        return nome_vitima;
    }

    public void setNome_vitima(String nome_vitima) {
        this.nome_vitima = nome_vitima;
    }

    public String getEmail_vitima() {
        return email_vitima;
    }

    public void setEmail_vitima(String email_vitima) {
        this.email_vitima = email_vitima;
    }

    public Usuário getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuário usuario) {
        this.usuario = usuario;
    }
}
