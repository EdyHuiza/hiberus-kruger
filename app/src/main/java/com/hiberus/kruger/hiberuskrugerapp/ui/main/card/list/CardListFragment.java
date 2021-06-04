package com.hiberus.kruger.hiberuskrugerapp.ui.main.card.list;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.hiberus.kruger.hiberuskrugerapp.R;
import com.hiberus.kruger.hiberuskrugerapp.databinding.FragmentCardListBinding;
import com.hiberus.kruger.hiberuskrugerapp.network.models.Card;
import com.hiberus.kruger.hiberuskrugerapp.util.BundleTag;
import com.hiberus.kruger.hiberuskrugerapp.util.VerticalSpacingItemDecoration;
import com.hiberus.kruger.hiberuskrugerapp.util.ViewModelProviderFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardListFragment extends DaggerFragment implements CardListRecyclerAdapter.OnCardListener {

    private static final String TAG = "ProfileFragment";
    private CardListViewModel viewModel;
    @Inject
    ViewModelProviderFactory providerFactory;
    FragmentCardListBinding binding;

    private CardListRecyclerAdapter adapter;
    List<Card> mCards = new ArrayList<>();
    private Bundle bundle;


    public CardListFragment() {
        // Required empty public constructor
    }

    public static CardListFragment newInstance(String param1, String param2) {
        CardListFragment fragment = new CardListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bundle = getArguments();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCardListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ProfileFragment was created...");
        viewModel = new ViewModelProvider(this, providerFactory).get(CardListViewModel.class);
        initRecyclerView();
        subscribeObservers();
    }

    private void initRecyclerView() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        VerticalSpacingItemDecoration itemDecoration = new VerticalSpacingItemDecoration(15);
        binding.recyclerView.addItemDecoration(itemDecoration);
        adapter = new CardListRecyclerAdapter(mCards, this);
        binding.recyclerView.setAdapter(adapter);

    }

    private void subscribeObservers() {
        viewModel.observeCards().removeObservers(getViewLifecycleOwner());
        viewModel.observeCards().observe(getViewLifecycleOwner(), listResource -> {
            if (listResource != null) {
                switch (listResource.status) {
                    case LOADING: {
                        Log.d(TAG, "onChanged: LOADING...");
                        break;
                    }
                    case SUCCESS: {
                        Log.d(TAG, "onChanged: get posts...");
                        if (mCards.size() > 0) {
                            mCards.clear();
                        }
                        if (mCards != null) {
                            mCards.addAll(listResource.data.getCards());
                        }
                        adapter.notifyDataSetChanged();
                        break;
                    }
                    case ERROR: {
                        Log.e(TAG, "onChanged: ERROR..." + listResource.message);
                        break;
                    }
                }
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onCardClick(int position) {
        bundle = new Bundle();
        bundle.putString(BundleTag.CARD.value(), new Gson().toJson(mCards.get(position)));
        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.cardDetailScreen, bundle);
    }
}