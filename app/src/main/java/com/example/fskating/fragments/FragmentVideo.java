package com.example.fskating.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fskating.AdapterCompetition;
import com.example.fskating.AdapterVideo;
import com.example.fskating.R;
import com.example.fskating.view_models.ViewModelCalendarCompetition;
import com.example.fskating.view_models.ViewModelVideo;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentVideo extends Fragment {
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
        View root = inflater.inflate(R.layout.video_fragment, container, false);

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
