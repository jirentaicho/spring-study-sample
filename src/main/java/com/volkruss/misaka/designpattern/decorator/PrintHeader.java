package com.volkruss.misaka.designpattern.decorator;

public class PrintHeader extends PrintDecorator{

    public PrintHeader(Print print) {
        super(print);
    }

    @Override
    public void print(String message) {
        System.out.println("ヘッダーの出力を行う");
        callPrint(message);
    }
}
