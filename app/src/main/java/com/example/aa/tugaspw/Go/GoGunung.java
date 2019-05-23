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

import com.example.aa.tugaspw.Adapter.MacamGunungAdapter;
import com.example.aa.tugaspw.Model.MacamGunungModel;
import com.example.aa.tugaspw.R;

import java.util.ArrayList;

public class GoGunung extends AppCompatActivity {

    ViewFlipper viewFlipperGunung;
    RecyclerView recyclerViewGunung;

    MacamGunungAdapter gunungAdapter;
    ArrayList<MacamGunungModel> macamGunungModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_gunung);

        Toolbar mToolbar = findViewById(R.id.toolbarGoGunung);
        mToolbar.setTitle("Gunung");
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setNavigationIcon(R.drawable.ic_kiri);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        int imageGunung[] = {R.drawable.gunung_andong_di_magelang, R.drawable.gunung_berapi_dengan_api_biru_kawah_ijen_jawa_timur, R.drawable.gunung_bromo, R.drawable.gunung_merbabu, R.drawable.gunung_rinjani};

        viewFlipperGunung = findViewById(R.id.view_flipper_gunung);
        recyclerViewGunung = findViewById(R.id.recyclerViewHorizontalGunung);

        addData();

        gunungAdapter = new MacamGunungAdapter(macamGunungModelArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewGunung.setLayoutManager(layoutManager);
        recyclerViewGunung.setAdapter(gunungAdapter);

        for (int image : imageGunung) {
            setViewFlipper(image);
        }

    }

    private void addData() {

        macamGunungModelArrayList = new ArrayList<>();
        macamGunungModelArrayList.add(new MacamGunungModel(R.drawable.gunung_rinjani, "Gunung Rinjani"));
        macamGunungModelArrayList.add(new MacamGunungModel(R.drawable.gunung_andong_di_magelang, "Gunung Andong"));
        macamGunungModelArrayList.add(new MacamGunungModel(R.drawable.gunung_berapi_dengan_api_biru_kawah_ijen_jawa_timur, "Kawah Ijen"));
        macamGunungModelArrayList.add(new MacamGunungModel(R.drawable.gunung_bromo, "Gunung Bromo"));
        macamGunungModelArrayList.add(new MacamGunungModel(R.drawable.gunung_merbabu, "Gunung Merbabu"));

    }

    private void setViewFlipper(int image) {
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setBackgroundResource(image);

        viewFlipperGunung.addView(imageView);
        viewFlipperGunung.setFlipInterval(3000);
        viewFlipperGunung.setAutoStart(true);

        viewFlipperGunung.setInAnimation(getApplicationContext(), android.R.anim.fade_in);
        viewFlipperGunung.setOutAnimation(getApplicationContext(), android.R.anim.fade_out);
    }
}
