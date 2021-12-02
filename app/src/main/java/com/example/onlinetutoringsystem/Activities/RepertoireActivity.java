package com.example.onlinetutoringsystem.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinetutoringsystem.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class RepertoireActivity extends AppCompatActivity {
    YouTubePlayerView youTubePlayerView1, youTubePlayerView2, youTubePlayerView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repertoire_layout);

        youTubePlayerView1 = findViewById(R.id.youtube_player_view1);
        youTubePlayerView2 = findViewById(R.id.youtube_player_view2);
        youTubePlayerView3 = findViewById(R.id.youtube_player_view3);
        getLifecycle().addObserver(youTubePlayerView1);
        getLifecycle().addObserver(youTubePlayerView2);
        getLifecycle().addObserver(youTubePlayerView3);


    }
}