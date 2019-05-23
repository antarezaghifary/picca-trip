package com.example.aa.tugaspw;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.aa.tugaspw.Home.MainActivityBeranda;
import com.example.aa.tugaspw.OnBoard.OnBoardingActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout l1;
    ImageView l2;

    Animation downtoup;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l2 = findViewById(R.id.l2);
        downtoup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.downtoup);

        l2.setAnimation(downtoup);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.picca);
        mp.start();

        final Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        Thread myThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    if (isFirstRun) {
                        startActivity(new Intent(getApplication(), OnBoardingActivity.class));
                        mp.stop();
                    } else {
                        startActivity(new Intent(getApplication(), MainActivityBeranda.class));
                        mp.stop();
                    }
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                            .putBoolean("isFirstRun", false).commit();
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        myThread.start();

    }
}
