package com.volkruss.misaka.designpattern.bridge;

public class AnhydrousCook implements Cook{
    @Override
    public void cook() {
        System.out.println("無水調理を行いました。");
    }
}
