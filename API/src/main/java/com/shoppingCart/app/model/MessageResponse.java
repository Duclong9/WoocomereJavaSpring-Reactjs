package com.shoppingCart.app.model;

public class MessageResponse {
    private String code;
    private String[] paramCode;
    private String message;
    private String status;
    private Object data;

    public MessageResponse() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String[] getParamCode() {
        return paramCode;
    }

    public void setParamCode(String[] paramCode) {
        this.paramCode = paramCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
