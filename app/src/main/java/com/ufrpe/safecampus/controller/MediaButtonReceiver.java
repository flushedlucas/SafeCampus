package com.ufrpe.safecampus.controller;

/**
 * Created by lucas on 20/07/17.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class MediaButtonReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Session session = Session.getInstanciaSessao();
        if (session.getPanico()) {
//            int prevVolume;
//            int volume;
//            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
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
