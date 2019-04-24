package com.jxf.ourpai.model;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author Jin Xiaofeng
 */
public class MovieName {
    @Id
    private Integer id;
    private String movieName;
    private String fullpathName;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getFullpathName() {
        return fullpathName;
    }

    public void setFullpathName(String fullpathName) {
        this.fullpathName = fullpathName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
