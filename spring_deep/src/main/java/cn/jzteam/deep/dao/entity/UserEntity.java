package cn.jzteam.deep.dao.entity;

import java.util.Date;

public class UserEntity {
    private Integer id;

    private String username;

    private String password;

    private String mobile;

    private Date modifytime;

    private Byte deleteflag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Byte getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Byte deleteflag) {
        this.deleteflag = deleteflag;
    }
}