package com.gahon.leftchild.model.user;

import com.gahon.leftchild.model.Demand;

public class UserDemand extends Demand {
    private String ownerName;
    private String ownerPhone;
    private String helperName;
    private String helperPhone;
    private String pointName;

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public UserDemand() {
    }

    public UserDemand(Demand demand, String pointName, String ownerName, String ownerPhone, String helperName, String helperPhone) {
        super(demand);
        this.pointName = pointName;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.helperName = helperName;
        this.helperPhone = helperPhone;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getHelperName() {
        return helperName;
    }

    public void setHelperName(String helperName) {
        this.helperName = helperName;
    }

    public String getHelperPhone() {
        return helperPhone;
    }

    public void setHelperPhone(String helperPhone) {
        this.helperPhone = helperPhone;
    }
}
