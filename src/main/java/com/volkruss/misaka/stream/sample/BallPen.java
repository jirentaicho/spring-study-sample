package com.volkruss.misaka.stream.sample;

public class BallPen implements Pen{
    @Override
    public void use(String str) {
        System.out.println("Ball Pen" + str);
    }
}
