package com.example.aa.tugaspw.Go;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.aa.tugaspw.Adapter.MacamBumperAdapter;
import com.example.aa.tugaspw.Model.MacamBumperModel;
import com.example.aa.tugaspw.R;

import java.util.ArrayList;

public class GoBumper extends AppCompatActivity {

    ViewFlipper viewFlipperBumper;
    RecyclerView recyclerViewBumper;

    MacamBumperAdapter bumperAdapter;
    ArrayList<MacamBumperModel> macamBumperModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_bumper);


        Toolbar mToolbar = findViewById(R.id.toolbarGoBumper);
        mToolbar.setTitle("Bumi Perkemahan");
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setNavigationIcon(R.drawable.ic_kiri);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        int imageBumper[] = {R.drawable.puncak_bintang_bandung, R.drawable.apache_camp_coban_talun, R.drawable.basecamp_mawar, R.drawable.bumi_perkemahan_bedengan, R.drawable.bumi_perkemahan_ledok_ombo};

        viewFlipperBumper = findViewById(R.id.view_flipper_bumper);
        recyclerViewBumper = findViewById(R.id.recyclerViewHorizontalBumper);

        addData();

        bumperAdapter = new MacamBumperAdapter(macamBumperModelArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewBumper.setLayoutManager(layoutManager);
        recyclerViewBumper.setAdapter(bumperAdapter);

        for (int image : imageBumper) {
            setViewFlipper(image);
        }

    }

    private void setViewFlipper(int image) {
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setBackgroundResource(image);

        viewFlipperBumper.addView(imageView);
        viewFlipperBumper.setFlipInterval(3000);
        viewFlipperBumper.setAutoStart(true);

        viewFlipperBumper.setInAnimation(getApplicationContext(), android.R.anim.fade_in);
        viewFlipperBumper.setOutAnimation(getApplicationContext(), android.R.anim.fade_out);
    }

    private void addData() {

        macamBumperModelArrayList = new ArrayList<>();
        macamBumperModelArrayList.add(new MacamBumperModel(R.drawable.puncak_bintang_bandung, "Bumper Bintang Bandung"));
        macamBumperModelArrayList.add(new MacamBumperModel(R.drawable.apache_camp_coban_talun, "Camp Coban Talun"));
        macamBumperModelArrayList.add(new MacamBumperModel(R.drawable.basecamp_mawar, "Basecamp Mawar"));
        macamBumperModelArrayList.add(new MacamBumperModel(R.drawable.bumi_perkemahan_bedengan, "Bumper Bendengan"));
        macamBumperModelArrayList.add(new MacamBumperModel(R.drawable.bumi_perkemahan_ledok_ombo, "Bumper Ledok Ombo"));

    }
}
