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

import com.example.aa.tugaspw.Adapter.MacamPantaiAdapter;
import com.example.aa.tugaspw.Model.MacamPantaiModel;
import com.example.aa.tugaspw.R;

import java.util.ArrayList;

public class GoPantai extends AppCompatActivity {

    ViewFlipper viewFlipperPantai;
    RecyclerView recyclerViewPantai;

    MacamPantaiAdapter pantaiAdapter;
    ArrayList<MacamPantaiModel> macamPantaiModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_pantai);


        Toolbar mToolbar = findViewById(R.id.toolbarGoPantai);
        mToolbar.setTitle("Pantai");
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setNavigationIcon(R.drawable.ic_kiri);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        int imagePantai[] = {R.drawable.pantai_teluk_asmoro, R.drawable.pantai_watu_pecah, R.drawable.pantai_tiga_warna, R.drawable.pantai_batu_bengkung, R.drawable.pantai_goa_cina};

        viewFlipperPantai = findViewById(R.id.view_flipper_pantai);
        recyclerViewPantai = findViewById(R.id.recyclerViewHorizontalPantai);

        addData();

        pantaiAdapter = new MacamPantaiAdapter(macamPantaiModelArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPantai.setLayoutManager(layoutManager);
        recyclerViewPantai.setAdapter(pantaiAdapter);

        for (int image : imagePantai) {
            setViewFlipper(image);
        }

    }

    private void setViewFlipper(int image) {
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setBackgroundResource(image);

        viewFlipperPantai.addView(imageView);
        viewFlipperPantai.setFlipInterval(3000);
        viewFlipperPantai.setAutoStart(true);

        viewFlipperPantai.setInAnimation(getApplicationContext(), android.R.anim.fade_in);
        viewFlipperPantai.setOutAnimation(getApplicationContext(), android.R.anim.fade_out);
    }

    private void addData() {

        macamPantaiModelArrayList = new ArrayList<>();
        macamPantaiModelArrayList.add(new MacamPantaiModel(R.drawable.pantai_batu_bengkung, "Pantai Batu Bengkung"));
        macamPantaiModelArrayList.add(new MacamPantaiModel(R.drawable.pantai_goa_cina, "Pantai Goa Cina"));
        macamPantaiModelArrayList.add(new MacamPantaiModel(R.drawable.pantai_teluk_asmoro, "Pantai Teluk Asmoro"));
        macamPantaiModelArrayList.add(new MacamPantaiModel(R.drawable.pantai_tiga_warna, "Pantai Tiga Warna"));
        macamPantaiModelArrayList.add(new MacamPantaiModel(R.drawable.pantai_watu_pecah, "Pantai Watu Pecah"));

    }
}
