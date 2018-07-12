package com.mzd.multipledatasources.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzd.multipledatasources.bean.Multi.ClassAndTeacher;
import com.mzd.multipledatasources.bean.Multi.ScoreAndTest;
import com.mzd.multipledatasources.dao.test01.mybatis.TestDao_m;
import com.mzd.multipledatasources.dao.test02.mybatis.ClassAndTeacherDao;

@Service
public class TestService {
	@Resource
	private TestDao_m testdao;
	@Autowired
	private ClassAndTeacherDao classandteacherdao;

	public List<ScoreAndTest> selectall() {
		return testdao.selectall();
	}

	public List<ClassAndTeacher> selectallclass() {
		
		return classandteacherdao.selectallclass();
	}

}
