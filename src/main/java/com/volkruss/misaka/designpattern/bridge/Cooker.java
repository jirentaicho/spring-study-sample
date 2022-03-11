package com.volkruss.misaka.designpattern.bridge;

public abstract class Cooker {

    /**
     * 処理の実装を、このクラスの実装クラスに持たせるのではなく
     * Cookインターフェースの実装クラスに任せる
     * インターフェースの実装がどのようになっていても結合できるのがポイント
     *  → 様々なインターフェースとの橋渡しをする
     *
     */
    protected final Cook cook;

    public Cooker(Cook cook){
        this.cook = cook;
    }

    abstract void execute();
}
