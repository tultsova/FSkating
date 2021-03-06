package com.example.fskating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.fskating.fragments.FragmentBookMain;
import com.example.fskating.fragments.FragmentCards;
import com.example.fskating.fragments.FragmentHome;
import com.example.fskating.fragments.FragmentVideo;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private Fragment frHome;
    private Fragment frBookMain;
    private Fragment frVideo;
    private Fragment frCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        frHome = new FragmentHome();
        frBookMain = new FragmentBookMain();
        frVideo = new FragmentVideo();
        frCards = new FragmentCards();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(
                item -> {
                    int itemId = item.getItemId();
                    switch (itemId) {
                        case R.id.ic_home: {
                            replaceNavigation(frHome);
                            break;
                        }
                        case R.id.ic_book: {
                            replaceNavigation(frBookMain);
                            break;
                        }
                        case R.id.ic_video: {
                            replaceNavigation(frVideo);
                            break;
                        }
                        case R.id.ic_skate: {
                            replaceNavigation(frCards);
                            break;
                        }
                        default:
                            break;
                    }
                    return true;
                }
        );
    }

    private void replaceNavigation(Fragment fr) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fc, fr);
        ft.addToBackStack(null);
        ft.commit();
    }
}