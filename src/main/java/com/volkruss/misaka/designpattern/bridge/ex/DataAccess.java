package com.volkruss.misaka.designpattern.bridge.ex;

public final class DataAccess extends Access{

    public DataAccess(Driver driver) {
        super(driver);
    }

    @Override
    void connect(String url) {
        this.dirver.connect(url);
    }
}
