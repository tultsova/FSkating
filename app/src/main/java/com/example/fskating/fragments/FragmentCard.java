package com.example.fskating.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fskating.AdapterCards;
import com.example.fskating.AdapterCompetition;
import com.example.fskating.R;
import com.example.fskating.view_models.ViewModelCalendarCompetition;
import com.example.fskating.view_models.ViewModelCard;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentCard extends Fragment {

    Long id;

    public FragmentCard(Long id) {
        this.id = id;
    }

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

        View root = inflater.inflate(R.layout.card_fragment, container, false);

        ViewModelCard viewModelCard =
                new ViewModelProvider(this).get(ViewModelCard.class);
        TextView name = root.findViewById(R.id.name);
        TextView staff = root.findViewById(R.id.staff);
        TextView sp = root.findViewById(R.id.sp);
        TextView pp = root.findViewById(R.id.pp);
        YouTubePlayerView SP = root.findViewById(R.id.youtube_SP);
        YouTubePlayerView FP = root.findViewById(R.id.youtube_FP);
        viewModelCard.getCardInfo(id).observe(getViewLifecycleOwner(), card -> {
            name.setText(card.getName());
            staff.setText(card.getCoachingStaff());
            sp.setText(card.getSP());
            pp.setText(card.getFP());
            SP.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    youTubePlayer.cueVideo(card.getUrlSP(), 0);
                }
            });
            FP.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    youTubePlayer.cueVideo(card.getUrlFP(), 0);
                }
            });
        });

        return root;
    }
}

