package com.narara.myapplication_2.models;

public class CardItem {
    private String title;
    private String contents;

    @Override
    public String toString() {
        return "CardItem{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public CardItem(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
