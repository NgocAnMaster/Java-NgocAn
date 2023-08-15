package org.example.regexandexception;

public class CommonException extends RuntimeException{
    private int errorCode;
    private String extraInfo;

    public CommonException(int errorCode, String extraInfo) {
        this.errorCode = errorCode;
        this.extraInfo = extraInfo;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
