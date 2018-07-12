package com.mzd.multipledatasources.mapper.test02;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mzd.multipledatasources.bean.Multi.ClassAndTeacher;

@Repository
public interface ClassAndTeacherMapping {

	List<ClassAndTeacher> selectallclass();

}
