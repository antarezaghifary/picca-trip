package com.example.aa.tugaspw.Model;

public class MacamGunungModel {

    private int gambarGunung;
    private String namaGunung;

    public MacamGunungModel(int danau, String s) {

        this.gambarGunung = danau;
        this.namaGunung = s;

    }

    public int getGambarGunung() {
        return gambarGunung;
    }

    public void setGambarGunung(int gambarGunung) {
        this.gambarGunung = gambarGunung;
    }

    public String getNamaGunung() {
        return namaGunung;
    }

    public void setNamaGunung(String namaGunung) {
        this.namaGunung = namaGunung;
    }
}
