package com.lhx.bean;

/**
 * Created by lhx on 2016/9/18 16:50
 *
 * @Description
 */
public class Bet {

    private long userId ;
    private long contestId;
    private double money;
    private int support;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getContestId() {
        return contestId;
    }

    public void setContestId(long contestId) {
        this.contestId = contestId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }
}
