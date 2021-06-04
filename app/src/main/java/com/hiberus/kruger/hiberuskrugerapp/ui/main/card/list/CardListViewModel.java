package com.hiberus.kruger.hiberuskrugerapp.ui.main.card.list;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.hiberus.kruger.hiberuskrugerapp.network.Resource;
import com.hiberus.kruger.hiberuskrugerapp.network.main.CardApi;
import com.hiberus.kruger.hiberuskrugerapp.network.models.CardListResponse;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;

public class CardListViewModel extends ViewModel {
    private static final String TAG = "CardListViewModel";
    private final CardApi cardApi;

    @Inject
    public CardListViewModel(CardApi cardApi) {
        this.cardApi = cardApi;
        Log.d(TAG, "ProfileViewModel: viewmodel is ready...");
    }

    public LiveData<Resource<CardListResponse>> observeCards() {
        return LiveDataReactiveStreams.fromPublisher(
                cardApi.findAll().onErrorReturn(throwable -> {
                    return null;
                })
                        .map(resultDelivery -> {
                            if (resultDelivery == null) {
                                return Resource.error("Could not connect to api", (CardListResponse) null);
                            }
                            return Resource.success(resultDelivery);
                        })
                        .subscribeOn(Schedulers.io())
        );
    }
}
