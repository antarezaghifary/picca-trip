package com.example.aa.tugaspw;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class HistoryPesanan extends AppCompatActivity {

    Toolbar goBefore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_pesanan);

        goBefore = findViewById(R.id.toolbarHistory);
        goBefore.setTitle("History Pesanan");
        goBefore.setTitleTextColor(Color.WHITE);
        goBefore.setNavigationIcon(R.drawable.ic_kiri);

        goBefore.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
