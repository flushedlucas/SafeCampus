package com.ufrpe.safecampus.controller;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by lucas on 25/07/17.
 */

public class NetworkConnection {

    private static NetworkConnection instance;
    private RequestQueue mRequestQueue;
    private Context mContext;

    public NetworkConnection(Context context){
        mContext = context;
        mRequestQueue = getRequestQueue();
    }

    public static NetworkConnection getInstance(Context context){
        if (instance == null){
            instance = new NetworkConnection(context.getApplicationContext());
        }
        return(instance);
    }

    public RequestQueue getRequestQueue(){
        if (mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(mContext);
        }
        return (mRequestQueue);
    }

    public <T> void addRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }

    public void cancelPendingRequests (Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

}
