package com.gahon.leftchild.model;

import com.fasterxml.jackson.annotation.JsonFormat;

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
     * 需求描述，必填
     */
    private String detail;

    /**
     * 需求审核状态，1-通过，0-待审核, -1-不通过
     */
    private Integer status;

    /**
     * 需求申请审核说明
     */
    @Column(name = "review_apply_detail")
    private String reviewApplyDetail;

    /**
     * 帮扶人id
     */
    private Integer hid;

    /**
     * 帮扶申请说明
     */
    @Column(name = "help_detail")
    private String helpDetail;

    /**
     * 申请帮扶状态： -2： 无人申请  -1： 不通过 0：  待审核 1：  通过
     */
    @Column(name = "help_state")
    private Integer helpState;

    /**
     * 帮扶审核说明
     */
    @Column(name = "review_help_detail")
    private String reviewHelpDetail;

    /**
     * 申请时间
     */
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Demand() {
    }

    @Override
    public String toString() {
        return "Demand{" +
                "did=" + did +
                ", pid=" + pid +
                ", detail='" + detail + '\'' +
                ", status=" + status +
                ", reviewApplyDetail='" + reviewApplyDetail + '\'' +
                ", hid=" + hid +
                ", helpDetail='" + helpDetail + '\'' +
                ", helpState=" + helpState +
                ", reviewHelpDetail='" + reviewHelpDetail + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Demand(Demand demand) {
        this.did = demand.did;
        this.pid = demand.pid;
        this.detail = demand.detail;
        this.status = demand.status;
        this.reviewApplyDetail = demand.reviewApplyDetail;
        this.hid = demand.hid;
        this.helpDetail = demand.helpDetail;
        this.helpState = demand.helpState;
        this.reviewHelpDetail = demand.reviewHelpDetail;
        this.createTime = demand.createTime;
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

    /**
     * 获取需求审核状态，1-通过，0-待审核, -1-不通过
     *
     * @return status - 需求审核状态，1-通过，0-待审核, -1-不通过
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置需求审核状态，1-通过，0-待审核, -1-不通过
     *
     * @param status 需求审核状态，1-通过，0-待审核, -1-不通过
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取需求申请审核说明
     *
     * @return review_apply_dtail - 需求申请审核说明
     */
    public String getReviewApplyDetail() {
        return reviewApplyDetail;
    }

    /**
     * 设置需求申请审核说明
     *
     * @param reviewApplyDetail 需求申请审核说明
     */
    public void setReviewApplyDetail(String reviewApplyDetail) {
        this.reviewApplyDetail = reviewApplyDetail;
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
     * 获取帮扶申请说明
     *
     * @return help_detail - 帮扶申请说明
     */
    public String getHelpDetail() {
        return helpDetail;
    }

    /**
     * 设置帮扶申请说明
     *
     * @param helpDetail 帮扶申请说明
     */
    public void setHelpDetail(String helpDetail) {
        this.helpDetail = helpDetail;
    }

    /**
     * 获取申请帮扶状态： -2： 无人申请  -1： 不通过 0：  待审核 1：  通过
     *
     * @return help_state - 申请帮扶状态： -2： 无人申请  -1： 不通过 0：  待审核 1：  通过
     */
    public Integer getHelpState() {
        return helpState;
    }

    /**
     * 设置申请帮扶状态： -2： 无人申请  -1： 不通过 0：  待审核 1：  通过
     *
     * @param helpState 申请帮扶状态： -2： 无人申请  -1： 不通过 0：  待审核 1：  通过
     */
    public void setHelpState(Integer helpState) {
        this.helpState = helpState;
    }

    /**
     * 获取帮扶审核说明
     *
     * @return review_help_detail - 帮扶审核说明
     */
    public String getReviewHelpDetail() {
        return reviewHelpDetail;
    }

    /**
     * 设置帮扶审核说明
     *
     * @param reviewHelpDetail 帮扶审核说明
     */
    public void setReviewHelpDetail(String reviewHelpDetail) {
        this.reviewHelpDetail = reviewHelpDetail;
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