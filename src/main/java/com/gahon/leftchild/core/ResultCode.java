package com.gahon.leftchild.core;

/**
 * 响应码枚举，参考HTTP状态码的语义
 *
 * @author Gahon
 * @date 2018/11/17.
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200),
    FAIL(400),//失败
    UNAUTHORIZED(50012),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500),//服务器内部错误
    /**
     * token使用的token错误
     */
    WRONG_TOKEN(50008);

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
