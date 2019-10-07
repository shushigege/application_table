package com.example.application_table;

public class SheTuan {
    private String name;
    private int imageId;
    public SheTuan(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
