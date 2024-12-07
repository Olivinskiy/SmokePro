package com.olivinskij.smokepro;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.SimpleExoPlayer;

import java.util.HashMap;
import java.util.Map;

public class TutorialActivity extends AppCompatActivity {

    public TextView mapposition;
    private VideoView videoView;
    private ExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tutorial);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mapposition = findViewById(R.id.mapposition);
        String mapPosition = getIntent().getStringExtra("map_position");

        if (mapPosition != null) {
            Map<String, String> positionMap = new HashMap<>();
            positionMap.put("smoke_anubis_ct_1", "SMOKE MAIN CT");
            positionMap.put("smoke_anubis_ct_2", "SMOKE DOORS CT");
            positionMap.put("smoke_anubis_ct_3", "SMOKE BRIDGE CT");
            positionMap.put("smoke_anubis_ct_4", "SMOKE HEAVEN CT");
            positionMap.put("smoke_anubis_ct_5", "SMOKE CONNECTOR CT");

            positionMap.put("smoke_anubis_t_1", "SMOKE HEAVEN T");
            positionMap.put("smoke_anubis_t_2", "SMOKE ALLEY T");
            positionMap.put("smoke_anubis_t_3", "SMOKE CONNECTOR T");
            positionMap.put("smoke_anubis_t_4", "SMOKE HEAVEN2 T");
            positionMap.put("smoke_anubis_t_5", "SMOKE PALACE T");

            String positionText = positionMap.getOrDefault(mapPosition, "Unknown Position");
            mapposition.setText(positionText);
        } else {
            mapposition.setText("Unknown Position");
        }

        PlayerView playerView = findViewById(R.id.playerView);
        player = new SimpleExoPlayer.Builder(this).build();
        playerView.setPlayer(player);

        player.prepare();
        player.play();

        if (mapposition.getText().toString().equals("SMOKE CONNECTOR T")) {
            MediaItem mediaItem = MediaItem.fromUri("http://45.43.88.250/anubis_con.mp4");
            player.setMediaItem(mediaItem);
        }
        if (mapposition.getText().toString().equals("SMOKE PALACE T")) {
            MediaItem mediaItem = MediaItem.fromUri("http://45.43.88.250/anubis_temple.mp4");
            player.setMediaItem(mediaItem);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.release();
        }
    }
}