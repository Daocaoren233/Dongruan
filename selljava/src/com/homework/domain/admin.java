package com.homework.domain;

public class admin {
    private Integer adminId;
    private String adminName;
    private String password;

    public admin(){

    }

    public admin(Integer adminId, String adminName, String password) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.password = password;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  "adminId=" + adminId + '\n' +
                ", adminName='" + adminName + '\n' +
                ", password='" + password + '\n';
    }
}
