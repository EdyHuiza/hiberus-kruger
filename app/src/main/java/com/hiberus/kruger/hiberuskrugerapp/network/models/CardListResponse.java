package com.hiberus.kruger.hiberuskrugerapp.network.models;

import java.util.List;

import lombok.Data;

@Data
public class CardListResponse {
    private List<Card> cards;
}