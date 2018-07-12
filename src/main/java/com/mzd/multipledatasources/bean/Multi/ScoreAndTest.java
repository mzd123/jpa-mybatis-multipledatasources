package com.mzd.multipledatasources.bean.Multi;

import java.util.List;

import com.mzd.multipledatasources.bean.Single1.TestBean;

public class ScoreAndTest {
	private String userid;
	private String username;
	private List<TestBean> testbeanlist;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<TestBean> getTestbeanlist() {
		return testbeanlist;
	}

	public void setTestbeanlist(List<TestBean> testbeanlist) {
		this.testbeanlist = testbeanlist;
	}

}
