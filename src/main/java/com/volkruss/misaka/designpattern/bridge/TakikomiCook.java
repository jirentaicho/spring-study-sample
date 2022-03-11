package com.volkruss.misaka.designpattern.bridge;

public class TakikomiCook implements Cook{
    @Override
    public void cook() {
        System.out.println("炊きこみで炊きました。");
    }
}
