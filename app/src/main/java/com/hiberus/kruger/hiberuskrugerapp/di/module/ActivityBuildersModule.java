package com.hiberus.kruger.hiberuskrugerapp.di.module;


import com.hiberus.kruger.hiberuskrugerapp.di.main.MainFragmentBuildersModule;
import com.hiberus.kruger.hiberuskrugerapp.di.main.MainModule;
import com.hiberus.kruger.hiberuskrugerapp.di.main.MainViewModelsModule;
import com.hiberus.kruger.hiberuskrugerapp.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {


    @ContributesAndroidInjector(modules = {
            MainFragmentBuildersModule.class,
            MainViewModelsModule.class,
            MainModule.class
    })
    abstract MainActivity contributeMainActivity();
}