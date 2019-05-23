package com.example.aa.tugaspw.Model;

public class HomeMenuModel {

    private int gambarHome;
    private String namaHome;

    public HomeMenuModel(int gambarHome, String namaHome) {
        this.gambarHome = gambarHome;
        this.namaHome = namaHome;
    }

    public int getGambarHome() {
        return gambarHome;
    }

    public void setGambarHome(int gambarHome) {
        this.gambarHome = gambarHome;
    }

    public String getNamaHome() {
        return namaHome;
    }

    public void setNamaHome(String namaHome) {
        this.namaHome = namaHome;
    }
}
