package com.gahon.leftchild.utils;

/**
 * @author Gahon
 */
public final class Constants {

    public static final String GOOGLE_MAP_ID = "";
    public static final String GAODE_MAP_ID = "";
    //------------------token----------------
    /**
     * 刷新TOKEN(有返回数据)
     */
    public static final int RESCODE_REFTOKEN_MSG = 1006;
    /**
     * 刷新TOKEN
     */
    public static final int RESCODE_REFTOKEN = 1007;
    /**
     * Token不存在
     */
    public static final int JWT_ERRCODE_NULL = 4000;
    /**
     * Token过期
     */
    public static final int JWT_ERRCODE_EXPIRE = 4001;
    /**
     * 验证不通过
     */
    public static final int JWT_ERRCODE_FAIL = 4002;

    //---------------JWT--------------
    /**
     * 密匙
     */
    public static final String JWT_SECERT = "8677df7fc3a34e26a61c034d5ec8245d";
    /**
     * token有效时间
     */
    public static final long JWT_TTL = 60 * 60 * 1000;

    /**
     * 存储当前登录用户id的字段名
     */
    public static final String CURRENT_USER = "CURRENT_USER";

    /**
     * token有效期（小时）
     */
    public static final int TOKEN_EXPIRES_HOUR = 72;

    /**
     * 存放Authorization的header字段
     */
    public static final String AUTHORIZATION = "Token";

    public static final String ADMIN = "admin";
}
