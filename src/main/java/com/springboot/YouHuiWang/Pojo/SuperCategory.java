package com.springboot.YouHuiWang.Pojo;

import org.springframework.stereotype.Component;

import java.util.List;


public class SuperCategory {
    private int cid;
    private String cname;
    private String cpic;
    private List<SubCategories> subcategories;

    public SuperCategory(int cid, String cname, String cpic) {
        this.cid = cid;
        this.cname = cname;
        this.cpic = cpic;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCid() {
        return cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCname() {
        return cname;
    }

    public void setCpic(String cpic) {
        this.cpic = cpic;
    }

    public String getCpic() {
        return cpic;
    }

    public void setSubcategories(List<SubCategories> subcategories) {
        this.subcategories = subcategories;
    }

    public List<SubCategories> getSubcategories() {
        return subcategories;
    }

    @Override
    public String toString() {
        return "SuperCategory{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cpic='" + cpic + '\'' +
                ", subcategories=" + subcategories +
                '}';
    }
}
