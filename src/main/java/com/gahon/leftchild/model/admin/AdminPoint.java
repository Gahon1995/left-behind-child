package com.gahon.leftchild.model.admin;

import com.gahon.leftchild.model.Point;
import io.swagger.annotations.ApiModelProperty;


/**
 * 管理员几面表
 * @author han
 */
public class AdminPoint extends Point {

    @ApiModelProperty(value = "负责人uid")
    private String username;

    public AdminPoint() {
    }

    public AdminPoint(String username, Point point) {
        super(point.getPid(),point.getUid(),point.getTitle(),point.getProvince(),
                point.getCity(),point.getDistrict(),point.getAddress(),point.getLat(),
                point.getLng(),point.getDescribe(),point.getState(),point.getDetail(),point.getCreateTime());
        this.username = username;
    }

    @Override
    public String toString() {
        return "AdminPoint{" +
                ", username='" + username + '\'' +
                super.toString()+
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
