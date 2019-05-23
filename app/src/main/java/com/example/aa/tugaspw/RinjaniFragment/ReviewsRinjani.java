package com.example.aa.tugaspw.RinjaniFragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.aa.tugaspw.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewsRinjani extends Fragment {

    FloatingActionButton addReviews;
    Dialog d;

    public ReviewsRinjani() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reviews_rinjani, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addReviews = view.findViewById(R.id.addReviews);

        addReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addReview();
            }
        });

    }

    private void addReview() {
        d = new Dialog(getContext());
        d.setTitle("Add Reviews");
        d.setContentView(R.layout.form_add_reviews);

        Button cancel = d.findViewById(R.id.cancel_action);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.hide();
            }
        });

        d.show();

    }
}
