package com.gahon.leftchild.model.user;

import com.gahon.leftchild.model.Demand;
import com.gahon.leftchild.model.Point;
import io.swagger.annotations.ApiModelProperty;

public class UserDemand extends Demand {
    private String ownerName;
    private String ownerPhone;
    private String helperName;
    private String helperPhone;
    private String pointName;

    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    private String province;
    /**
     * 该点所属城市
     */
    @ApiModelProperty(value = "市")
    private String city;
    /**
     * 区
     */
    @ApiModelProperty(value = "区")
    private String district;
    /**
     * 地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private String lat;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private String lng;


    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public UserDemand() {
    }

    public UserDemand(Demand demand, String ownerName, String ownerPhone, String helperName, String helperPhone, Point point) {
        super(demand);
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.helperName = helperName;
        this.helperPhone = helperPhone;
        this.pointName = point.getTitle();
        this.province = point.getProvince();
        if ("市辖区".equals(point.getCity())) {
            this.city = "";
        } else {
            this.city = point.getCity();
        }
        this.district = point.getDistrict();
        this.address = point.getAddress();
        this.lat = point.getLat();
        this.lng = point.getLng();
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
