package com.gahon.leftchild.model.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gahon.leftchild.model.Point;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.util.Date;


/**
 * 管理员几面表
 * @author han
 */
public class AdminPoint {
    /**
     * id
     */
    private Integer pid;
    /**
     * 负责人uid
     */
    @ApiModelProperty(value = "负责人uid")
    private String username;
    /**
     * 帮扶人uid
     */
    @ApiModelProperty(value = "帮扶人uid")
    private String helper;
    /**
     * 服务点名称
     */
    @ApiModelProperty(value = "服务点名称")
    private String title;
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

    /**
     * 该服务点的描述
     */
    @ApiModelProperty(value = "该服务点的描述")
    private String describe;

    /**
     * 审核状态：0正在审核，1通过审核，-1审核不通过
     */
    @ApiModelProperty(value = "审核状态：0正在审核，1通过审核，-1审核不通过")
    private Integer state;

    public AdminPoint(String username, String helper, Point point) {
        this.pid = point.getPid();
        this.username = username;
        this.helper = helper;
        this.title = point.getTitle();
        this.province = point.getProvince();
        this.city = point.getCity();
        this.district = point.getDistrict();
        this.address = point.getAddress();
        this.lat = point.getLat();
        this.lng = point.getLng();
        this.describe = point.getDescribe();
        this.state = point.getState();
        this.detail = point.getDetail();
        this.createTime = point.getCreateTime();
    }

    @Override
    public String toString() {
        return "AdminPoint{" +
                "pid=" + pid +
                ", username='" + username + '\'' +
                ", helper='" + helper + '\'' +
                ", title='" + title + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", describe='" + describe + '\'' +
                ", state=" + state +
                ", detail='" + detail + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHelper() {
        return helper;
    }

    public void setHelper(String helper) {
        this.helper = helper;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 审核说明
     */
    @ApiModelProperty(value = "审核说明")
    private String detail;

    /**
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间")
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
