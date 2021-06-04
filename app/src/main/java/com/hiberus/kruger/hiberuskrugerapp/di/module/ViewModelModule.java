package com.hiberus.kruger.hiberuskrugerapp.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.hiberus.kruger.hiberuskrugerapp.util.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelFactory);

}