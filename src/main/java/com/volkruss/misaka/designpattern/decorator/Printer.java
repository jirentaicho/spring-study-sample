package com.volkruss.misaka.designpattern.decorator;

public class Printer implements Print{

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
