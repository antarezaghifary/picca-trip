package com.example.aa.tugaspw.RinjaniFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.aa.tugaspw.BookPayment.BookingRinjani;
import com.example.aa.tugaspw.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailRinjani extends Fragment {

    Button goBookRinjani;

    public DetailRinjani() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_rinjani, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        goBookRinjani = view.findViewById(R.id.btnBookingRinjani);

        goBookRinjani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookingRinjani.class));
            }
        });

    }

}
