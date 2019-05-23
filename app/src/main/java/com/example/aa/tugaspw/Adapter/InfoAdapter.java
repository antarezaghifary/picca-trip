package com.example.aa.tugaspw.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aa.tugaspw.Model.DummyModel;
import com.example.aa.tugaspw.R;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoAdapterViewHolder> {

    private ArrayList<DummyModel> dummyModels;

    public InfoAdapter(ArrayList<DummyModel> dummyModels) {
        this.dummyModels = dummyModels;
    }

    @NonNull
    @Override
    public InfoAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_info, viewGroup, false);

        return new InfoAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InfoAdapterViewHolder infoAdapterViewHolder, int i) {
        infoAdapterViewHolder.imageInfo.setImageResource(dummyModels.get(i).getGambar());
        infoAdapterViewHolder.textInfo.setText(dummyModels.get(i).getInfo_berita());
    }

    @Override
    public int getItemCount() {
        return (dummyModels != null) ? dummyModels.size() : 0;
    }

    public class InfoAdapterViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageInfo;
        private TextView textInfo;

        public InfoAdapterViewHolder(View itemView) {
            super(itemView);

            imageInfo = itemView.findViewById(R.id.imageItem);
            imageInfo.setScaleType(ImageView.ScaleType.CENTER_CROP);
            textInfo = itemView.findViewById(R.id.textInfo);


        }
    }
}
