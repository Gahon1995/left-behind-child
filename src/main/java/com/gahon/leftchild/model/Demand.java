package com.gahon.leftchild.model;

import javax.persistence.*;

public class Demand {
    @Id
    private Integer did;

    private Integer uid;

    /**
     * 需求信息
     */
    private String detail;

    /**
     * @return did
     */
    public Integer getDid() {
        return did;
    }

    /**
     * @param did
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取需求信息
     *
     * @return detail - 需求信息
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置需求信息
     *
     * @param detail 需求信息
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}