package com.example.aa.tugaspw.GoBooking;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.aa.tugaspw.R;
import com.example.aa.tugaspw.RinjaniFragment.DetailRinjani;
import com.example.aa.tugaspw.RinjaniFragment.ReviewsRinjani;
import com.example.aa.tugaspw.RinjaniFragment.VisitRinjani;

import java.util.ArrayList;
import java.util.List;

public class GoBookingGunungRinjani extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_booking_gunung_rinjani);


        android.support.v7.widget.Toolbar mToolbar = findViewById(R.id.toolbarDetailRinjani);
        mToolbar.setTitle("Gunung");
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setNavigationIcon(R.drawable.ic_kiri);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        viewPager = findViewById(R.id.viewPagerRinjani);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabRinjani);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DetailRinjani(), "Detail");
        adapter.addFragment(new ReviewsRinjani(), "Reviews");
        adapter.addFragment(new VisitRinjani(), "Visit");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
