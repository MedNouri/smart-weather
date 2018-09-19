package com.example.android.smartWeather.app.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SmartWeatherSyncService extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static SmartWeatherSyncAdapter sSmartWeatherAdapter = null;

    @Override
    public void onCreate() {
        Log.d("SmartWeatherSyncService", "onCreate - SmartWeatherSyncService");
        synchronized (sSyncAdapterLock) {
            if (sSmartWeatherAdapter == null) {
                sSmartWeatherAdapter = new SmartWeatherSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sSmartWeatherAdapter.getSyncAdapterBinder();
    }
}