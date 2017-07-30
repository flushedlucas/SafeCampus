package com.ufrpe.safecampus.controller;

import android.content.Context;

import com.ufrpe.safecampus.model.Ocorrencia;
import com.ufrpe.safecampus.model.Pessoa;
import com.ufrpe.safecampus.model.Usuario;

/**
 * Created by wellington on 29/07/17.
 */

public class BotaoPanicoController {

    public void registrarOcorrencia(Context context){

        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setTipo_ocorrencia("para_mim");
        ocorrencia.setData_ocorrencia(Hora.getDate());
        ocorrencia.setDescricao("Roubo na potaria do prédio, dois homens de moto. ");
        ocorrencia.setLocal_ocorrencia("parada de zootecnia");
        Usuario usuario = new Usuario();
        Pessoa pessoa = new Pessoa();
        ocorrencia.setNome_vitima(pessoa.getNome());
        ocorrencia.setEmail_vitima(pessoa.getEmail());
        ocorrencia.setUsuario(usuario);
        ocorrencia.setHora(Hora.getTime());
        RegistroController registroController = new RegistroController(context);
        registroController.enviarRegistro(ocorrencia);

    }
//    public  void voltar(View v){
//        Intent voltar = new Intent(v.getContext(), TelaInicialActivity.class);
//        context.startActivity(voltar);
//    }

}

