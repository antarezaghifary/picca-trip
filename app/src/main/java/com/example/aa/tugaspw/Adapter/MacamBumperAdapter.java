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

import com.example.aa.tugaspw.GoBooking.GoBookingPantaiGoaCina;
import com.example.aa.tugaspw.Model.MacamBumperModel;
import com.example.aa.tugaspw.R;

import java.util.ArrayList;

public class MacamBumperAdapter extends RecyclerView.Adapter<MacamBumperAdapter.MacamBumperAdapterViewHolder> {

    private ArrayList<MacamBumperModel> macamBumperModelArrayList;

    public MacamBumperAdapter(ArrayList<MacamBumperModel> macamBumperModelArrayList) {

        this.macamBumperModelArrayList = macamBumperModelArrayList;

    }

    @NonNull
    @Override
    public MacamBumperAdapter.MacamBumperAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.macam_bumper, viewGroup, false);

        return new MacamBumperAdapter.MacamBumperAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MacamBumperAdapter.MacamBumperAdapterViewHolder macamBumperAdapterViewHolder, int i) {
        macamBumperAdapterViewHolder.imageInfo.setBackgroundResource(macamBumperModelArrayList.get(i).getGambarBumper());
        macamBumperAdapterViewHolder.textInfo.setText(macamBumperModelArrayList.get(i).getNamaBumper());
    }

    @Override
    public int getItemCount() {
        return (macamBumperModelArrayList != null) ? macamBumperModelArrayList.size() : 0;
    }

    public class MacamBumperAdapterViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageInfo;
        private TextView textInfo;

        public MacamBumperAdapterViewHolder(final View itemView) {
            super(itemView);

            imageInfo = itemView.findViewById(R.id.imageItemBumper);
            textInfo = itemView.findViewById(R.id.textItemBumper);

            imageInfo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();

                    if (pos == 0) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), GoBookingPantaiGoaCina.class));
                    } else {
                        Toast.makeText(itemView.getContext(), "Belum Ada Layoutnya boss", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }
}