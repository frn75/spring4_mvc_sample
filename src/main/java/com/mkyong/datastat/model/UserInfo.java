package com.mkyong.datastat.model;

/**
 * Created by Roman_Frolov on 12/30/2016.
 */
public class UserInfo {

    private String userName;
    private String defaultTablespace;
    private String creationDate;
    private String status;

    public UserInfo() {}

    public UserInfo(String userName, String defaultTableSpace, String creationDate, String status) {
        this.userName = userName;
        this.defaultTablespace = defaultTableSpace;
        this.creationDate = creationDate;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDefaultTablespace() {
        return defaultTablespace;
    }

    public void setDefaultTablespace(String defaultTablespace) {
        this.defaultTablespace = defaultTablespace;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", defaultTablespace='" + defaultTablespace + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
