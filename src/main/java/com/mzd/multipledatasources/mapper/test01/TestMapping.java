package com.mzd.multipledatasources.mapper.test01;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mzd.multipledatasources.bean.Multi.ScoreAndTest;

@Repository
public interface TestMapping {
	List<ScoreAndTest> selectall();

}
