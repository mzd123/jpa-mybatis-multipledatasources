package com.mzd.multipledatasources.dao.test02.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mzd.multipledatasources.bean.Multi.ClassAndTeacher;
import com.mzd.multipledatasources.mapper.test02.ClassAndTeacherMapping;

@Component
public class ClassAndTeacherDao {
	@Autowired
	private ClassAndTeacherMapping classandteacermapping;

	public List<ClassAndTeacher> selectallclass() {
		return classandteacermapping.selectallclass();
	}

}
