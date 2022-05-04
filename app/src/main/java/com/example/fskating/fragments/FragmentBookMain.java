package com.example.fskating.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fskating.R;

public class FragmentBookMain extends Fragment implements View.OnClickListener {
    ImageButton btnSingle, btnScore, btnDance, btnPairs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.book_main_fragment, container, false);
        btnSingle = root.findViewById(R.id.btn_single);
        btnSingle.setOnClickListener(this);
        btnScore = root.findViewById(R.id.btn_score);
        btnScore.setOnClickListener(this);
        btnDance = root.findViewById(R.id.btn_dance);
        btnDance.setOnClickListener(this);
        btnPairs = root.findViewById(R.id.btn_pairs);
        btnPairs.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        FragmentManager fm = requireActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.btn_single: {
                ft.replace(R.id.fc, new FragmentBookSingle());
                ft.addToBackStack(null);
                ft.commit();
                break;
            }
            default: {
                ft.replace(R.id.fc, new FragmentError());
                ft.addToBackStack(null);
                ft.commit();
                break;
            }
        }
    }
}
