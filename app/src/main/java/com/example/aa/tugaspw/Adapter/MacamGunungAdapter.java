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

import com.example.aa.tugaspw.GoBooking.GoBookingGunungRinjani;
import com.example.aa.tugaspw.Model.MacamGunungModel;
import com.example.aa.tugaspw.R;

import java.util.ArrayList;

public class MacamGunungAdapter extends RecyclerView.Adapter<MacamGunungAdapter.MacamGunungAdapterViewHolder> {

    private ArrayList<MacamGunungModel> macamGunungModelArrayList;

    public MacamGunungAdapter(ArrayList<MacamGunungModel> macamGunungModelArrayList) {

        this.macamGunungModelArrayList = macamGunungModelArrayList;

    }

    @NonNull
    @Override
    public MacamGunungAdapter.MacamGunungAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.macam_gunung, viewGroup, false);

        return new MacamGunungAdapter.MacamGunungAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MacamGunungAdapter.MacamGunungAdapterViewHolder macamGunungAdapterViewHolder, int i) {
        macamGunungAdapterViewHolder.imageInfo.setBackgroundResource(macamGunungModelArrayList.get(i).getGambarGunung());
        macamGunungAdapterViewHolder.textInfo.setText(macamGunungModelArrayList.get(i).getNamaGunung());
    }

    @Override
    public int getItemCount() {
        return (macamGunungModelArrayList != null) ? macamGunungModelArrayList.size() : 0;
    }

    public class MacamGunungAdapterViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageInfo;
        private TextView textInfo;

        public MacamGunungAdapterViewHolder(final View itemView) {
            super(itemView);

            imageInfo = itemView.findViewById(R.id.imageItemGunung);
            textInfo = itemView.findViewById(R.id.textItemGunung);

            imageInfo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();

                    if (pos == 0) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), GoBookingGunungRinjani.class));
                    } else {
                        Toast.makeText(itemView.getContext(), "Belum Ada Layoutnya boss", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }

}
