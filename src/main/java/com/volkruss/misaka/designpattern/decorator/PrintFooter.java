package com.volkruss.misaka.designpattern.decorator;

public class PrintFooter extends PrintDecorator{

    public PrintFooter(Print print) {
        super(print);
    }
    @Override
    public void print(String message) {
        callPrint(message);
        System.out.println("フッターの出力を行います");
    }
}
