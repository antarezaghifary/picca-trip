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
import com.example.aa.tugaspw.Model.MacamPantaiModel;
import com.example.aa.tugaspw.R;

import java.util.ArrayList;

public class MacamPantaiAdapter extends RecyclerView.Adapter<MacamPantaiAdapter.MacamPantaiAdapterViewHolder> {

    private ArrayList<MacamPantaiModel> macamPantaiModelArrayList;

    public MacamPantaiAdapter(ArrayList<MacamPantaiModel> macamPantaiModelArrayList) {
        this.macamPantaiModelArrayList = macamPantaiModelArrayList;
    }

    @NonNull
    @Override
    public MacamPantaiAdapter.MacamPantaiAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.macam_pantai, viewGroup, false);

        return new MacamPantaiAdapter.MacamPantaiAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MacamPantaiAdapter.MacamPantaiAdapterViewHolder macamPantaiAdapterViewHolder, int i) {
        macamPantaiAdapterViewHolder.imageInfo.setBackgroundResource(macamPantaiModelArrayList.get(i).getGambarPantai());
        macamPantaiAdapterViewHolder.textInfo.setText(macamPantaiModelArrayList.get(i).getNamaPantai());
    }

    @Override
    public int getItemCount() {
        return (macamPantaiModelArrayList != null) ? macamPantaiModelArrayList.size() : 0;
    }

    public class MacamPantaiAdapterViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageInfo;
        private TextView textInfo;

        public MacamPantaiAdapterViewHolder(final View itemView) {
            super(itemView);

            imageInfo = itemView.findViewById(R.id.imageItemPantai);
            textInfo = itemView.findViewById(R.id.textItemPantai);

            imageInfo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();

                    if (pos == 1) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), GoBookingPantaiGoaCina.class));
                    } else {
                        Toast.makeText(itemView.getContext(), "Belum Ada Layoutnya boss", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }
}
