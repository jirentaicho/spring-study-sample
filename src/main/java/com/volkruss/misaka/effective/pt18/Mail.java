package com.volkruss.misaka.effective.pt18;

public class Mail {

    private final String to;

    private final String from = "admin@company.com";

    public Mail(String to){
        this.to = to;
    }

    public void send(String str){
        System.out.println(
                "to" + to + " / " +
                "from" + from + " / " +
                "「" + str + "」"
        );
    }
}
