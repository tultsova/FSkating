package com.example.fskating;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public final class FragmentChanger {
    public static void replaceFragment(FragmentManager fm, int resId, Fragment newFragment) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(resId, newFragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
