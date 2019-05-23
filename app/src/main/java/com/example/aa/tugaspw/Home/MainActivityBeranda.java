package com.example.aa.tugaspw.Home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.aa.tugaspw.ArtikelFragment;
import com.example.aa.tugaspw.EventFragment;
import com.example.aa.tugaspw.FavoriteFragment;
import com.example.aa.tugaspw.HomeFragment;
import com.example.aa.tugaspw.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivityBeranda extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabsIcons = {
            R.drawable.home_fragment,
            R.drawable.artikelnew,
            R.drawable.pesanan1,
            R.drawable.eventnew
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_beranda);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabsIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabsIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabsIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabsIcons[3]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), "Home");
        adapter.addFrag(new ArtikelFragment(), "Artikel");
        adapter.addFrag(new FavoriteFragment(), "Favorite");
        adapter.addFrag(new EventFragment(), "Event");
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

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
    }

}
