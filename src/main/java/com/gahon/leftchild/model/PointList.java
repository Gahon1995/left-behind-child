package com.gahon.leftchild.model;

public class PointList {
    private String pointName;
    private Integer pid;

    public PointList() {
    }

    public PointList(String pointName, Integer pid) {
        this.pointName = pointName;
        this.pid = pid;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
