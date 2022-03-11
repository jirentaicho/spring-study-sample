package com.volkruss.misaka.designpattern.bridge;

/**
 * 炊飯器
 */
public class RiceCooker extends Cooker {


    public RiceCooker(Cook cook) {
        super(cook);
    }

    @Override
    void execute() {
        System.out.println("ご飯を炊きます");
        cook.cook();
    }
}
