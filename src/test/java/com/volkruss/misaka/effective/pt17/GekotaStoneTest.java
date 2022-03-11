package com.volkruss.misaka.effective.pt17;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class GekotaStoneTest {
    @Test
    public void test_() throws Exception {

        GekotaStone myStone = GekotaStone.of(3000);
        GekotaStone myStone2 = myStone.buy(3000);
        GekotaStone myStone3 = myStone2.pay(1000);

        assertEquals(5000,myStone3.get());
        System.out.println(myStone.toString());
        System.out.println(myStone2.toString());
        System.out.println(myStone3.toString());

        HashSet<String> j = new HashSet<>();
        j.add("a");
    }




}