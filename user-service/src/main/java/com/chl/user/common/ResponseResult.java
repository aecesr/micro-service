package com.chl.user.common;

import lombok.Data;

@Data
public class ResponseResult {
    private Integer code;

    private String msg;

    private Object data;

    private ResponseResult() {
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseResult success() {
        ResponseResult result = new ResponseResult();
        result.setResultCode(com.chl.user.common.ResultCode.SUCCESS);
        return result;
    }

    public static ResponseResult success(Object data) {
        ResponseResult result = new ResponseResult();
        result.setResultCode(com.chl.user.common.ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static ResponseResult failure(com.chl.user.common.ResultCode resultCode) {
        ResponseResult result = new ResponseResult();
        result.setResultCode(resultCode);
        return result;
    }

    public static ResponseResult failure(com.chl.user.common.ResultCode resultCode, Object data) {
        ResponseResult result = new ResponseResult();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public void setResultCode(com.chl.user.common.ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }
}
