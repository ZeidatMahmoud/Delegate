package com.zeidat.finalcar.models;

import com.google.gson.annotations.SerializedName;

public class LoginUser {
    @SerializedName("nationalId")
    public String userName ;

    @SerializedName("password")
    public String password  ;

    public LoginUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
