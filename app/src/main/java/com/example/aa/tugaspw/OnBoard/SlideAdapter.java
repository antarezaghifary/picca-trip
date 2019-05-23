package com.example.aa.tugaspw.OnBoard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.aa.tugaspw.R;

public class SlideAdapter extends PagerAdapter {

    public int[] slide_image = {
            R.drawable.home,
            R.drawable.artikel,
            R.drawable.favorit,
            R.drawable.event
    };
    public String[] slide_descs = {
            "Temukan pemandangan alam yang luar biasa dan kesempatan berkemah",
            "Bagikan informasi tentang perjalanan dan jadikan  perjalanan Anda lebih Baik",
            "Ketuk favorit dan pertahankan perjalanan yang Anda cintai selamanya",
            "Membantu Anda menemukan pertunjukan terbaru, acara menjadi lebih baik dan membuat momen kebahagiaan"
    };
    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return slide_descs.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideDescription = view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_image[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout) object);

    }
}
