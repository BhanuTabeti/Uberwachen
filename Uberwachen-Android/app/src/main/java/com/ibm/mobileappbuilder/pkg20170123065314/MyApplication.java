

package com.ibm.mobileappbuilder.pkg20170123065314;

import android.app.Application;
import ibmmobileappbuilder.injectors.ApplicationInjector;

import android.graphics.Typeface;
import android.support.multidex.MultiDexApplication;
import android.widget.TextView;


/**
 * You can use this as a global place to keep application-level resources
 * such as singletons, services, etc.
 */
public class MyApplication extends MultiDexApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationInjector.setApplicationContext(this);

    }
}
