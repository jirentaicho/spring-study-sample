package com.volkruss.misaka.designpattern.bridge.ex;

public abstract class Access {

    protected Driver dirver;

    public Access(Driver driver){
        this.dirver = driver;
    }

    abstract void connect(String url);
}
