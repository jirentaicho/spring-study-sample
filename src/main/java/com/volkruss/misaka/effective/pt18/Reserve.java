package com.volkruss.misaka.effective.pt18;

public class Reserve{

    private final Mail mail;

    private final int roomNo;

    private boolean done = false;

    public Reserve(int roomNo){
        this.mail = new Mail("user@company.com");
        this.roomNo = roomNo;
    }

    public void getReserve(){
        // 予約処理の実施
        this.done = true;
        System.out.println("予約の完了");

        //　予約できたらメールで連絡する
        this.mail.send(this.roomNo + "予約しました");
    }
}
