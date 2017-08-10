package com.ufrpe.safecampus.controller;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wellington on 25/07/17.
 */

public class Hora {

    public static String getTime() {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("HH:mm");
        String guardaHora = simpleFormat.format( new Date(System.currentTimeMillis() ) );
        Log.w("Hora Atual", guardaHora );
        return guardaHora;
    }
    public static String getDate() {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
        String guardaData = simpleFormat.format( new Date(System.currentTimeMillis() ) );
        Log.w("Data Atual", guardaData );
        return guardaData;
    }
}
