package com.volkruss.misaka.designpattern.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookerTest {

    @Test
    public void test(){
        Cooker cooker = new RiceCooker(new TakikomiCook());
        cooker.execute();
        cooker = new RiceCooker(new QuickCook());
        cooker.execute();
        Cooker nabe = new PressureCooker(new AnhydrousCook());
        nabe.execute();
    }

}