package com.volkruss.misaka.designpattern.bridge.ex;

public class OracleDriverAdapter implements Driver{

    private OracleDriver driver;

    public OracleDriverAdapter(){
        this.driver = new OracleDriver();
    }

    @Override
    public void connect(String url) {
        this.driver.connect(url,"read setting");
    }
}
