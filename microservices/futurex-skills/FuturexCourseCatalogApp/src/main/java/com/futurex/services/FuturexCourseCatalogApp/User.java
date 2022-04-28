package com.futurex.services.FuturexCourseCatalogApp;

import java.math.BigInteger;

public class User {

    public BigInteger userid;

    public BigInteger courseid;

    private String username;


    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public BigInteger getCourseid() {
        return courseid;
    }

    public void setCourseid(BigInteger courseid) {
        this.courseid = courseid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
