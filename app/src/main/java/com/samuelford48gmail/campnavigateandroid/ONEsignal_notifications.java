package com.samuelford48gmail.campnavigateandroid;

import android.app.Application;

import com.onesignal.OneSignal;

public class ONEsignal_notifications extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
}
