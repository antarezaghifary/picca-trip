package com.example.aa.tugaspw;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import com.example.aa.tugaspw.Adapter.InfoAdapter;
import com.example.aa.tugaspw.Model.DummyModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArtikelFragment extends Fragment {

    ViewFlipper viewFlipper;
    RelativeLayout next, prev;

    RecyclerView recyclerView;
    InfoAdapter infoAdapter;
    ArrayList<DummyModel> dummyModelArrayList;

    public ArtikelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artikel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int images[] = {R.drawable.hutan, R.drawable.bumper1, R.drawable.pantai};

        viewFlipper = view.findViewById(R.id.view_flipper);
        next = view.findViewById(R.id.next);
        prev = view.findViewById(R.id.prev);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
                viewFlipper.setInAnimation(getContext(), android.R.anim.fade_in);
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious();
                viewFlipper.setInAnimation(getContext(), android.R.anim.fade_out);
            }
        });

        for (int image : images) {
            setViewFlipper(image);
        }


        recyclerView = view.findViewById(R.id.recyclerView);

        if (recyclerView != null) {

            addData();
            infoAdapter = new InfoAdapter(dummyModelArrayList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(infoAdapter);

        }

    }

    private void addData() {

        dummyModelArrayList = new ArrayList<>();
        dummyModelArrayList.add(new DummyModel(R.drawable.airterjun, "isi 1"));
        dummyModelArrayList.add(new DummyModel(R.drawable.bumper1, "isi 2"));
        dummyModelArrayList.add(new DummyModel(R.drawable.danau, "isi 3"));
        dummyModelArrayList.add(new DummyModel(R.drawable.gunung1, "isi 4"));
        dummyModelArrayList.add(new DummyModel(R.drawable.hutan, "isi 5"));
        dummyModelArrayList.add(new DummyModel(R.drawable.pantai, "isi 6"));
        dummyModelArrayList.add(new DummyModel(R.drawable.danau, "isi 7"));

    }

    public void setViewFlipper(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(image);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(getContext(), android.R.anim.fade_in);
        viewFlipper.setOutAnimation(getContext(), android.R.anim.fade_out);

    }

}
