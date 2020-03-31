package com.bw.duanhaitao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:段海涛
 *@Date: 2020-03-31
 *@Time:14:04
 *@Description:${DESCRIPTION}
 **/
@Entity
public class CacheEntity {
    @Id
    private String url;
    private String json;
    @Generated(hash = 1182802822)
    public CacheEntity(String url, String json) {
        this.url = url;
        this.json = json;
    }
    @Generated(hash = 1391258017)
    public CacheEntity() {
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getJson() {
        return this.json;
    }
    public void setJson(String json) {
        this.json = json;
    }
   
}
