package com.example.aa.tugaspw.GoBooking;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.aa.tugaspw.GoaCinaFragment.DetailGoaCina;
import com.example.aa.tugaspw.R;
import com.example.aa.tugaspw.RinjaniFragment.ReviewsRinjani;
import com.example.aa.tugaspw.RinjaniFragment.VisitRinjani;

import java.util.ArrayList;
import java.util.List;

public class GoBookingPantaiGoaCina extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_booking_pantai_goa_cina);
        Toolbar toolbar = findViewById(R.id.toolbarPantaiGoaCina);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewPagerGoaCina);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabGoaCina);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DetailGoaCina(), "Detail");
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
