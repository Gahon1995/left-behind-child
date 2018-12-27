package com.gahon.leftchild.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiParam;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Gahon
 * @date 2018/11/17.
 */
public class User extends BaseUser{
    /**
     * 负责人uid
     */
    @Id
    @KeySql(dialect = IdentityDialect.MYSQL)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiParam(hidden = true)
    private Integer uid;


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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerDate;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + super.getUsername() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                '}';
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