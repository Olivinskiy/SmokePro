package com.olivinskij.smokepro;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.chrisbanes.photoview.PhotoView;

public class MapActivity extends AppCompatActivity {

    public PhotoView mapimg;
    public FrameLayout anubis_t, anubis_ct;
    public TextView side, backbtn, namebtn;
    public int sideSelected = 1;
    public int nameShowedOnMap = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

// t anubis
        int[] anubis_t_pos = {
                R.id.smoke_anubis_t_4,
                R.id.smoke_anubis_t_1,
                R.id.smoke_anubis_t_2,
                R.id.smoke_anubis_t_3,
                R.id.smoke_anubis_t_5
        };

        for (int id : anubis_t_pos) {
            ImageView imageView = findViewById(id);

            final int finalId = id;

            imageView.setOnClickListener(view -> {
                String resourceName = getResources().getResourceEntryName(finalId);
                Toast.makeText(MapActivity.this, resourceName, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MapActivity.this, TutorialActivity.class);
                intent.putExtra("map_position", resourceName);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            });
        }

// t anubis

        // ct anubis

        int[] anubis_ct_pos = {
                R.id.smoke_anubis_ct_4,
                R.id.smoke_anubis_ct_1,
                R.id.smoke_anubis_ct_2,
                R.id.smoke_anubis_ct_3,
                R.id.smoke_anubis_ct_5
        };

        for (int id : anubis_ct_pos) {
            ImageView imageView = findViewById(id);

            final int finalId = id;

            imageView.setOnClickListener(view -> {
                String resourceName = getResources().getResourceEntryName(finalId);
                Toast.makeText(MapActivity.this, resourceName, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MapActivity.this, TutorialActivity.class);
                intent.putExtra("map_position", resourceName);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            });
        }


        // ct anubis
        backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, MapsActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });


        mapimg = findViewById(R.id.mapimg);
        mapimg.setMinimumScale(1.0f);
        mapimg.setMaximumScale(3.0f);

        side = findViewById(R.id.side);
        side.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sideSelected == 1)
                {
                    sideSelected = 2;
                    side.setText("CT");
                    anubis_t.setVisibility(View.GONE);
                    anubis_ct.setVisibility(View.VISIBLE);
                }
                else {
                    sideSelected = 1;
                    side.setText("T");
                    anubis_t.setVisibility(View.VISIBLE);
                    anubis_ct.setVisibility(View.GONE);
                }
            }
        });


        anubis_t = findViewById(R.id.anubis_t);
        anubis_ct = findViewById(R.id.anubis_ct);

        TextView mapName = findViewById(R.id.namemap);

        LinearLayout mapsbuttons = findViewById(R.id.mapsbuttons);
        mapsbuttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, MapsActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        LinearLayout settingsbuttons = findViewById(R.id.settingsbuttons);
        settingsbuttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, SettingsActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });



        String mapNameValue = getIntent().getStringExtra("map_name");
        String showImage = getIntent().getStringExtra("show_image");

        namebtn = findViewById(R.id.namebtn);
        namebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("anubismap".equals(showImage)) {
                    if(nameShowedOnMap == 0)
                    {
                        mapimg.setImageResource(R.drawable.anubismapnames);
                        nameShowedOnMap = 1;
                    }
                    else
                    {
                        mapimg.setImageResource(R.drawable.anubismap);
                        nameShowedOnMap = 0;
                    }
                }
            }
        });

        if (mapNameValue != null) {
            mapName.setText(mapNameValue);
        }

        if ("anubismap".equals(showImage)) {
            mapimg.setImageResource(R.drawable.anubismap);
            anubis_t.setVisibility(View.VISIBLE);
        } else if ("infernomap".equals(showImage)) {
            mapimg.setImageResource(R.drawable.infernomap);
        }else if ("dust2map".equals(showImage)) {
            mapimg.setImageResource(R.drawable.dust2map);
        }else if ("vertigomap".equals(showImage)) {
            mapimg.setImageResource(R.drawable.vertigomap);
        }else if ("nukemap".equals(showImage)) {
            mapimg.setImageResource(R.drawable.nukemap);
        }
        else if ("miragemap".equals(showImage)) {
            mapimg.setImageResource(R.drawable.miragemap);
        }
        else if ("ancientmap".equals(showImage)) {
            mapimg.setImageResource(R.drawable.ancientmap);
        }
        else if ("overpassmap".equals(showImage)) {
            mapimg.setImageResource(R.drawable.overpassmap);
        }
        else if ("italymap".equals(showImage)) {
            mapimg.setImageResource(R.drawable.italymap);
        }
        else if ("officemap".equals(showImage)) {
            mapimg.setImageResource(R.drawable.officemap);
        }
        else if ("trainmap".equals(showImage)) {
            mapimg.setImageResource(R.drawable.trainmap);
        }
        }
    }
}