package com.volkruss.misaka.designpattern.bridge.ex;

public class PostgreDriver implements Driver{

    @Override
    public void connect(String url) {
        System.out.println("Postgreに接続しました" + url);
    }
}
