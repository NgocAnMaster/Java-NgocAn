package org.example.regexandexception2;

public class ValidationError {
    private Integer errorCode;
    private String extraInfo;

    public ValidationError(Integer errorCode, String extraInfo) {
        this.errorCode = errorCode;
        this.extraInfo = extraInfo;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
