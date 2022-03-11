package com.volkruss.misaka.designpattern.adapter;

/**
 * 既存のPostgreのクラスはそもそも実装するインターフェースもメソッド名も違う。
 * そのためDatabaseインターフェースに適合できないのでポリモーフィズムが利用できない。
 */
public class Postgre implements DataBaseConnection{
    @Override
    public void access() {
        System.out.println("Postgreデータベースに接続しました。");
    }

    @Override
    public void init() {
        System.out.println("Postgreの環境セットアップが完了しました。");
    }
}
