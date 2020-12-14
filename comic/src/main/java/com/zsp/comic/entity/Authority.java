package com.zsp.comic.entity;

import java.io.Serializable;

/**
 * @author gan
 * @create 2020-11-30 11:16
 */
public class Authority implements Serializable {
    private Integer id;
    private String authority;

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
