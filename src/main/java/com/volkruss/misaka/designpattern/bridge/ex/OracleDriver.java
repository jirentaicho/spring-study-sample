package com.volkruss.misaka.designpattern.bridge.ex;

public class OracleDriver implements ODriver{
    @Override
    public void connect(String url, String info) {
        System.out.println("Oracleに接続しました" + url + info);
    }
}
