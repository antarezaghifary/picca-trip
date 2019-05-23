package com.example.aa.tugaspw.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aa.tugaspw.Go.goToEvent;
import com.example.aa.tugaspw.Model.MacamEventModel;
import com.example.aa.tugaspw.R;

import java.util.ArrayList;

public class MacamEventAdapter extends RecyclerView.Adapter<MacamEventAdapter.MacamEventAdapterViewHolder> {

    ArrayList<MacamEventModel> macamEventModelArrayList;

    public MacamEventAdapter(ArrayList<MacamEventModel> macamEventModelArrayList) {
        this.macamEventModelArrayList = macamEventModelArrayList;
    }

    @NonNull
    @Override
    public MacamEventAdapter.MacamEventAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.macam_event, viewGroup, false);

        return new MacamEventAdapter.MacamEventAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MacamEventAdapter.MacamEventAdapterViewHolder macamEventAdapterViewHolder, int i) {
        macamEventAdapterViewHolder.imageInfo.setImageResource(macamEventModelArrayList.get(i).getImageEvent());
        macamEventAdapterViewHolder.textInfo.setText(macamEventModelArrayList.get(i).getNamaEvent());
    }

    @Override
    public int getItemCount() {
        return (macamEventModelArrayList != null) ? macamEventModelArrayList.size() : 0;
    }

    public class MacamEventAdapterViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageInfo;
        private TextView textInfo;
        private Button btn;

        public MacamEventAdapterViewHolder(@NonNull final View itemView) {
            super(itemView);

            imageInfo = itemView.findViewById(R.id.imageItemEvent);
            textInfo = itemView.findViewById(R.id.textItemEvent);
            btn = itemView.findViewById(R.id.btnReadMore);

            imageInfo.setScaleType(ImageView.ScaleType.CENTER_CROP);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int pos = getAdapterPosition();

                    if (pos == 0) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), goToEvent.class));
                    } else {
                        Toast.makeText(itemView.getContext(), "Belum Ada Layoutnya untuk Event ini", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }
}
