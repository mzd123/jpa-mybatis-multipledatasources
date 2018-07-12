package com.mzd.multipledatasources.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzd.multipledatasources.bean.Multi.ScoreAndTest;
import com.mzd.multipledatasources.bean.Single1.TestBean;
import com.mzd.multipledatasources.dao.test01.jpa.TestDao;
import com.mzd.multipledatasources.service.TestService;

@RestController
public class Test1Controller {
	@Autowired
	private TestDao testdao;
	@Autowired
	private TestService testservice;

	@RequestMapping("/test.do")
	public String doTest() {
		TestBean t = new TestBean();
		t.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		t.setClassid("2");
		t.setScore(30);
		t.setUserid("4");
		testdao.save(t);
		return "success";
	}

	@RequestMapping("/selectall.do")
	public List<ScoreAndTest> selectall() {
		List<ScoreAndTest> list = testservice.selectall();
		return list;
	}

}
