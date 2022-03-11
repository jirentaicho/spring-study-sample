package com.volkruss.misaka.stream.sample;

import java.util.function.Supplier;

public class Printer {

    private Pen pen;

    /**
     * Supplierを使って依存の注入を行う。
     *
     * @param factory
     */
    public Printer(Supplier<Pen> factory){
        this.pen = factory.get();
    }

    public void Print(String str){
        this.pen.use(str);
    }
}
