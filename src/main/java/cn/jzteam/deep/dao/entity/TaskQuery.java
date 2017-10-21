package cn.jzteam.deep.dao.entity;


import java.io.Serializable;
import java.util.Date;

import cn.jzteam.deep.dao.base.PageQuery;



public class TaskQuery extends PageQuery implements Serializable{

	private static final long serialVersionUID=-1L;

	/** id */
	private Integer id;
	/** userId */
	private Integer userId;
	/** task */
	private String task;
	/** date */
	private String date;
	/** time */
	private String time;
	/** modifytime */
	private Date modifytimeBegin;
	private Date modifytimeEnd;
	/** deleteflag */
	private Integer deleteflag;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer value) {
		this.userId = value;
	}

	public String getTask() {
		return this.task;
	}

	public void setTask(String value) {
		this.task = value;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String value) {
		this.date = value;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String value) {
		this.time = value;
	}

	public Date getModifytimeBegin() {
		return this.modifytimeBegin;
	}

	public void setModifytimeBegin(Date value) {
		this.modifytimeBegin = value;
	}

	public Date getModifytimeEnd() {
		return this.modifytimeEnd;
	}

	public void setModifytimeEnd(Date value) {
		this.modifytimeEnd = value;
	}

	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer value) {
		this.deleteflag = value;
	}



}

