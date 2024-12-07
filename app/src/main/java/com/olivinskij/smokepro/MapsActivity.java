package com.olivinskij.smokepro;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.dmoral.toasty.Toasty;

public class MapsActivity extends AppCompatActivity {

    int typemap = 1;
    public TextView textView4, textView5;

    public ScrollView othermaps, mainmaps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_maps);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainmaps = findViewById(R.id.mainmaps);
        othermaps = findViewById(R.id.othermaps);

        ImageView icAnubis = findViewById(R.id.ic_anubis);

        ImageView icDust2 = findViewById(R.id.ic_dust2);
        icDust2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, MapActivity.class);
                intent.putExtra("map_name", "DUST 2");
                intent.putExtra("show_image", "dust2map");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        ImageView icVertigo = findViewById(R.id.ic_vertigo);
        icVertigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, MapActivity.class);
                intent.putExtra("map_name", "VERTIGO");
                intent.putExtra("show_image", "vertigomap");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        ImageView icNuke = findViewById(R.id.ic_nuke);
        icNuke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, MapActivity.class);
                intent.putExtra("map_name", "NUKE");
                intent.putExtra("show_image", "nukemap");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        ImageView icMirage = findViewById(R.id.ic_mirage);
        icMirage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, MapActivity.class);
                intent.putExtra("map_name", "MIRAGE");
                intent.putExtra("show_image", "miragemap");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        ImageView icAncient = findViewById(R.id.ic_ancient);
        icAncient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, MapActivity.class);
                intent.putExtra("map_name", "ANCIENT");
                intent.putExtra("show_image", "ancientmap");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });


        ImageView icTrain = findViewById(R.id.ic_train);
        icTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, MapActivity.class);
                intent.putExtra("map_name", "TRAIN");
                intent.putExtra("show_image", "trainmap");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        ImageView icItaly = findViewById(R.id.ic_italy);
        icItaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, MapActivity.class);
                intent.putExtra("map_name", "ITALY");
                intent.putExtra("show_image", "italymap");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        ImageView icOffice = findViewById(R.id.ic_office);
        icOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, MapActivity.class);
                intent.putExtra("map_name", "OFFICE");
                intent.putExtra("show_image", "officemap");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        ImageView icOverpass = findViewById(R.id.ic_overpass);
        icOverpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, MapActivity.class);
                intent.putExtra("map_name", "OVERPASS");
                intent.putExtra("show_image", "overpassmap");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        icAnubis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, MapActivity.class);
                intent.putExtra("map_name", "ANUBIS");
                intent.putExtra("show_image", "anubismap");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        ImageView icInferno = findViewById(R.id.ic_inferno);
        icInferno.setOnClickListener(v -> {
            Intent intent = new Intent(MapsActivity.this, MapActivity.class);
            intent.putExtra("map_name", "INFERNO");
            intent.putExtra("show_image", "infernomap");
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });


        LinearLayout mapsbuttons = findViewById(R.id.mapsbuttons);
        mapsbuttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.error(MapsActivity.this, "Ты и так тут, дурачье.", Toast.LENGTH_SHORT, true).show();
            }
        });

        LinearLayout settingsbuttons = findViewById(R.id.settingsbuttons);
        settingsbuttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, SettingsActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });


        textView4 = findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setTextColor(Color.parseColor("#FFFFFF"));
                textView5.setTextColor(Color.parseColor("#7A8A98"));
                mainmaps.setVisibility(View.VISIBLE);
                othermaps.setVisibility(View.GONE);
            }
        });
        textView5 = findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView5.setTextColor(Color.parseColor("#FFFFFF"));
                textView4.setTextColor(Color.parseColor("#7A8A98"));
                mainmaps.setVisibility(View.GONE);
                othermaps.setVisibility(View.VISIBLE);
            }
        });

        textView4.setTextColor(Color.parseColor("#FFFFFF"));
        textView5.setTextColor(Color.parseColor("#7A8A98"));


    }
}