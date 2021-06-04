package com.hiberus.kruger.hiberuskrugerapp.ui.main.card.detail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.hiberus.kruger.hiberuskrugerapp.R;
import com.hiberus.kruger.hiberuskrugerapp.databinding.FragmentCardDetailBinding;
import com.hiberus.kruger.hiberuskrugerapp.network.models.Card;
import com.hiberus.kruger.hiberuskrugerapp.util.BundleTag;
import com.hiberus.kruger.hiberuskrugerapp.util.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardDetailFragment extends DaggerFragment {

    private static final String TAG = "CardDetailFragment";

    FragmentCardDetailBinding binding;
    @Inject
    ViewModelProviderFactory providerFactory;
    private CardDetailViewModel viewModel;
    private Card card;

    public CardDetailFragment() {
        // Required empty public constructor
    }

    public static CardDetailFragment newInstance(String param1, String param2) {
        CardDetailFragment fragment = new CardDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            card = new Gson().fromJson(getArguments().getString(BundleTag.CARD.value()), Card.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCardDetailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ProfileFragment was created...");
        viewModel = new ViewModelProvider(this, providerFactory).get(CardDetailViewModel.class);

        binding.textViewCardName.setText(card.getName());
        binding.textViewCardType.setText(card.getType());
        Glide.with(this)
                .load(card.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .error(R.drawable.not_found)
                .into(binding.imageViewCard);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}