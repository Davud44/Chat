package com.davud.apps.chat.models;

import java.util.ArrayList;

public class AllChatModel {
    int id;
    String name;
    ArrayList<String> images;
    String image;
    boolean isOnline;
    String lastMessage;
    String lastMessageDate;
    boolean isGroup;

    public AllChatModel(int id, String name, String image, boolean isOnline, String lastMessage, String lastMessageDate, boolean isGroup) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.isOnline = isOnline;
        this.lastMessage = lastMessage;
        this.lastMessageDate = lastMessageDate;
        this.isGroup = isGroup;
    }

    public AllChatModel(int id, String name, ArrayList<String> images, String lastMessage, String lastMessageDate, boolean isGroup) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.lastMessage = lastMessage;
        this.lastMessageDate = lastMessageDate;
        this.isGroup = isGroup;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public String getImage() {
        return image;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getLastMessageDate() {
        return lastMessageDate;
    }

    public boolean isGroup() {
        return isGroup;
    }
}
