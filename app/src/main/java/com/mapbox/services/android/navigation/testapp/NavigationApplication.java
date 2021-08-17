package com.mapbox.services.android.navigation.testapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.text.TextUtils;
import android.util.Log;

import com.mapbox.mapboxsdk.Mapbox;
import com.squareup.leakcanary.LeakCanary;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import timber.log.Timber;

public class NavigationApplication extends Application {

  private static final String LOG_TAG = NavigationApplication.class.getSimpleName();
  private static final String DEFAULT_MAPBOX_ACCESS_TOKEN = "YOUR_MAPBOX_ACCESS_TOKEN_GOES_HERE";

  @Override
  public void onCreate() {
    super.onCreate();

    // Leak canary
    if (LeakCanary.isInAnalyzerProcess(this)) {
      return;
    }
    LeakCanary.install(this);

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

    // Set access token
    String mapboxAccessToken = Utils.getMapboxAccessToken(getApplicationContext());
    if (TextUtils.isEmpty(mapboxAccessToken) || mapboxAccessToken.equals(DEFAULT_MAPBOX_ACCESS_TOKEN)) {
      Log.w(LOG_TAG, "Warning: access token isn't set.");
    }

    Mapbox instance = Mapbox.getInstance(getApplicationContext(), mapboxAccessToken);
    try {
      Field telemetryField = Mapbox.class.getDeclaredField("telemetry");
      telemetryField.setAccessible(true);
      telemetryField.set(instance, null);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  static void setFinalStatic(Field field, Object newValue) throws Exception {
    field.setAccessible(true);

    Field modifiersField = Field.class.getDeclaredField("modifiers");
    modifiersField.setAccessible(true);
    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

    field.set(null, newValue);
  }
}
