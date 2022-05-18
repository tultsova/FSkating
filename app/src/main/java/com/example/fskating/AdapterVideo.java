package com.example.fskating;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fskating.models.ModelVideo;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterVideo extends RecyclerView.Adapter<AdapterVideo.VideoView>{
    private List<ModelVideo> videoList;

    public AdapterVideo() {
        this.videoList = new ArrayList<>();
    }

    public void setVideoList(List<ModelVideo> videoList) {
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public AdapterVideo.VideoView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_item, parent, false);
        return new AdapterVideo.VideoView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVideo.VideoView holder, int position) {
        ModelVideo modelVideo = videoList.get(position);
        holder.getName().setText(modelVideo.getName());
        holder.cueVideo(modelVideo.getURL());
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    class VideoView extends RecyclerView.ViewHolder {

        private final TextView name;
        private final YouTubePlayerView video;
        private YouTubePlayer videoPlayer;
        private String currentVideoId;

        public VideoView(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            video = itemView.findViewById(R.id.youtube);

            video.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    videoPlayer = youTubePlayer;
                    videoPlayer.cueVideo(currentVideoId, 0);
                }
            });
        }



        public TextView getName() {
            return name;
        }

        public void cueVideo(String videoId) {
            this.currentVideoId = videoId;
            if(videoPlayer == null)
                return;
            videoPlayer.cueVideo(videoId, 0);
        }

    }
}
