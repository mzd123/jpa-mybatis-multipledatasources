package com.mzd.multipledatasources.bean.Multi;

import java.util.List;

import com.mzd.multipledatasources.bean.Single2.TeachersBean;

public class ClassAndTeacher {
	private String classid;
	private String classname;
	private String classno;
	private List<TeachersBean> listteacher;

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getClassno() {
		return classno;
	}

	public void setClassno(String classno) {
		this.classno = classno;
	}

	public List<TeachersBean> getListteacher() {
		return listteacher;
	}

	public void setListteacher(List<TeachersBean> listteacher) {
		this.listteacher = listteacher;
	}

}
