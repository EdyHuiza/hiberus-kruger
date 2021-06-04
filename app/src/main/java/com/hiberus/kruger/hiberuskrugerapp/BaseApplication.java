package com.hiberus.kruger.hiberuskrugerapp;

import com.hiberus.kruger.hiberuskrugerapp.di.component.AppComponent;
import com.hiberus.kruger.hiberuskrugerapp.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {
    private final AppComponent appInjector = DaggerAppComponent.builder().application(this).build();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return appInjector;
    }
}
