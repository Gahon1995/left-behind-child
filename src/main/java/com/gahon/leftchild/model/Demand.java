package com.gahon.leftchild.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Demand {
    /**
     * UID
     */
    @Id
    private Integer did;

    /**
     * 发起该需求的服务点id
     */
    private Integer pid;

    /**
     * 帮扶人id
     */
    private Integer hid;

    /**
     * 是否有人帮扶，1-有，0-无
     */
    private Integer status;

    /**
     * 需求描述，必填
     */
    private String detail;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间")
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Demand() {
    }

    public Demand(Integer did, Integer pid, Integer hid, Integer status, String detail,Date createTime) {
        this.did = did;
        this.pid = pid;
        this.hid = hid;
        this.status = status;
        this.detail = detail;
        this.createTime = createTime;
    }

    /**
     * 获取UID
     *
     * @return did - UID
     */
    public Integer getDid() {
        return did;
    }

    /**
     * 设置UID
     *
     * @param did UID
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * 获取发起该需求的服务点id
     *
     * @return pid - 发起该需求的服务点id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置发起该需求的服务点id
     *
     * @param pid 发起该需求的服务点id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取帮扶人id
     *
     * @return hid - 帮扶人id
     */
    public Integer getHid() {
        return hid;
    }

    /**
     * 设置帮扶人id
     *
     * @param hid 帮扶人id
     */
    public void setHid(Integer hid) {
        this.hid = hid;
    }

    /**
     * 获取是否有人帮扶，1-有，0-无
     *
     * @return status - 是否有人帮扶，1-有，0-无
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否有人帮扶，1-有，0-无
     *
     * @param status 是否有人帮扶，1-有，0-无
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取需求描述，必填
     *
     * @return detail - 需求描述，必填
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置需求描述，必填
     *
     * @param detail 需求描述，必填
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}