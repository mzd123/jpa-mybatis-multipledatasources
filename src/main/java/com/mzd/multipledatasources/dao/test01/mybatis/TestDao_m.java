package com.mzd.multipledatasources.dao.test01.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mzd.multipledatasources.bean.Multi.ScoreAndTest;
import com.mzd.multipledatasources.mapper.test01.TestMapping;

@Component

public class TestDao_m {
	@Autowired
	private TestMapping testmapping;

	public List<ScoreAndTest> selectall() {
		return testmapping.selectall();
	}

}
