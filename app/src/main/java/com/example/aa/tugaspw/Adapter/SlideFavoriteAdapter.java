package com.example.aa.tugaspw.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aa.tugaspw.Helper.RealmHelper;
import com.example.aa.tugaspw.Model.PesananModel;
import com.example.aa.tugaspw.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SlideFavoriteAdapter extends RecyclerView.Adapter<SlideFavoriteAdapter.ViewHolder> {

    List<PesananModel> modelList;
    MyListener myListener;

    public SlideFavoriteAdapter(List<PesananModel> foodModels, MyListener myListener) {

        this.modelList = foodModels;
        this.myListener = myListener;

    }

    @NonNull
    @Override
    public SlideFavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.slide_favorite_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SlideFavoriteAdapter.ViewHolder viewHolder, int i) {

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm realm = Realm.getInstance(realmConfiguration);
        final RealmHelper realmHelper = new RealmHelper(realm);
        final int idPesanan = modelList.get(i).getId();

        Picasso.get().load(modelList.get(i).getGambar_pesanan()).into(viewHolder.gambarPesanan);
        viewHolder.namaPesanan.setText(modelList.get(i).getNama_pesanan());
        viewHolder.tanggalPesanan.setText(modelList.get(i).getTanggal_berangkat());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gambarPesanan;
        TextView namaPesanan, tanggalPesanan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gambarPesanan = itemView.findViewById(R.id.gambar_pesanan);
            namaPesanan = itemView.findViewById(R.id.nama_pesanan);
            tanggalPesanan = itemView.findViewById(R.id.tanggalPesanan);
            gambarPesanan.setScaleType(ImageView.ScaleType.CENTER_CROP);

        }
    }

    public class MyListener {
    }
}
