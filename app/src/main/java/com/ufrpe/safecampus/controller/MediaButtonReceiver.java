package com.ufrpe.safecampus.controller;

/**
 * Created by lucas on 20/07/17.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class MediaButtonReceiver extends BroadcastReceiver {
    private  int cont = 1;
    private String usandoHora;
    private Hora hora = new Hora();

    public String getUsandoHora() {
        return usandoHora;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        Session session = Session.getInstanciaSessao();
        if (session.getPanico()) {
            usandoHora = hora.getDateTime();
            session.setCont(cont);

//            int prevVolume;
//            int volume;
//            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
//
//                volume = (int) intent.getExtras().get("android.media.EXTRA_VOLUME_STREAM_VALUE");
//                prevVolume = (int) intent.getExtras().get("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE");
//                if (volume < prevVolume) {
//                    Toast.makeText(context, "Volume down!", Toast.LENGTH_SHORT).show();
//
//                } else if (volume > prevVolume) {
//                    Toast.makeText(context, "Volume up!", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(context, "Volume equals!", Toast.LENGTH_SHORT).show();
//                }
//            }

        }

    }


}
