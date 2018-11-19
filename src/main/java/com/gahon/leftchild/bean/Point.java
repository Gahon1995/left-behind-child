package com.gahon.leftchild.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Gahon
 * @date 2018/11/17.
 */
@ApiModel(value = "返回说明，当使用points方法调用时只返回id、经度和纬度这三个值")
public class Point {
    @Id
    @KeySql(dialect = IdentityDialect.MYSQL)
    @ApiModelProperty(value = "唯一id标志")
    private Integer pid;

    /**
     * 负责人uid
     */
    @ApiModelProperty(value = "负责人uid")
    private Integer uid;
    /**
     * 帮扶人uid
     */
    @ApiModelProperty(value = "帮扶人uid")
    private Integer vid;
    /**
     * 服务点名称
     */
    @ApiModelProperty(value = "服务点名称")
    private String title;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
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
     * 该点所属城市
     */
    @ApiModelProperty(value = "该点所属城市")
    private String city;

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

    @Override
    public String toString() {
        return "Point{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", vid=" + vid +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", city='" + city + '\'' +
                ", describe='" + describe + '\'' +
                ", state=" + state +
                ", detail='" + detail + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取负责人uid
     *
     * @return uid - 负责人uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置负责人uid
     *
     * @param uid 负责人uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }


    /**
     * 获取负责人vid
     *
     * @return vid - 负责人vid
     */
    public Integer getVid() {
        return vid;
    }

    /**
     * 设置负责人vid
     *
     * @param vid 负责人vid
     */
    public void setVid(Integer vid) {
        this.vid = vid;
    }

    /**
     * 获取服务点名称
     *
     * @return title - 服务点名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置服务点名称
     *
     * @param title 服务点名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取纬度
     *
     * @return lat - 纬度
     */
    public String getLat() {
        return lat;
    }

    /**
     * 设置纬度
     *
     * @param lat 纬度
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 获取经度
     *
     * @return lng - 经度
     */
    public String getLng() {
        return lng;
    }

    /**
     * 设置经度
     *
     * @param lng 经度
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * 获取该点所属城市
     *
     * @return city - 该点所属城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置该点所属城市
     *
     * @param city 该点所属城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取该服务点的描述
     *
     * @return describe - 该服务点的描述
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置该服务点的描述
     *
     * @param describe 该服务点的描述
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
     * 获取审核状态：0正在审核，1通过审核，-1审核不通过
     *
     * @return state - 审核状态：0正在审核，1通过审核，-1审核不通过
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置审核状态：0正在审核，1通过审核，-1审核不通过
     *
     * @param state 审核状态：0正在审核，1通过审核，-1审核不通过
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取审核说明
     *
     * @return detail - 审核说明
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置审核说明
     *
     * @param detail 审核说明
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获取申请时间
     *
     * @return create_time - 申请时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置申请时间
     *
     * @param createTime 申请时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}