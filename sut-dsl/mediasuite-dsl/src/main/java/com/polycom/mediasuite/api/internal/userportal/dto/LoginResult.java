package com.polycom.mediasuite.api.internal.userportal.dto;

/**
 * Created by wgao on 6/12/2016.
 */
public class LoginResult {

    private User user;

    private String token;

    private int sessionTimeout;

    private int passwordStatus;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public int getPasswordStatus() {
        return passwordStatus;
    }

    public void setPasswordStatus(int passwordStatus) {
        this.passwordStatus = passwordStatus;
    }
}
