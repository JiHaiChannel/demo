package com.engine;

/**
 * @Author:jihai
 * @Date:2022/8/22
 * @Description:
 */
public class Result {

    private Boolean success;

    private String msg;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Result ok() {
        Result result = new Result();
        result.setSuccess(true);
        return result;
    }

    public static Result fail(String msg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }
}
