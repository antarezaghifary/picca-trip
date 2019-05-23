package com.example.aa.tugaspw.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aa.tugaspw.Go.GoBumper;
import com.example.aa.tugaspw.Go.GoGunung;
import com.example.aa.tugaspw.Go.GoPantai;
import com.example.aa.tugaspw.Model.HomeMenuModel;
import com.example.aa.tugaspw.R;

import java.util.ArrayList;

public class HomeMenuAdapter extends RecyclerView.Adapter<HomeMenuAdapter.ViewHolder> {

    private ArrayList<HomeMenuModel> homeMenuModelArrayList;

    public HomeMenuAdapter(ArrayList<HomeMenuModel> homeMenuModelArrayList) {

        this.homeMenuModelArrayList = homeMenuModelArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.menu_home, viewGroup, false);

        return new HomeMenuAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HomeMenuAdapter.ViewHolder viewHolder, int i) {
        viewHolder.imageHome.setImageResource(homeMenuModelArrayList.get(i).getGambarHome());
        viewHolder.textHome.setText(homeMenuModelArrayList.get(i).getNamaHome());
    }

    @Override
    public int getItemCount() {
        return (homeMenuModelArrayList != null) ? homeMenuModelArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageHome;
        private TextView textHome;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            imageHome = itemView.findViewById(R.id.imageItem);
            textHome = itemView.findViewById(R.id.textItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Intent goGunung, goPantai, goBumper, goAirTerjun, goDanau, goHutan;

                    goGunung = new Intent(itemView.getContext(), GoGunung.class);
                    goPantai = new Intent(itemView.getContext(), GoPantai.class);
                    goBumper = new Intent(itemView.getContext(), GoBumper.class);

                    if (position == 0) {
                        itemView.getContext().startActivity(goGunung);
                    } else if (position == 1) {
                        itemView.getContext().startActivity(goPantai);
                    } else if (position == 2) {
                        itemView.getContext().startActivity(goBumper);
                    } else {
                        Toast.makeText(itemView.getContext(), "Belum Ada Layout", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }
}
