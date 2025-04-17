package com.mervy;

public class Pair<U, V> {
    protected U fst;
    protected V snd;
    public Pair(U fst, V snd) {
        this.fst = fst;
        this.snd = snd;
    }
    public Pair(){
        this.fst = null;
        this.snd = null;
    }
    public U getFst() {
        return fst;
    }
    public void setFst(U fst) {
        this.fst = fst;
    }
    public V getSnd() {
        return snd;
    }
    public void setSnd(V snd) {
        this.snd = snd;
    }
    @Override
    public String toString() {
        return "Pair{" +
                "fst=" + fst +
                ", snd=" + snd +
                "}";
    }
}
