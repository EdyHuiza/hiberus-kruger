package com.hiberus.kruger.hiberuskrugerapp.ui.main.card.detail;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class CardDetailViewModel extends ViewModel {
    private static final String TAG = "ProfileViewModel";

    @Inject
    public CardDetailViewModel() {
        Log.d(TAG, "ProfileViewModel: viewmodel is ready...");
    }
}
