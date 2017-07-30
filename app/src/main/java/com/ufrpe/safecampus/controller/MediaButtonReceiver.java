package com.ufrpe.safecampus.controller;

/**
 * Created by lucas on 20/07/17.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class MediaButtonReceiver extends BroadcastReceiver {
    private int cont = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        Session session = Session.getInstanciaSessao();
        while (session.getPanico()) {
            session.setCont(cont);
            break;
        }

    }



}
