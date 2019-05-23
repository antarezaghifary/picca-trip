package com.example.aa.tugaspw.Model;

public class MacamPantaiModel {

    private int gambarPantai;
    private String namaPantai;

    public MacamPantaiModel(int gambarPantai, String namaPantai) {

        this.gambarPantai = gambarPantai;
        this.namaPantai = namaPantai;

    }

    public int getGambarPantai() {
        return gambarPantai;
    }

    public void setGambarPantai(int gambarPantai) {
        this.gambarPantai = gambarPantai;
    }

    public String getNamaPantai() {
        return namaPantai;
    }

    public void setNamaPantai(String namaPantai) {
        this.namaPantai = namaPantai;
    }
}
