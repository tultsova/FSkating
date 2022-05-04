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

public class FragmentBookSingle extends Fragment implements View.OnClickListener {
    ImageButton btnJumps, btnSpins, btnBook1, btnBook2;

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
        View root = inflater.inflate(R.layout.book_single_fragment, container, false);
        btnJumps = root.findViewById(R.id.btn_jumps);
        btnJumps.setOnClickListener(this);
        btnSpins = root.findViewById(R.id.btn_spins);
        btnSpins.setOnClickListener(this);
        btnBook1 = root.findViewById(R.id.btn_book1);
        btnBook1.setOnClickListener(this);
        btnBook2= root.findViewById(R.id.btn_book2);
        btnBook2.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        FragmentManager fm = requireActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (view.getId()) {
            default: {
                ft.replace(R.id.fc, new FragmentError());
                ft.addToBackStack(null);
                ft.commit();
                break;
            }
        }
    }
}
