package com.volkruss.misaka.designpattern.decorator;

import org.junit.jupiter.api.Test;

import java.awt.geom.PathIterator;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

/**
 * テストになっていません
 * 動作確認のため
 */
class PrinterTest {
    @Test
    public void Test_(){
        Print printer = new Printer();
    }

    @Test
    public void test_ヘッダー出力ができる(){
        Print printer = new Printer();
        printer = new PrintHeader(printer);
        printer.print("大変いつもお世話になっております");
    }

    @Test
    public void test_ヘッダーフッター出力ができる(){
        Print printer = new Printer();
        printer = new PrintHeader(printer);
        printer = new PrintFooter(printer);
        printer.print("大変いつもお世話になっております");
        // まずFooter#printでFooter#callPrintが呼ばれる
        //   Print#printが呼ばれる（ここではHeaderが設定されているのでHeader#printが呼ばれる)
        //   　　Header#printではヘッダー情報を出力して、Header##callPrintが呼ばれる
        //   　　　　Print#printが出力される(ここは既存のPrinter#print)
        // 最後にFooterの出力が行われる
    }

    @Test
    public void hoge() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter String");
        String s = buf.readLine();
        System.out.print("Enter input: " + s);
    }
}