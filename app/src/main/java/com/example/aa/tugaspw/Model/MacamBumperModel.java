package com.example.aa.tugaspw.Model;

public class MacamBumperModel {

    int gambarBumper;
    String namaBumper;

    public MacamBumperModel(int gambarBumper, String namaBumper) {

        this.gambarBumper = gambarBumper;
        this.namaBumper = namaBumper;

    }

    public int getGambarBumper() {
        return gambarBumper;
    }

    public void setGambarBumper(int gambarBumper) {
        this.gambarBumper = gambarBumper;
    }

    public String getNamaBumper() {
        return namaBumper;
    }

    public void setNamaBumper(String namaBumper) {
        this.namaBumper = namaBumper;
    }
}
