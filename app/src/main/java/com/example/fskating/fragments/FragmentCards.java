package com.example.fskating.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fskating.AdapterCards;
import com.example.fskating.R;
import com.example.fskating.view_models.ViewModelCard;
import com.example.fskating.view_models.ViewModelCards;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentCards extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View root = inflater.inflate(R.layout.cards_fragment, container, false);

        ViewModelCards viewModelCards =  new ViewModelProvider(this).get(ViewModelCards.class);


        RecyclerView rv = root.findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new GridLayoutManager(requireActivity(), 2);
        rv.setLayoutManager(lm);
        AdapterCards adapterCards = new AdapterCards(this);
        rv.setAdapter(adapterCards);

        viewModelCards.getAllCards().observe(getViewLifecycleOwner(), cards -> {
            adapterCards.setCardsList(cards);
            adapterCards.notifyDataSetChanged();
        });

        return root;
    }
}
