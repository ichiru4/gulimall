package com.atguigu.common.exception;

public enum BizCodeEnume {
    UNKNOW_EXCEPTION(10000,"系统未知异常"),
    VALID_EXCEPTION(10001,"参数格式校验失败"),
    TOO_MANY_REQUEST(10002,"请求流量过大"),
    SMS_CODE_EXCEPTION(10002,"验证码获取频率太高，稍后再试"),
    RPODUCT_UP_EXCEPTION(11000,"商品上架异常"),
    USER_EXIST_EXCEPTION(15001,"用户存在"),
    PHONE_EXIST_EXCEPTION(15002,"手机号存在"),
    NO_STOCK_EXCEPTION(21000,"商品库存不足"),
    LOGINACC_PASSWORD_INVALID_EXCEPTION(15003,"账号密码错误")
    ;
    private Integer code;
    private String msg;
    BizCodeEnume(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
