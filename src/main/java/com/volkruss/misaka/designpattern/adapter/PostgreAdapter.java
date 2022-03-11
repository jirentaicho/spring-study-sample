package com.volkruss.misaka.designpattern.adapter;

/**
 * インターフェースもメソッド名も適合していないPostgreクラスのアダプタークラス
 * Databaseインターフェースを実装して、メソッドの実装はPostgreクラスのオブジェクトに委譲することで
 * PostgreクラスをDatabaseインターフェースのものとして利用する
 */
public class PostgreAdapter implements Database{

    // 変数としてPostgreオブジェクトを保持しておく
    private final Postgre postgre;

    public PostgreAdapter(){
        this.postgre = new Postgre();
    }

    @Override
    public void connect() {
        this.postgre.access();
    }

    @Override
    public void setup() {
        this.postgre.init();
    }
}
