package com.vip.movie.search.sbean;

/**
 * Created by wangjiao on 2017/12/10.
 */

public class Insert {
    private String keyword;
    private String pnum;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public Insert(String s, int i) {
        super();
    }

    public Insert(String keyword, String pnum) {
        this.keyword = keyword;
        this.pnum = pnum;
    }
}
