package com.example.aa.tugaspw;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aa.tugaspw.Adapter.MacamEventAdapter;
import com.example.aa.tugaspw.Go.goToPoint;
import com.example.aa.tugaspw.Model.MacamEventModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {

    RecyclerView recyclerViewEvent;

    ImageView goPoint;

    MacamEventAdapter eventAdapter;
    ArrayList<MacamEventModel> macamEventModelArrayList;

    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        recyclerViewEvent = view.findViewById(R.id.rvEvent);

        addData();

        eventAdapter = new MacamEventAdapter(macamEventModelArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewEvent.setLayoutManager(layoutManager);
        recyclerViewEvent.setAdapter(eventAdapter);

        goPoint = view.findViewById(R.id.goPoint);
        goPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), goToPoint.class));
            }
        });

        return view;
    }

    private void addData() {

        macamEventModelArrayList = new ArrayList<>();
        macamEventModelArrayList.add(new MacamEventModel(R.drawable.gunung_rinjani, "Rinjani"));
        macamEventModelArrayList.add(new MacamEventModel(R.drawable.gunung_rinjani, "asdzc"));
        macamEventModelArrayList.add(new MacamEventModel(R.drawable.gunung_rinjani, "qwewq"));
        macamEventModelArrayList.add(new MacamEventModel(R.drawable.gunung_rinjani, "asd"));

    }

}
