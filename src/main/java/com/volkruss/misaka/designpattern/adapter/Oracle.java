package com.volkruss.misaka.designpattern.adapter;


public class Oracle implements Database {
    @Override
    public void connect() {
        System.out.println("Oracleデータベースに接続しました。");
    }

    @Override
    public void setup() {
        System.out.println("Oracleのセットアップが完了しました。");
    }
}
