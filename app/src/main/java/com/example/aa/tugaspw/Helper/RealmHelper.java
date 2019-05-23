package com.example.aa.tugaspw.Helper;

import android.util.Log;

import com.example.aa.tugaspw.Model.PesananModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {

    Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    // untuk menyimpan data
    public void save(final PesananModel mahasiswaModel) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null) {
                    Log.e("Created", "DB was created");
                    Number currentIdNum = realm.where(PesananModel.class).max("id");
                    int nextId;
                    if (currentIdNum == null) {
                        nextId = 1;
                    } else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    mahasiswaModel.setId(nextId);
                    PesananModel model = realm.copyToRealm(mahasiswaModel);
                } else {
                    Log.e("", "DB not Found");
                }
            }
        });
    }

    // untuk memanggil semua data
    public List<PesananModel> getAllData() {
        RealmResults<PesananModel> results = realm.where(PesananModel.class).findAll();
        return results;
    }

    // untuk meng-update data
    public void update(final Integer id, final String nama_pesanan, final String nama_pemesan, final String tanggal_berangkat, final String tanggal_pulang, final String jumlah_orang, final String gambar_pesanan) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                PesananModel model = realm.where(PesananModel.class)
                        .equalTo("id", id)
                        .findFirst();
                model.setNama_pemesan(nama_pemesan);
                model.setNama_pesanan(nama_pesanan);
                model.setTanggal_berangkat(tanggal_berangkat);
                model.setTanggal_pulang(tanggal_pulang);
                model.setJumlah_orang(jumlah_orang);
                model.setGambar_pesanan(gambar_pesanan);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("", "onSuccess: Update Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }


    // untuk menghapus data
    public void delete(Integer id) {
        final RealmResults<PesananModel> model = realm.where(PesananModel.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }

}
