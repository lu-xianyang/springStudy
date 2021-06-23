package com.luxiany.domain;

public class Sale {
    private int id;
    private int gid;
    private int nums;

    public Sale() {
    }

    public Sale(int id, int gid, int nums) {
        this.id = id;
        this.gid = gid;
        this.nums = nums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "sale{" +
                "id=" + id +
                ", gid=" + gid +
                ", nums=" + nums +
                '}';
    }
}
