package com.springboot.YouHuiWang.Pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Lin
 * @since 2019-10-14
 */

public class SubCidTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Integer id;
    /**
     * 商品在大淘客的二级分类id，该分类为前端分类，一个商品可能有多个二级分类id
     */
    private Integer subcid;

    public SubCidTable() {
    }

    public SubCidTable(Integer id, Integer subcid) {
        this.id = id;
        this.subcid = subcid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubcid() {
        return subcid;
    }

    public void setSubcid(Integer subcid) {
        this.subcid = subcid;
    }

    @Override
    public String toString() {
        return "Subcittable{" +
                ", id=" + id +
                ", subcid=" + subcid +
                "}";
    }
}
