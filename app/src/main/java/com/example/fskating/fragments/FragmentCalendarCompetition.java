package com.example.fskating.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fskating.AdapterCompetition;
import com.example.fskating.R;
import com.example.fskating.view_models.ViewModelCalendarCompetition;

import java.text.SimpleDateFormat;
import java.util.Locale;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentCalendarCompetition extends Fragment {
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
        View root = inflater.inflate(R.layout.calendar_fragment, container, false);

        ViewModelCalendarCompetition viewModelCalendarCompetition =
                new ViewModelProvider(this).get(ViewModelCalendarCompetition.class);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(layoutManager);
        AdapterCompetition adapterCompetition = new AdapterCompetition();
        recyclerView.setAdapter(adapterCompetition);
        viewModelCalendarCompetition.getCompetitions().observe(getViewLifecycleOwner(), competition -> {
            adapterCompetition.setCompetitionsList(competition);
            adapterCompetition.notifyDataSetChanged();
        });
        CalendarView calendarView = root.findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i2 + "." + (i1+1);
                viewModelCalendarCompetition.inputDate(date);
            }
        });

        return root;
    }
}
