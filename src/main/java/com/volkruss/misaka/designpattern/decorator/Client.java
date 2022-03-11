package com.volkruss.misaka.designpattern.decorator;

public class Client {
    public void test(){
        Print printer = new Printer();
        printer = new PrintHeader(printer);
        printer.print("大変いつもお世話名になっております。");
    }
}
