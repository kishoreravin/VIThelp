package com.example.acer.vithelp.Model;

public class Word {

    private String name;
    private int ImageResource;
    private String hostel;

    public Word(String na, int imgres){
        name = na;
        ImageResource = imgres;

    }
    public Word (String na, int imgres,String hos){
        name = na;
        ImageResource = imgres;
        hostel = hos;
    }

    public int getImageResource(){
        return ImageResource;
    }

    public String getName() {
        return name;
    }

    public String getHostel() {
        return hostel;
    }
}
