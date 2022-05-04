package com.example.fskating.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fskating.AdapterCards;
import com.example.fskating.R;

import java.util.ArrayList;

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

        RecyclerView rv = root.findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new GridLayoutManager(requireActivity(), 2);
        rv.setLayoutManager(lm);
        AdapterCards adapterCards = new AdapterCards();
        rv.setAdapter(adapterCards);

        ArrayList<Integer> res = new ArrayList<>();
        res.add(R.drawable.anya_card);
        res.add(R.drawable.kamila_card);
        res.add(R.drawable.kisiki_card);
        res.add(R.drawable.mark_card);
        res.add(R.drawable.sasha_card);
        res.add(R.drawable.stepbuk_card);
        adapterCards.setCardsList(res);
        adapterCards.notifyDataSetChanged();

        return root;
    }
}
