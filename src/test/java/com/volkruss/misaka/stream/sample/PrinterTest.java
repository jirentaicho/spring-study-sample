package com.volkruss.misaka.stream.sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {
    @Test
    public void test_(){
        Printer printer = new Printer( () -> new BallPen() );
        printer.Print("Misaka Mikoto");
        assertTrue(true);

    }
}