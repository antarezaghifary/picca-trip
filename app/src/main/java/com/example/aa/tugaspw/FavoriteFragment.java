package com.example.aa.tugaspw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.aa.tugaspw.Adapter.SlideFavoriteAdapter;
import com.example.aa.tugaspw.Helper.RealmHelper;
import com.example.aa.tugaspw.Model.PesananModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class FavoriteFragment extends Fragment {

    RecyclerView recyclerView;
    RealmHelper realmHelper;
    SlideFavoriteAdapter.MyListener myListener;
    Toolbar tb;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_favorite, container, false);

        recyclerView = v.findViewById(R.id.rvPemesanan);

        tb = v.findViewById(R.id.toolbarPesanan);
        ((AppCompatActivity) getActivity()).setSupportActionBar(tb);
        setHasOptionsMenu(true);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        Realm.init(getContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm realm = Realm.getInstance(realmConfiguration);
        realmHelper = new RealmHelper(realm);

        setAdapter();

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.history, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.show_history) {
            Intent userProfile = new Intent(getContext(), HistoryPesanan.class);
            startActivity(userProfile);
        }
        return super.onOptionsItemSelected(item);
    }

    private void setAdapter() {

        List<PesananModel> foodModels = realmHelper.getAllData();
        SlideFavoriteAdapter favoriteAdapter;
        favoriteAdapter = new SlideFavoriteAdapter(foodModels, myListener);
        recyclerView.setAdapter(favoriteAdapter);

    }

}
