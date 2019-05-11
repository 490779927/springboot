package com.example.pojo.generate;

public class AuthUser {
    private Integer authUserId;

    private String authUserName;

    private String authUserPwd;

    public Integer getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(Integer authUserId) {
        this.authUserId = authUserId;
    }

    public String getAuthUserName() {
        return authUserName;
    }

    public void setAuthUserName(String authUserName) {
        this.authUserName = authUserName == null ? null : authUserName.trim();
    }

    public String getAuthUserPwd() {
        return authUserPwd;
    }

    public void setAuthUserPwd(String authUserPwd) {
        this.authUserPwd = authUserPwd == null ? null : authUserPwd.trim();
    }
}