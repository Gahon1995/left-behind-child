package com.gahon.leftchild.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Gahon
 * @date 2018/11/17.
 */
public class User {
    /**
     * 负责人uid
     */
    @Id
    private Integer uid;

    private String username;
    @JsonIgnore
    private String password;

    /**
     * 性别：0-女，1-男
     */
    private Integer sex;

    private String phone;

    private String email;

    /**
     * 注册时间
     */
    @Column(name = "register_date")
    private Date registerDate;

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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取性别：0-女，1-男
     *
     * @return sex - 性别：0-女，1-男
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别：0-女，1-男
     *
     * @param sex 性别：0-女，1-男
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取注册时间
     *
     * @return register_date - 注册时间
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * 设置注册时间
     *
     * @param registerDate 注册时间
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}