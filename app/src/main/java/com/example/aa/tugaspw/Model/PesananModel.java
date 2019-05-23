package com.example.aa.tugaspw.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PesananModel extends RealmObject {

    @PrimaryKey
    private Integer id;
    private String nama_pesanan, nama_pemesan, tanggal_berangkat, tanggal_pulang, jumlah_orang, gambar_pesanan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama_pesanan() {
        return nama_pesanan;
    }

    public void setNama_pesanan(String nama_pesanan) {
        this.nama_pesanan = nama_pesanan;
    }

    public String getNama_pemesan() {
        return nama_pemesan;
    }

    public void setNama_pemesan(String nama_pemesan) {
        this.nama_pemesan = nama_pemesan;
    }

    public String getTanggal_berangkat() {
        return tanggal_berangkat;
    }

    public void setTanggal_berangkat(String tanggal_berangkat) {
        this.tanggal_berangkat = tanggal_berangkat;
    }

    public String getTanggal_pulang() {
        return tanggal_pulang;
    }

    public void setTanggal_pulang(String tanggal_pulang) {
        this.tanggal_pulang = tanggal_pulang;
    }

    public String getJumlah_orang() {
        return jumlah_orang;
    }

    public void setJumlah_orang(String jumlah_orang) {
        this.jumlah_orang = jumlah_orang;
    }

    public String getGambar_pesanan() {
        return gambar_pesanan;
    }

    public void setGambar_pesanan(String gambar_pesanan) {
        this.gambar_pesanan = gambar_pesanan;
    }
}
