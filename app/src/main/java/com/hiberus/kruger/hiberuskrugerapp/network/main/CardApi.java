package com.hiberus.kruger.hiberuskrugerapp.network.main;

import com.hiberus.kruger.hiberuskrugerapp.network.models.CardListResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface CardApi {
    @GET("v1/cards")
    Flowable<CardListResponse> findAll();

}