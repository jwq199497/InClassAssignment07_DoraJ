package com.example.android.inclassassignment07_doraj;

public interface Keys {
    String BRAND = "brand";
    String ORIGIN = "origin";
    String MORE_INFO = "info";

    Water water = new Water(BRAND, ORIGIN);
    String WATER = water.toString();
}