package com.example.android.smartWeather.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.app.OnNavigationBlockedListener;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.heinrichreimersoftware.materialintro.slide.Slide;


public class MainIntroActivity extends IntroActivity {
     public static final int REQUEST_CODE_INTRO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainIntroActivity.this);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("PREF_KEY_FIRST_START", false);
        editor.commit();




        super.onCreate(savedInstanceState);



        addSlide(new SimpleSlide.Builder()
                .title(R.string.Welcome_To_Smart_Weather)
                .description(R.string.description_welcome)
                .image(R.drawable.art_light_clouds)
                .background(R.color.smartWeather_light_blue)
                .backgroundDark(R.color.color_dark_material_motion)

                .build());

        addSlide(new SimpleSlide.Builder()
                .title(R.string.title_Welcome_2)
                .description(R.string.description_title_Welcome_2)
                .image(R.drawable.art_light_rain)
                .background(R.color.color_material_bold)
                .backgroundDark(R.color.color_dark_material_bold)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title(R.string.title_Welcome_3)
                .description(R.string.description_title_Welcome_3)
                .image(R.drawable.art_storm)
                .background(R.color.color_material_motion)
                .backgroundDark(R.color.color_dark_material_motion)

                .build());

        addSlide(new SimpleSlide.Builder()
                .title(R.string.title_Welcome_4)
                .description(R.string.description_title_Welcome_4)
                .image(R.drawable.art_snow)
                .background(R.color.color_material_shadow)
                .backgroundDark(R.color.color_dark_material_shadow)

                .build());


        addSlide(new FragmentSlide.Builder()
                .background(R.color.smartWeather_light_blue)
                .backgroundDark(R.color.color_dark_material_motion)
                .fragment(R.layout.fragment_location, R.style.AppThemeDark)

             .build());




        addSlide(new FragmentSlide.Builder()
                .background(R.color.color_custom_fragment_2)
                .backgroundDark(R.color.color_dark_custom_fragment_2)
                .fragment(R.layout.fragment_custom, R.style.AppThemeDark)
                .canGoForward(false)
                .buttonCtaLabel("Start ")
                .buttonCtaClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast
                                .makeText(MainIntroActivity.this, R.string.toast_button_cta, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();

                        // No need For Intro
                        Intent intent = new Intent(MainIntroActivity.this, MainActivity.class);
                        startActivity(intent);
                       finish();
                    }
                })
                .build());





    }


}
