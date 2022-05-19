package com.example.myapplication;

public class StoreListitem {
    int resId; //이미지 저장할 변수
    String title; //가게이름
    String content; //가게명과 설명
    String score;

    public StoreListitem(int resId, String title, String content, String score){
        this.resId = resId;
        this.title = title;
        this.content = content;
        this.score = score;
    }
}

