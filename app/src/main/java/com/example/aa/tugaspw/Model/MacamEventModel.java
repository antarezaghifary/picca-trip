package com.example.aa.tugaspw.Model;

public class MacamEventModel {

    private int imageEvent;
    private String namaEvent;

    public MacamEventModel(int imageEvent, String namaEvent) {
        this.imageEvent = imageEvent;
        this.namaEvent = namaEvent;
    }

    public int getImageEvent() {
        return imageEvent;
    }

    public void setImageEvent(int imageEvent) {
        this.imageEvent = imageEvent;
    }

    public String getNamaEvent() {
        return namaEvent;
    }

    public void setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
    }
}
