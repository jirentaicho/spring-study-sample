package com.volkruss.misaka.effective.pt18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReserveTest {
    @Test
    public void test(){
        Reserve reserve = new Reserve(12);
        reserve.getReserve();
    }
}