package com.example.fskating.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fskating.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FragmentHome extends Fragment {

    Button date;
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
            View root = inflater.inflate(R.layout.main_fragment, container, false);
            date = root.findViewById(R.id.date);

            Calendar c = Calendar.getInstance();
            Locale locales = new Locale("ru");
            SimpleDateFormat dayf = new SimpleDateFormat("dd\nMMMM", locales);
            String formattedDay = dayf.format(c.getTime());
            date.setText(formattedDay);
            date.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            FragmentManager fm = requireActivity().getSupportFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.fc, new FragmentCalendarCompetition());
                            ft.addToBackStack(null);
                            ft.commit();
                        }
                    }
            );
            return root;
        }

}
