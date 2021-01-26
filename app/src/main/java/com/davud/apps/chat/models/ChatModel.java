package com.davud.apps.chat.models;

public class ChatModel {
    int id;
    String image;
    String message;
    boolean isOnline;
    boolean isImage;
    boolean isMe;

    public ChatModel(int id, String image, String message, boolean isOnline, boolean isImage, boolean isMe) {
        this.id = id;
        this.image = image;
        this.message = message;
        this.isOnline = isOnline;
        this.isImage = isImage;
        this.isMe = isMe;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getMessage() {
        return message;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public boolean isImage() {
        return isImage;
    }

    public boolean isMe() {
        return isMe;
    }
}
