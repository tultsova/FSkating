package com.example.fskating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    Fragment fr;
    private TextView mSelectText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    }

        /*VideoView videoRt = findViewById(R.id.video_rt);
        String videoPathRt = "android.resource://" + getPackageName() + "/" + R.raw.video_rt;
        Uri videoRtUri = Uri.parse(videoPathRt);
        videoRt.setVideoURI(videoRtUri);

        MediaController mediaController = new MediaController(this);
        videoRt.setMediaController(mediaController);
        mediaController.setAnchorView(videoRt);

        VideoView videoPt = findViewById(R.id.video_pt);
        String videoPathPt = "android.resource://" + getPackageName() + "/" + R.raw.video_pt;
        Uri videoPtUri = Uri.parse(videoPathPt);
        videoPt.setVideoURI(videoPtUri);

        MediaController mediaController2 = new MediaController(this);
        videoPt.setMediaController(mediaController2);
        mediaController2.setAnchorView(videoPt);*/

}