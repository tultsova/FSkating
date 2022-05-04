package com.example.fskating.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    TextView day;
    TextView month;
    Date currentDate;
    DateFormat dayFormat;
    DateFormat monthFormat;
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
            day = root.findViewById(R.id.day);
            month = root.findViewById(R.id.month);

            Calendar c = Calendar.getInstance();
            Locale locales = new Locale("ru");
            SimpleDateFormat dayf = new SimpleDateFormat("dd");
            String formattedDay = dayf.format(c.getTime());
            day.setText(formattedDay);
            SimpleDateFormat monthf = new SimpleDateFormat("MMMM", locales);
            String formattedMonth = monthf.format(c.getTime());
            month.setText(formattedMonth);
            return root;
        }

}
