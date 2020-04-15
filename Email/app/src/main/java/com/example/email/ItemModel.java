package com.example.email;

public class ItemModel {
    String name;
    String time;
    String subject;
    String content;
    int favourImage;
    boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemModel(String name, String time, String subject, String content, int favourImage) {
        this.name = name;
        this.time = time;
        this.subject = subject;
        this.content = content;
        this.favourImage = favourImage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFavourImage() {
        return favourImage;
    }

    public void setFavourImage(int favourImage) {
        this.favourImage = favourImage;
    }


}
