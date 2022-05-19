package com.example.myapplication;

public class StoreListitem {
    int resId; //이미지 저장할 변수
    String title;
    String content; //가게명과 설명

    public StoreListitem(int resId, String title, String content){
        this.resId = resId;
        this.title = title;
        this.content = content;
    }
}

