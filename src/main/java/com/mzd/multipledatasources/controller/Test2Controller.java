package com.mzd.multipledatasources.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzd.multipledatasources.bean.Multi.ClassAndTeacher;
import com.mzd.multipledatasources.bean.Single2.TeachersBean;
import com.mzd.multipledatasources.dao.test02.jpa.TeacherDao;
import com.mzd.multipledatasources.service.TestService;

@RestController
public class Test2Controller {
	@Autowired
	private TeacherDao teacherdao;
	@Autowired
	private TestService testservice;

	@RequestMapping("/addteacher.do")
	public String doTest() {
			TeachersBean teacher = new TeachersBean();
			teacher.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			teacher.setTeachername("方老师");
			teacher.setClassid("2");
			teacherdao.save(teacher);
		return "success";
	}

	@RequestMapping("/selectallclass.do")
	public List<ClassAndTeacher> selectallclass() {
		List<ClassAndTeacher> list = testservice.selectallclass();
		return list;
	}

}
