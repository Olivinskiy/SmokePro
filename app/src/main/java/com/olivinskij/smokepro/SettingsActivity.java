package com.olivinskij.smokepro;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.dmoral.toasty.Toasty;

public class SettingsActivity extends AppCompatActivity {

    private ToggleButton toggleButton, toggleButton2;
    private ConstraintLayout activityLayout;
    private SharedPreferences sharedPreferences;
    public ImageView aboutapp, aboutappbtn;
    public TextView aboutapptext;
    public LinearLayout settingsbuttons, mapsbuttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        aboutapp = findViewById(R.id.aboutapp);
        aboutapp.setVisibility(View.GONE);

        aboutapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator fadeOut = ObjectAnimator.ofFloat(aboutapp, "alpha", 1f, 0f);
                fadeOut.setDuration(300);
                fadeOut.start();

                fadeOut.addListener(new android.animation.AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(android.animation.Animator animation) {
                        aboutapp.setVisibility(View.GONE);
                        enableUI(true);
                    }
                });
            }
        });

        aboutapptext = findViewById(R.id.aboutapptext);

        aboutappbtn = findViewById(R.id.aboutappbtn);
        aboutappbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutapp.setVisibility(View.VISIBLE);
                ObjectAnimator fadeIn = ObjectAnimator.ofFloat(aboutapp, "alpha", 0f, 1f);
                fadeIn.setDuration(300);
                fadeIn.start();

                fadeIn.addListener(new android.animation.AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(android.animation.Animator animation) {
                        enableUI(false);
                    }
                });
            }
        });


        mapsbuttons = findViewById(R.id.mapsbuttons);
        mapsbuttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MapsActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

            }
        });

        settingsbuttons = findViewById(R.id.settingsbuttons);
        settingsbuttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.error(SettingsActivity.this, "Ты и так тут, дурачье.", Toast.LENGTH_SHORT, true).show();
            }
        });

        sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);

        int savedMode = sharedPreferences.getInt("theme_mode", AppCompatDelegate.MODE_NIGHT_NO);
        AppCompatDelegate.setDefaultNightMode(savedMode);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        toggleButton2 = findViewById(R.id.notification);
        toggleButton = findViewById(R.id.darktheme);
        activityLayout = findViewById(R.id.main);

        toggleButton.setChecked(savedMode == AppCompatDelegate.MODE_NIGHT_YES);

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ObjectAnimator fadeOut = ObjectAnimator.ofFloat(activityLayout, "alpha", 1f, 0f);
            fadeOut.setDuration(300);
            fadeOut.start();

            fadeOut.addListener(new android.animation.AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(android.animation.Animator animation) {
                    if (isChecked) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        sharedPreferences.edit().putInt("theme_mode", AppCompatDelegate.MODE_NIGHT_YES).apply();
                    } else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        sharedPreferences.edit().putInt("theme_mode", AppCompatDelegate.MODE_NIGHT_NO).apply();
                    }

                    recreate();

                    ObjectAnimator fadeIn = ObjectAnimator.ofFloat(activityLayout, "alpha", 0f, 1f);
                    fadeIn.setDuration(300);
                    fadeIn.start();
                }
            });
        });
    }
    private void enableUI(boolean enable) {
        toggleButton.setEnabled(enable);
        toggleButton2.setEnabled(enable);
        aboutappbtn.setEnabled(enable);
    }
}
