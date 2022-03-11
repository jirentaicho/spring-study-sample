package com.volkruss.misaka.designpattern.adapter;

public class MySql implements Database{

    @Override
    public void connect() {
        System.out.println("MySqlデータベースに接続しました。");
    }

    @Override
    public void setup() {
        System.out.println("MySqlのセットアップが完了しました");
    }
}
