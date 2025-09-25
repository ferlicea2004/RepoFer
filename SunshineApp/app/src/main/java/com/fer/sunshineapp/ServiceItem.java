package com.fer.sunshineapp;

public class ServiceItem {
    String title;
    int imageRes;

    public ServiceItem(String title, int imageRes) {
        this.title = title;
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public int getImageRes() {
        return imageRes;
    }
}
