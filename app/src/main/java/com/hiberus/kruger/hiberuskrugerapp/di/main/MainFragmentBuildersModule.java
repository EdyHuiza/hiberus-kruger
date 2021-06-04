package com.hiberus.kruger.hiberuskrugerapp.di.main;

import com.hiberus.kruger.hiberuskrugerapp.ui.main.card.detail.CardDetailFragment;
import com.hiberus.kruger.hiberuskrugerapp.ui.main.card.list.CardListFragment;
import com.hiberus.kruger.hiberuskrugerapp.ui.main.home.HomeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {
    @ContributesAndroidInjector
    abstract HomeFragment contributeHomeFragment();

    @ContributesAndroidInjector
    abstract CardListFragment contributeCardListFragment();

    @ContributesAndroidInjector
    abstract CardDetailFragment contributeCardDetailFragment();

}
