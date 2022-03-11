package com.volkruss.misaka.designpattern.bridge.ex;

import java.io.*;
import java.util.Collections;
import java.util.Set;

public class Client {

    public void useDb() throws IOException {
        Access access = new DataAccess(new PostgreDriver());
        access.connect("postgre:0.0.0.0:5432");

        access = new DataAccess(new OracleDriverAdapter());
        access.connect("oracle:0.0.0.0:5432");

        Collections.unmodifiableList()


        try{
            FileInputStream is = new FileInputStream("file.txt");
            InputStreamReader in = new InputStreamReader(is, "SJIS");
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            in.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
