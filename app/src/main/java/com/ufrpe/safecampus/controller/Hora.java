package com.ufrpe.safecampus.controller;

import android.icu.util.Calendar;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wellington on 25/07/17.
 */

public class Hora {

    public String getDateTime() {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("HH:mm:ss");
        String guardaHora = simpleFormat.format( new Date(System.currentTimeMillis() ) );
        Log.w("Data Atual", guardaHora );
        return guardaHora;
    }
}
