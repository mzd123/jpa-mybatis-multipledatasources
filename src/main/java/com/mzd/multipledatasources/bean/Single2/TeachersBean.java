package com.mzd.multipledatasources.bean.Single2;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "cs_teacher")
public class TeachersBean implements Serializable {
	
	private String id;
	private String teachername;
	private String classid;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

}
