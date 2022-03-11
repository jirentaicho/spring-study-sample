package com.volkruss.misaka.designpattern.bridge;

public class QuickCook implements Cook {
    @Override
    public void cook() {
        System.out.println("早炊きでご飯を炊きました。");
    }
}
