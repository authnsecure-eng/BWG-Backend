package com.pcmc.bwg.dto.auth;

public class UnifiedLoginRequest {

    private String username;
    private String userId;
    private String mobileNo;
    private String password;
    private String role;

    public UnifiedLoginRequest() {}

    public UnifiedLoginRequest(String username, String userId, String mobileNo, String password, String role) {
        this.username = username;
        this.userId = userId;
        this.mobileNo = mobileNo;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEffectiveIdentifier() {
        if (userId != null && !userId.trim().isEmpty()) return userId.trim();
        if (username != null && !username.trim().isEmpty()) return username.trim();
        if (mobileNo != null && !mobileNo.trim().isEmpty()) return mobileNo.trim();
        return "";
    }
}
