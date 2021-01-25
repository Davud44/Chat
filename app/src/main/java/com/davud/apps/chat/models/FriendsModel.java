package com.davud.apps.chat.models;

public class FriendsModel {
    int id;
    String image;
    String name;


    public FriendsModel(int id, String image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

}
