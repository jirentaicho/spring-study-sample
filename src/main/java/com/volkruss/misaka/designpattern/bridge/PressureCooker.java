package com.volkruss.misaka.designpattern.bridge;

/**
 * 圧力鍋
 */
public class PressureCooker extends Cooker {

    public PressureCooker(Cook cook) {
        super(cook);
    }

    @Override
    void execute() {
        System.out.println("圧力調理を行います");
        cook.cook();
    }
}
