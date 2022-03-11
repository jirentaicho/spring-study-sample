package com.volkruss.misaka.effective.pt17;

/**
 * ゲコ太石とは、とあるスマホゲームで利用する仮想通過のようなものです。
 * ゲコ太石を購入し消費することで、プレイヤーはガチャを回すことができます。
 */
public final class GekotaStone {

    private final int id;
    private final int amt;

    private GekotaStone(int id,int amt){
        this.id = id;
        this.amt = amt;
    }

    /**
     * 新しいゲコ太石を作成します。
     *
     * @param amt
     * @return
     */
    public static GekotaStone of(int amt){
        return new GekotaStone(1,amt);
    }

    public int get(){
        return this.amt;
    }

    /**
     * ゲコ太石を購入します。
     *
     * @param amt
     * @return
     */
    public GekotaStone buy(int amt){
        return new GekotaStone(this.id + 1,this.amt + amt);
    }

    /**
     * ゲコ太石を消費します。
     *
     * @param amt
     * @return
     */
    public GekotaStone pay(int amt) throws Exception {
        if(this.amt - amt < 0){
            throw new Exception("ゲコ太石が足りません");
        }
        return new GekotaStone(this.id + 1, this.amt - amt);
    }

    /**
     * ゲコ太石の現在の状態を返却します。
     *
     * @return
     */
    @Override
    public String toString() {
        return "GekotaStone{" +
                "id=" + id +
                ", amt=" + amt +
                '}';
    }
}