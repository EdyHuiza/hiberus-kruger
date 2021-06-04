package com.hiberus.kruger.hiberuskrugerapp.di.main;

import com.hiberus.kruger.hiberuskrugerapp.network.main.CardApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @Provides
    static CardApi provideCardApi(Retrofit retrofit) {
        return retrofit.create(CardApi.class);
    }

}
