package com.gahon.leftchild.model.admin;

import com.gahon.leftchild.model.Demand;

/**
 * @author Gahon
 */
public class AdminDemand extends Demand {
    private String pointName;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    private String owner;
    private String helper;

    public AdminDemand(String pointName, String username, String helper, Demand demand) {
        super(demand);
        this.pointName = pointName;
        this.owner = username;
        this.helper = helper;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getHelper() {
        return helper;
    }

    public void setHelper(String helper) {
        this.helper = helper;
    }

    @Override
    public String toString() {
        return "AdminDemand{" +
                "pointName='" + pointName + '\'' +
                ", owner='" + owner + '\'' +
                ", helper='" + helper + '\'' +
                super.toString()+
                '}';
    }
}
