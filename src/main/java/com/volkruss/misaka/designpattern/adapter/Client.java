package com.volkruss.misaka.designpattern.adapter;

public class Client {

    public void use(){

        // Database型のオブジェクトを使う
        Database database = new Oracle();
        database.connect();
        database.setup();

        database = new MySql();
        database.connect();
        database.setup();

        // Postgreだけインターフェースが適合しないためエラー
        // database = new Postgre();

        // そこでadapterを利用する
        database = new PostgreAdapter();
        database.connect();
        database.setup();
    }
}
