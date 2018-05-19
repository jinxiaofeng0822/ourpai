package com.jxf.ourpai.model;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 主页浏览量
 * </p>
 *
 * @author JinXiaofeng
 * @since 2018-05-18
 */
public class ViewIndex implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String ip;
	private Date createTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "ViewIndex{" +
			", id=" + id +
			", ip=" + ip +
			", createTime=" + createTime +
			"}";
	}
}
