package com.hiberus.kruger.hiberuskrugerapp.di.main;

import androidx.lifecycle.ViewModel;

import com.hiberus.kruger.hiberuskrugerapp.di.module.ViewModelKey;
import com.hiberus.kruger.hiberuskrugerapp.ui.main.card.detail.CardDetailViewModel;
import com.hiberus.kruger.hiberuskrugerapp.ui.main.card.list.CardListViewModel;
import com.hiberus.kruger.hiberuskrugerapp.ui.main.home.HomeViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    public abstract ViewModel bindHomeViewModel(HomeViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CardListViewModel.class)
    public abstract ViewModel bindCardListViewModel(CardListViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CardDetailViewModel.class)
    public abstract ViewModel bindCardDetailViewModel(CardDetailViewModel viewModel);

}
