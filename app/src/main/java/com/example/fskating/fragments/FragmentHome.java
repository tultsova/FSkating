package com.example.fskating.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fskating.AdapterVideo;
import com.example.fskating.R;
import com.example.fskating.view_models.ViewModelVideo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
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

            ViewModelVideo viewModelVideo =
                    new ViewModelProvider(this).get(ViewModelVideo.class);
            RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireActivity());
            recyclerView.setLayoutManager(layoutManager);
            AdapterVideo adapterVideo = new AdapterVideo();
            recyclerView.setAdapter(adapterVideo);

            viewModelVideo.getAllVideo().observe(getViewLifecycleOwner(), video -> {
                adapterVideo.setVideoList(video);
                adapterVideo.notifyDataSetChanged();
            });

            return root;
        }

}
