package com.mzd.multipledatasources.bean.Single1;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "cs_test")
public class TestBean implements Serializable {
	@Id
	private String id;
	private String userid;
	private int score;
	private String classid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

}
