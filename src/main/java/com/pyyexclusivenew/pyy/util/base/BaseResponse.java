package com.pyyexclusivenew.pyy.util.base;


import com.pyyexclusivenew.pyy.util.code.CodeEnum;

/**
 * Created by wx on 2017/9/8.
 */
public class BaseResponse {

    private String respDesc;
    private int respCode;
    private Object respData;
    private Object stack;
    private Boolean bool;

    public BaseResponse(CodeEnum code, Object data) {
        this.respCode = code.getCode();
        this.respDesc = code.getDesc();
        this.respData = data;
    }

    public BaseResponse(CodeEnum code) {
        this.respCode = code.getCode();
        this.respDesc = code.getDesc();
    }

    public BaseResponse(CodeEnum code, Object data, Object stack) {
        this.respCode = code.getCode();
        this.respDesc = code.getDesc();
        this.respData = data;
        this.stack = stack;
    }

    public BaseResponse(CodeEnum code, Boolean bool){
        this.respCode=code.getCode();
        this.respDesc=code.getDesc();
        this.bool=bool;
    }


    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public Object getRespData() {
        return respData;
    }

    public void setRespData(Object respData) {
        this.respData = respData;
    }

    public Object getStack() {
        return stack;
    }

    public void setStack(Object stack) {
        this.stack = stack;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

}
