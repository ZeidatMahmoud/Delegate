package com.zeidat.finalcar.models;

public class Cookie {

//    {
//        "token": "skWJQVaUq4gNSRdZgbkNo0qjTfEG7Y",
//            "createdAt": 1549294764105,
//            "updatedAt": 1549294764105,
//            "roles": [
//        "ROLE_TEACHER"
//    ]
//    }


    private String token ;
    private String createdAt ;
    private String updatedAt ;
    private String[] roles ;


    public Cookie(String token, String createdAt, String updatedAt, String[] roles) {
        this.token = token;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.roles = roles;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
