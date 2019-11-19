package com.springboot.YouHuiWang.Pojo;

import org.springframework.stereotype.Component;


public class SubCategories {

    private long subcid;
    private String subcname;
    private String scpic;
    private int cid;

    public SubCategories(long subcid, String subcname, String scpic, int cid) {
        this.subcid = subcid;
        this.subcname = subcname;
        this.scpic = scpic;
        this.cid = cid;
    }

    public void setSubcid(long subcid) {
        this.subcid = subcid;
    }

    public long getSubcid() {
        return subcid;
    }

    public void setSubcname(String subcname) {
        this.subcname = subcname;
    }

    public String getSubcname() {
        return subcname;
    }

    public void setScpic(String scpic) {
        this.scpic = scpic;
    }

    public String getScpic() {
        return scpic;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "SubCategories{" +
                "subcid=" + subcid +
                ", subcname='" + subcname + '\'' +
                ", scpic='" + scpic + '\'' +
                ", cid=" + cid +
                '}';
    }
}