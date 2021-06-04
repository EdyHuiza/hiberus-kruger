package com.hiberus.kruger.hiberuskrugerapp.di.component;

import android.app.Application;

import com.hiberus.kruger.hiberuskrugerapp.di.module.ActivityBuildersModule;
import com.hiberus.kruger.hiberuskrugerapp.di.module.AppModule;
import com.hiberus.kruger.hiberuskrugerapp.di.module.ViewModelFactoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuildersModule.class,
        AppModule.class,
        ViewModelFactoryModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
