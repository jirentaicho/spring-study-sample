package com.volkruss.misaka.designpattern.decorator;

import java.util.Objects;

/**
 * Printオブジェクトの責務を増やすためのクラス
 *
 * 既存のPrinterクラスを継承せずに処理の拡張をすることが目的です
 *
 */
public abstract class PrintDecorator implements Print {

    private Print print;

    public PrintDecorator(Print print){
        this.print = print;
    }

    public void callPrint(String str){
        if(Objects.nonNull(this.print)){
            this.print.print(str);
        }
    }
}
